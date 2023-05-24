package com.iemr.inventory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.iemr.inventory.utils.IEMRApplBeans;
import com.iemr.inventory.utils.config.ConfigProperties;

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class RoleMasterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(roleMasterApplication, args);
	}

	@Bean
	public ConfigProperties configProperties() {
		return new ConfigProperties();
	}

	@Bean
	public IEMRApplBeans instantiateBeans() {
		return new IEMRApplBeans();
	}

	private static Class<RoleMasterApplication> roleMasterApplication = RoleMasterApplication.class;

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(new Class[] { RoleMasterApplication.class });
	}
}
