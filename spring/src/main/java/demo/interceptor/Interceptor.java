package demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器处理逻辑配置
 * @author Ning
 * @date Create in 2019/4/6
 */
public class Interceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(Interceptor.class);

    /**
     * 预处理回调方法
     * @param request http请求
     * @param response 最终返回的结果
     * @param handler 处理方法
     * @return 是否继续下一个流程
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 从http请求头中取出存放在key为Authorization里的token
        String authHeader = request.getHeader("Authorization");

        if (authHeader.isEmpty()) {
            logger.info("URI: "+request.getRequestURI());

            // 使用401作为返回状态码
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");

            // 返回结果
            JSONObject result = new JSONObject();
            result.put("code", 1);
            result.put("msg", "登陆信息过期");

            response.getWriter().write(JSON.toJSONString(result));
            response.getWriter().flush();
            response.getWriter().close();
            return false;
        }

//        String token = authHeader;
//        String userInfo =


        return super.preHandle(request, response, handler);
    }
}
