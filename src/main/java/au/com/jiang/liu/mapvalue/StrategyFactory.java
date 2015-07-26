package au.com.jiang.liu.mapvalue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StrategyFactory {
	
	private static final Logger LOGGER = Logger.getLogger(StrategyFactory.class);

	@Autowired
	@Qualifier("mapper")
	private Properties props;
	
	@Autowired
	@Qualifier("reader")
	private FileReader fileReader;
	
	@Autowired
	@Qualifier("areader")
	private FileReader aReader;
	
	private Map<String, Factory> strategyFactories;
	
	public Factory getFactory(final String name) {
		Factory factory = this.strategyFactories.get(name);
		return factory;
	}
	
	@PostConstruct
	public void doPopulateRepo() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		LOGGER.info("Started doPopulateRepo");
		HashMap<String, Factory> myRepo = new HashMap<>();
		for (Entry<Object, Object> entry : this.props.entrySet()) {
			String key = (String) entry.getKey();
			String className = (String) entry.getValue();
			Class factoryClass = Class.forName(className);
			Factory factory = (Factory) factoryClass.newInstance();
			myRepo.put(key, factory);
		}
		
		LOGGER.warn("about to check fileReader");
		if (fileReader == null) {
			throw new IllegalStateException("fileReader cannot be null");
		} else {
			fileReader.read();
		}
		
		if (aReader == null) {
			throw new IllegalStateException("aReader cannot be null");
		} else {
			aReader.read();
		}
		
		this.strategyFactories = Collections.unmodifiableMap(myRepo);
	}
}
