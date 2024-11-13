package com.LambdaTest.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.LambdaTest.constants.FrameworkConstants;
import com.LambdaTest.enums.ConfigProperties;




public class PropertyFileUtiladv {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private PropertyFileUtiladv() {
	}

	private static Properties properties = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	static {
		try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			properties.load(fileInputStream);
			for (Map.Entry<Object, Object> entry : properties.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	/**
	 * Receives the {@link com.lamdatest.enums.ConfigProperties},converts to lower case , return the corresponding value
	 * for the key from the HashMap
	 * @author Sravan Kumar M
	 * 30-09-2024
	 * @param key To be fetched from property file
	 * @return corresponding value for the requested key
	 */
	public static String readDataFromPropertyFile(ConfigProperties key) {
		if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key)) {
			throw new RuntimeException(
					"Property Name :" + key + " is not Found. Please check config.properties ");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
