package au.com.gsn.postpaid.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.jiang.liu.mapvalue.Factory;
import au.com.jiang.liu.mapvalue.MyEntity;
import au.com.jiang.liu.mapvalue.StrategyFactory;

@Service
public class PostPaidEntityFactory {

	@Autowired
	private StrategyFactory strategyFactory;
	
	public MyEntity getEntity(final String entityName, final Object entityObject) {
		Factory factory = this.strategyFactory.getFactory(entityName);
		if (factory == null) {
			throw new IllegalArgumentException("Unable to get factory for " + entityName);
		}
		
		return factory.makeEntity(entityObject);
	}
}
