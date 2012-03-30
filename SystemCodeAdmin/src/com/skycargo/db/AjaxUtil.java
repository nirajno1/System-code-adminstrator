package com.skycargo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  this class is used to get next value for transaction id and screen code 
 *  @author Neeraj
 *  */
public class AjaxUtil {
	private static final String TRANSACTION_QUERY="SELECT CONCAT(RULE_DATA_PREFIX,NEXT_VALUE,RULE_DATA_SUFFIX) AS NEXT_ID" +
			" FROM PARAM_GENERATION_RULE NID WHERE" +
			" NID.AIRLINECODE=? AND NID.MODULE_CODE=? AND NID.TRANSACTION_TYPE=? AND NID.REQ_PARAM_ID=?";
	/**
	 * This method is used to fetch next transactionId
	 * 
	 * @param moduleCode
	 * @param airlineCode
	 * @param transactionType values Operations, Master, and others
	 * @return
	 */
public static String getNextTransactionID(String requestType,String moduleCode,String airlineCode,String transactionType){
	Connection connection=null;
	PreparedStatement prepareStatement=null;
	ResultSet resultSet=null;
	String fetchedId="";
	try {
		connection=DBUtils.getConnection();
		 prepareStatement=connection.prepareStatement(TRANSACTION_QUERY);
		 prepareStatement.setString(1, airlineCode);
		 prepareStatement.setString(2, moduleCode);
		 prepareStatement.setString(3, transactionType);
	//	 int requestid=
		 prepareStatement.setInt(4, 7);
		 resultSet = prepareStatement.executeQuery();
		 while(resultSet.next()){
		  fetchedId=resultSet.getString(1);
		 }
		 //System.out.println("NEXT_ID: "+fetchedId);
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBUtils.closeConnection(resultSet, prepareStatement, connection);
	}
	return fetchedId;
}
}
