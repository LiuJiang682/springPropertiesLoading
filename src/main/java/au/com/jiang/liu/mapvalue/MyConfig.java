package au.com.jiang.liu.mapvalue;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
	
	private Map<String, Factory> repo;
	
	public Map getProps() {
		return props;
	}
	
	public String getMyProperty(String name) {
		String value = props.getProperty(name);
		return new String(value);
	}
	
//	@Bean(name = "repository")
//	public Map<String, Factory> repository() {
//		return repo;
//	}


	
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
	
	@Bean(name = "reader")
	public FileReader reader() {
		return new MyFileReader();
	}
	
	@Bean(name = "areader")
	public FileReader aReader() {
		return new AReader();
	}
	
//	@Bean(name = "validator")
//	public org.springframework.validation.Validator localValidatorFactoryBean() {
//	   return new LocalValidatorFactoryBean();
//	}
}
