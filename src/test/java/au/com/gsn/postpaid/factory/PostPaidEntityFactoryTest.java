package au.com.gsn.postpaid.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import au.com.gsn.rest.model.AudioPrompt;
import au.com.gsn.rest.model.Txt;
import au.com.jiang.liu.mapvalue.Factory;
import au.com.jiang.liu.mapvalue.MyConfig;
import au.com.jiang.liu.mapvalue.MyEntity;
import au.com.jiang.liu.mapvalue.StrategyFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyConfig.class, PostPaidEntityFactory.class, 
		StrategyFactory.class, AudioPromptFactory.class, TxtFactory.class})
public class PostPaidEntityFactoryTest {

	@Autowired
	private PostPaidEntityFactory testInstance;
	
	@Test
	public void testGetEntity() {
		MyEntity e1 = testInstance.getEntity("au.com.gsn.postpaid.factory.audioprompt", null);
		assertNotNull(e1);
		assertTrue(e1 instanceof AudioPrompt);
		
		MyEntity e2 = testInstance.getEntity("au.com.gsn.postpaid.factory.txt", null);
		assertNotNull(e2);	
		assertTrue(e2 instanceof Txt);
	}
}
