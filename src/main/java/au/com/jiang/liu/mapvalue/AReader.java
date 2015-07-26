package au.com.jiang.liu.mapvalue;

import org.apache.log4j.Logger;

public class AReader implements FileReader {

	private static final Logger LOGGER = Logger.getLogger(AReader.class);
	
	@Override
	public void read() {
		LOGGER.warn("AReader::read");
	}

}
