package com.itwill.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * 데이타베이스 설정정보를 이용해서
 * Connection을 생성하고 해지하는 역할을하는 클래스
 * [Dao객체들이사용하는 클래스]
 */
public class DataSource {
	/****** 데이타베이스 접속정보[124.198.47.195]를 저장할필드 ********/
	private String driverClass;
	private String url;
	private String user;
	private String password;

	/**************************************************************/
	public DataSource() throws Exception {
		/****** jdbc.propetiee파일을 읽어서 데이타베이스 접속정보를 멤버필드저장 ******/
		Properties properties = new Properties();
		/*
		 * jdbc.properties파일은 src/java/main 폴더에 위치해야합니다.
		 */
		InputStream in = DataSource.class.getResourceAsStream("/jdbc.properties");
		properties.load(in);
		this.driverClass = properties.getProperty("driverClass");
		this.url = properties.getProperty("url");
		this.user = properties.getProperty("user");
		this.password = properties.getProperty("password");

	}

	/*
	 * 데이타베이스 접속정보를 이용해서 
	 * Connection객체생성해서 반환하는 메쏘드
	 */
	public Connection getConnection() throws Exception {

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}

	/*
	 * 사용한Connection객체를close하는메쏘드
	 */
	public void close(Connection con) throws Exception {
		con.close();

	}
}
