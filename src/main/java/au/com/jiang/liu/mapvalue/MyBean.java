package au.com.jiang.liu.mapvalue;

import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class MyBean {

	@Value("#{mapper}")
//	@Resource(name = "mapper")
//	private Map<String, String> props;
//	@Autowired
//	@Qualifier("mapper")
	private Properties props;
	
	public Map getProps() {
		return props;
	}
	
//	@Autowired
//	@Qualifier("validator")
//	private Validator validator;
}
