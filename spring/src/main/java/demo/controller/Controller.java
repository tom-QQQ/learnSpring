package demo.controller;

import com.alibaba.fastjson.JSONObject;
import demo.config.ConfigExample;
import demo.dto.AnimeInfo;
import demo.model.factory.HelloFacede;
import demo.model.observer.spring.UserService;
import demo.validtor.AnimeInfoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Ning
 * @date Create in 2018/12/21
 *'@RestController'等价于@Controller+@ResponseBody的结合，使用这个注解的类里面的方法都以json格式输出
 * '@ResponseBody'表示该方法的返回的结果直接写入HTTP响应正文
 */
@RestController
@RequestMapping("/controller")
public class Controller {

    private static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    ConfigExample configExample;

    @Autowired
    UserService userService;

    @Autowired
    HelloFacede helloFacede;

//    @Autowired
//    AnimeBean animeBean;

    /**
     * 绑定 AnimeInfoValidator
     * @param webDataBinder 固定参数
     */
    @InitBinder
    public void initBind(WebDataBinder webDataBinder) {
        // 这里只能添加指向同一个类的参数验证类, 否则会进行参数验证合并, 不能达到一次添加, 多次区分验证的目的
        webDataBinder.addValidators(new AnimeInfoValidator());
    }

    /**
     * 路径作为参数
     * @param var 参数
     * @return 结果
     * 访问地址 url:port/controller/pathVariable/xxx/yyyy-MM-ddTHH:mm:ss.SSSXXX
     * XXX为时差, 如北京时间为+08:00, 推荐只用Date, TIME转换后不使用24小时计时, 分不清上午还是下午
     *
     */
    @RequestMapping("/pathVariable/{var}/{date}")
    ResponseEntity pathVariable(@PathVariable("var") String var,
                                @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logger.info("pathVariable接口参数: var=[{}], date=[{}]", var, simpleDateFormat.format(date));

        JSONObject result = new JSONObject();
        result.put("var", var);
        result.put("date", date);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * "@RequestMapping" 设置参数
     * @param param 参数
     * @return 结果
     * 访问地址 url:port/controller/mapping?param=param
     * 可以使用正则表达式, 只有符合正则表达式的值才能访问
     * consumes 用于设置请求头的value, key为Content-Type
     * produces 标明返回的内容类型为application/json
     * headers 设置仅处理请求头包含key为Referer, value为http://www.google.hk的请求
     * '@RequestHeader'获取请求头中的信息
     *                                 User-Agent: 客户端信息
     *                                 Cookie: 全部cookie
     * '@CookieValue'获取cookie中指定key的值, 使用value指定key, 不指定时, 根据参数名寻找key
     */
    @RequestMapping(value = "/mapping/{regex:[a-z]}", name = "param", consumes = "text/plain", produces = "application/json", headers = "Referer=http://www.google.hk")
    ResponseEntity mappingParam(@PathVariable String regex,
                                String param,
                                @RequestHeader("User-Agent") String userAgent,
                                @RequestHeader("Cookie") String cookie,
                                @CookieValue(value = "token", required = false) String token) {

        logger.info("mappingParam接口参数: regex=[{}], param=[{}]", regex, param);
        JSONObject result = new JSONObject();
        result.put("regex", regex);
        result.put("param", param);
        result.put("userAgent", userAgent);
        result.put("cookie", cookie);
        result.put("token", token);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 参数校验实现
     * @param animeInfo 需要校验的参数对应的类
     * @param bindingResult 参数校验结果
     * @return result
     * '@Valid'用于参数验证, 需要进行绑定和构建验证类 需要实现参数校验类, 参见{@link AnimeInfoValidator}
     */
    @RequestMapping(value = "/addAnimeInfo", method = RequestMethod.POST)
    ResponseEntity addAnimeInfo(@Valid @RequestBody AnimeInfo animeInfo, BindingResult bindingResult) {

        logger.info("addAnimeInfo参数:[{}]", animeInfo);

        if (bindingResult.hasErrors()) {

            JSONObject result = new JSONObject();

            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            result.put("data", objectErrors.get(0).getDefaultMessage());
            return new ResponseEntity<>(result, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(JSONObject.toJSONString(animeInfo), HttpStatus.OK);
        }
    }

    /**
     * 多url匹配
     * 形如: url:port/controller/multipleMatches/ss/ss/ss/urla/s
     * ** 匹配多层路径, ? 匹配单字符不能为空, * 匹配任意字符, 包括空
     * @return result
     */
    @RequestMapping("/multipleMatches/**/url?/*")
    ResponseEntity multipleMatches(@RequestParam (value = "param", required = false, defaultValue = "param") String param) {
        return new ResponseEntity<>("匹配成功, 传入得参数为: " + param, HttpStatus.OK);
    }

    /**
     * 配置文件注入测试
     * @return 配置文件值
     */
    @RequestMapping("/getConfig")
    ResponseEntity getConfig() {

        JSONObject result = new JSONObject();
        result.put("name", configExample.getName());
        result.put("time", configExample.getTime());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 观察者模式测试
     * @return ok
     */
    @RequestMapping("/observer")
    ResponseEntity observer() {
        userService.register("Ning");
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    /**
     * bean工厂测试
     * @param language 语言
     * @param name 名字
     * @return 不同语言说你好
     * 仅仅设置defaultValue时可以不用设置require=false, 没有该参数时会将默认值赋值给该参数
     */
    @RequestMapping("/sayHello")
    ResponseEntity sayHello(@RequestParam(value = "language", defaultValue = "Chinese") String language,
                            @RequestParam(value = "name") String name) {

        try {

            String result = helloFacede.sayHello(language + "HelloService", name);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (BeansException be) {
            return new ResponseEntity<>("还没有这种语言的啦~", HttpStatus.OK);
        }
    }
}
