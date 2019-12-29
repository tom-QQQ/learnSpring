package demo.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 较低版本的spring可以去继承WebMvcConfigurerAdapter类, 高一些的版本中WebMvcConfigurer的方法都为default方法, 不需要配置的可以不用去实现
 * @author Ning
 * @date Create in 2019/4/6
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 配置http请求的Content-Type, 即MIME
     * @param converters 需要添加配置的list
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

//        StringHttpMessageConverter stringConverter= new StringHttpMessageConverter();
//        stringConverter.setDefaultCharset(Charset.forName("UTF-8"));
//        converters.add(stringConverter);

        // 以下的配置包含了charset=UTF-8, 上面的可以不用
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonConverter.setSupportedMediaTypes(supportedMediaTypes);

        converters.add(fastJsonConverter);
    }
}
