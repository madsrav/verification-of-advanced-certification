
package com.LambdaTest.constants;

public interface FrameworkConstants {
	
	 String USERDIR = System.getProperty("user.dir");
	 String PROFILEPATH = "./configProperties.properties";

	 public static String getConfigFilePath() {
			return PROFILEPATH;
		}
}
