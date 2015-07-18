package au.com.jiang.liu.mapvalue;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MyConfig {

	@Autowired
	@Qualifier("mapper")
	private Properties props;
	
	public Map getProps() {
		return props;
	}
	
	public String getMyProperty(String name) {
		String value = props.getProperty(name);
		return new String(value);
	}
	
	
//	@Bean(name = "mapper")
//	public Properties getMyProperties() throws IOException {System.err.println("Inside getMyproerties");
//		return PropertiesLoaderUtils.loadProperties(new ClassPathResource("factories.properties"));
//	}
	@Bean(name = "mapper")
	public PropertiesFactoryBean mapper() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("factories.properties"));
		return bean;
	}
	
	@Bean
	public MyBean myBean() {
		return new MyBean();
	}
	
//	@Bean(name = "validator")
//	public org.springframework.validation.Validator localValidatorFactoryBean() {
//	   return new LocalValidatorFactoryBean();
//	}
}
