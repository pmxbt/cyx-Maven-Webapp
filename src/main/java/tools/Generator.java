package tools;

import java.util.List;

import org.mybatis.generator.config.xml.ConfigurationParser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.internal.DefaultShellCallback;
public class Generator {

	
	public void mbg() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;


		File configFile = new File("./src/main/resources/config/generator.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		myBatisGenerator.generate(null);
	}
	
	public static void main(String[] args) throws Exception {
		try {
			Generator generatorSqlmap = new Generator();
			generatorSqlmap.mbg();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
