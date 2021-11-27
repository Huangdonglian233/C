package cn.patten.singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Connection {

	private static Connection conn = new Connection();
	Properties pros = new Properties();

	private Connection() {

	}

	public static Connection getInstance() {
		return conn;
	}

	public Properties getConnectioninfo() {
		try {
			pros.load(Connection.class.getClassLoader().getResourceAsStream(
					"cn/patten/singleton/connection.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return pros;
	}
}
