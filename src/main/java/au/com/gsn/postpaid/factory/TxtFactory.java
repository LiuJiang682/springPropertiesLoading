package au.com.gsn.postpaid.factory;

import au.com.gsn.rest.model.Txt;
import au.com.jiang.liu.mapvalue.Factory;
import au.com.jiang.liu.mapvalue.MyEntity;

public class TxtFactory implements Factory {

	@Override
	public MyEntity makeEntity(Object object) {
		
		return new Txt();
	}
}
