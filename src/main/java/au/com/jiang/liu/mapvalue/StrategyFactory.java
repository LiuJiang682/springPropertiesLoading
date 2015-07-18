package au.com.jiang.liu.mapvalue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StrategyFactory {

	@Autowired
	@Qualifier("mapper")
	private Properties props;
	
	private Map<String, Factory> strategyFactories;
	
	public Factory getFactory(final String name) {
		Factory factory = this.strategyFactories.get(name);
		return factory;
	}
	
	@PostConstruct
	public void doPopulateRepo() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		HashMap<String, Factory> myRepo = new HashMap<>();
		for (Entry<Object, Object> entry : this.props.entrySet()) {
			String key = (String) entry.getKey();
			String className = (String) entry.getValue();
			Class factoryClass = Class.forName(className);
			Factory factory = (Factory) factoryClass.newInstance();
			myRepo.put(key, factory);
		}
		
		this.strategyFactories = Collections.unmodifiableMap(myRepo);
	}
}
