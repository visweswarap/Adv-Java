package com.fita.vishwebtut.factory;

import java.util.Locale;

public class DBConnectionFactory {

	public static ConnProvider getInstance(String locale){
		if(locale.equals("en_US")){
			return new MySQLConnection();
		} else if(locale.equals("en_CA")){
			return new PostgresConnection();
		}else {
			return new OracleConnection();
		}
	}
}
