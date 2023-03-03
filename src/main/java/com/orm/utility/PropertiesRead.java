package com.orm.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRead {

	Properties prop;

	public PropertiesRead() {

		String path = System.getProperty("user.dir")+"\\TestDataFile\\env1config.properties";
		prop = new Properties();

		try {
			FileInputStream file = new FileInputStream(path);
			prop.load(file);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public String URL() {

		String url = prop.getProperty("url");

		return url;
	}

	public String Username() {

		String username = prop.getProperty("username");

		return username;
	}

	public String Password() {

		String password = prop.getProperty("password");

		return password;
	}

	public String Browser() {

		String browserval = prop.getProperty("browser");

		return browserval;
	}

}
