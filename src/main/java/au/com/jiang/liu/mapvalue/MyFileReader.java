package au.com.jiang.liu.mapvalue;

import org.apache.log4j.Logger;

public class MyFileReader implements FileReader {

	private static final Logger LOGGER = Logger.getLogger(MyFileReader.class);
	
	@Override
	public void read() {
		LOGGER.warn("MyFileReader::read");
	}

}
