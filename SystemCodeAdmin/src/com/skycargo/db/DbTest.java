package com.skycargo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbTest {
	

public static void main(String[] str){
    /*try {
        Class.forName("com.mysql.jdbc.Driver" );
    } catch (Exception e) {
        System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
        e.printStackTrace();
        return;
    }*/
    Connection c=null;
    Statement s=null;
    ResultSet result=null;
    try {
		//c = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema_systemadmin?profileSQL=true", "root", "admin");
		c=DBUtils.getConnection();
    	System.out.println("Connection created");
		s=c.createStatement();
		System.out.println("statement created");
		result=s.executeQuery("select * from mst_request_type_params");
		
		while(result.next()){
			System.out.println("First Name: "+ result.getString(2));
			System.out.println("Last Name: "+ result.getString(3));
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(result!=null){
			try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(s!=null){
			try {
				s.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(c!=null){
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
}
