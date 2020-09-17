package com.cjean.zoo.applications.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * 配置类，启动的时候加上静态文件
 * @ClassName:   WebMvcConfig  
 * @Description: TODO
 * @author       BurgessLee
 * @date         2019年6月28日  
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	//这里配置静态资源文件的路径导包都是默认的直接导入就可以
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		/**
		 * SpringBoot自动配置本身并不会把/swagger-ui.html
		 * 这个路径映射到对应的目录META-INF/resources/下面
		 * 采用WebMvcConfigurerAdapter将swagger的静态文件进行发布;
		 */
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
		//将所有/static/** 访问都映射到classpath:/static/ 目录下
		registry.addResourceHandler("/static/**")
				.addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
		super.addResourceHandlers(registry);
	}
}

	
