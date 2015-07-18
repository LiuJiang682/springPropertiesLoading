package au.com.gsn.postpaid.factory;

import au.com.gsn.rest.model.AudioPrompt;
import au.com.jiang.liu.mapvalue.Factory;
import au.com.jiang.liu.mapvalue.MyEntity;

public class AudioPromptFactory implements Factory {

	@Override
	public MyEntity makeEntity(Object object) {
		
		return new AudioPrompt();
	}

}
