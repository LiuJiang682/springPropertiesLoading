package au.com.jiang.liu.mapvalue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:brr.properties")
public class MyFileReader implements FileReader {

	private static final Logger LOGGER = Logger.getLogger(MyFileReader.class);
	
	@Value("${num}")
	private int num;
	
	@Override
	public void read() {
		LOGGER.warn("MyFileReader::read " + num);
	}

}
