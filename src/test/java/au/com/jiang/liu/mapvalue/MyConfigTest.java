package au.com.jiang.liu.mapvalue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MyConfig.class})
public class MyConfigTest {

	@Autowired
	private MyConfig myConfig;
	
	@Autowired
	private MyBean myBean;
	
	@Test
	public void testGet() {
		String value = myConfig.getMyProperty("au.com.gsn.postpaid.factory.audioprompt");
		assertNotNull(value);
		Map map = myConfig.getProps();
		assertNotNull(map);
		
		assertEquals("au.com.gsn.postpaid.factory.AudioPromptFactory", myBean.getProps().get("au.com.gsn.postpaid.factory.audioprompt"));
	}
}
