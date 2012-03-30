package com.skycargo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import com.skycargo.servlets.ControlDTO;

public class DBUtils {
	public static final String SYS_PARAM="System Parameter";
	public static final String SYS_PARAM_TABLE="code_sys_params";
	private static final Object COMMA = ",";
	private static final Object QUOATE = "'";
	private static final String GET_TABLE_QUERY = "SELECT request_id,TABLE_NAME,search_column FROM MST_REQUEST_TYPE WHERE REQUEST_TYPE=?";
	private static final String GET_TABLE_COL_QUERY = "select prams.request_param_name, prams.table_col_name "
			+ " from mst_request_type_params prams join mst_request_type req on "
			+ " prams.request_id=req.request_id where req.request_id=? ";
	private static final String GET_TABLE_NAME = "select table_name from mst_request_type m where m.request_id=?";
	private static final String YES = "Y";
	public static Connection getConnection(){
		Context initContext = null;
		Connection conn=null;
		try {
			DataSource ds;
			Context envContext;
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/MYSQLDB");
			conn = ds.getConnection();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
		
public static boolean saveControlDTOs(List<ControlDTO> controlDTOs) throws SQLException {
	boolean returnValue=false;
	//System.out.println("Hello save controls");
	int requsetTypeCode=getRequestTypeCode(controlDTOs.get(0));
	String insertSQL=getInsertTableSQL(requsetTypeCode);
	Iterator<ControlDTO> i=controlDTOs.iterator();
	StringBuffer sbuffer=new StringBuffer(insertSQL);
	StringBuffer params=new StringBuffer();
	StringBuffer values=new StringBuffer();
	String airlineCode=null;
	String modulecode=null;
	String transationType=null;
	while(i.hasNext()){
		ControlDTO controlDTO=i.next();
		if("airlineCode".equals(controlDTO.getControlName())){
			airlineCode=controlDTO.getValue();
		}
		if("module".equals(controlDTO.getControlName())){
			modulecode=controlDTO.getValue();
		}
		if("transactionType".equals(controlDTO.getControlName())){
			transationType=controlDTO.getValue();
		}
		params.append(controlDTO.getTableColName());
		params.append(COMMA);
		values.append(QUOATE);
		values.append(controlDTO.getValue());
		values.append(QUOATE);
		values.append(COMMA);
	}
	params.delete(params.length()-1, params.length());
	values.delete(values.length()-1, values.length());
	//System.out.println(sbuffer);
	//System.out.println(params);
	//System.out.println(values);
	sbuffer.append('(');
	sbuffer.append(params);
	sbuffer.append(')');
	sbuffer.append(" Values ");
	sbuffer.append('(');
	sbuffer.append(values);
	sbuffer.append(')');
	//System.out.println(sbuffer);
	Connection conn=getConnection();
	Statement statement=null;
	try{
	statement= conn.createStatement();
	returnValue=statement.execute(sbuffer.toString());
	if(returnValue && !conn.getAutoCommit()){
		updateNextId(requsetTypeCode,airlineCode,modulecode,transationType);
		conn.commit();
	}
	
	
	}catch(SQLException sqle){
		if(!conn.getAutoCommit()){
			conn.rollback();
		}	
		throw sqle;
	}finally{
		closeConnection(null,statement,conn);
	}
	return returnValue;
}

	


private static void updateNextId(int requsetTypeCode, String airlineCode,
		String modulecode, String transationType) {
	// TODO Auto-generated method stub
	
}

private static int getRequestTypeCode(ControlDTO controlDTO) {
	return controlDTO.getControlId();
}

private static String getInsertTableSQL(int controlId) throws SQLException {
	StringBuffer insertString=null;
	Connection connection=getConnection();
	PreparedStatement ps= connection.prepareStatement(GET_TABLE_NAME);
	ps.setInt(1, controlId);
	
	ResultSet rs=ps.executeQuery();
	String table_name=null;
	while(rs.next()){
		table_name=rs.getString(1);
	}
	if(table_name != null){
		insertString=new StringBuffer("Insert into ");	
		insertString.append(table_name);
	}
	return insertString==null?null:insertString.toString();
}

public static boolean closeConnection(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection){
	boolean returnValue=false;
	if(resultSet != null ){
		try {
			resultSet.close();
			returnValue=true;
		} catch (SQLException ignore) {
			ignore.printStackTrace();
		}
	}
	if(preparedStatement != null ){
		try {
			preparedStatement.close();
			returnValue=true;
		} catch (SQLException ignore) {
			ignore.printStackTrace();
		}
	}
	if(connection != null ){
		try {
			connection.close();
			returnValue=true;
		} catch (SQLException ignore) {
			ignore.printStackTrace();
		}
	}
	return returnValue;
}
public static boolean closeConnection(ResultSet resultSet,Statement statement,Connection connection){
	boolean returnValue=false;
	if(resultSet != null ){
		try {
			resultSet.close();
			returnValue=true;
		} catch (SQLException ignore) {
			ignore.printStackTrace();
		}
	}
	if(statement != null ){
		try {
			statement.close();
			returnValue=true;
		} catch (SQLException ignore) {
			ignore.printStackTrace();
		}
	}
	if(connection != null ){
		try {
			connection.close();
			returnValue=true;
		} catch (SQLException ignore) {
			ignore.printStackTrace();
		}
	}
	return returnValue;
}
public static String getTableName(String codeType){
	if(SYS_PARAM.equals(codeType)){
		return SYS_PARAM_TABLE;
	}
	return null;
}

public static List getSearchResults(String codeType,String airlines,String searchText) throws SQLException{
	//String tableName=getTableName(codeType);
	List returnList=null;
	//get all display columns and 
	Connection conn=getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	int id=0;
	String tableName=null;
	String searchColumn=null;
	try {
		ps=conn.prepareStatement(GET_TABLE_QUERY);
		ps.setString(1, codeType);
		rs=ps.executeQuery();
		while(rs.next()){
			id=rs.getInt(1);
			tableName=rs.getString(2);
			searchColumn=rs.getString(3);
			System.out.println(id);
		}
		List headerList=null;
		List columnList=null;
		List dataList=null;
		if(id!=0){
			ps=conn.prepareStatement(GET_TABLE_COL_QUERY);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			headerList=new ArrayList();
			columnList=new ArrayList();
			dataList=new ArrayList();

			while(rs.next()){
				headerList.add(rs.getString(1));
				columnList.add(rs.getString(2));
			}
		}
		String data_quest=creatSelectQuery(tableName,columnList);
		String query=null;
		if(data_quest != null){
			query=data_quest + " WHERE AIRLINECODE=? ";
		
		if(searchText !=null && !searchText.trim().isEmpty()){
			query+=" AND "+searchColumn+" LIKE ? ";
		}
		System.out.println(query);
		ps=conn.prepareStatement(query);
			ps.setString(1, airlines);

		if(searchText !=null && !searchText.trim().isEmpty()){
			ps.setString(2, "%"+searchText.trim()+"%");
		}
		
		rs=ps.executeQuery();
		while(rs.next()){
			Iterator i=	columnList.iterator();
			List dataRows=new ArrayList();
			while(i.hasNext()){
				String colName=(String) i.next();
				dataRows.add(rs.getString(colName));
			}
			dataList.add(dataRows);
		}
		
		if(dataList != null && dataList.size()>0){
			returnList=new ArrayList();
			returnList.add(headerList);
			returnList.add(dataList);
		}
		System.out.println(data_quest);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw e;
	}finally{
		closeConnection(rs,ps,conn);
		
	}
	
	return returnList;
}

private static String creatSelectQuery(String tableName, List<String> columnList) {
	String query=null;
	if(tableName != null){
		StringBuffer sbuffer=null;
		Iterator<String> i=columnList.iterator();
		sbuffer=new StringBuffer();
		sbuffer.append("SELECT ");
		while(i.hasNext()){
			String col=i.next();
			sbuffer.append(col +", ");
		}
		sbuffer.delete(sbuffer.length()-2, sbuffer.length()-1);
		sbuffer.append(" FROM ");
		sbuffer.append(tableName);
		query=sbuffer.toString();
		//System.out.println("leaving now");
	}
	return query;
}
/**
 * returns list of controls
 * @throws ServletException 
 */
public static List<ControlDTO> getControls(String requestType) throws ServletException{
	List<ControlDTO> list=null;
	Connection connection =null;
	Statement statement=null;
	ResultSet resultSet=null;
	try {
			connection = DBUtils.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select request_id,request_param_name,request_param_data_type," +
					" control_type,col_size,table_col_name,isSystemGenCol from mst_request_type_params where " +
                    " request_id=(select request_id from mst_request_type where request_type='"+requestType+"')");
			
			list=new ArrayList<ControlDTO>();
						
			while(resultSet.next()){
				ControlDTO controlDTO=new ControlDTO();
				controlDTO.setControlId(resultSet.getInt(1));
				controlDTO.setControlDisplayName(resultSet.getString(2));
				controlDTO.setControlName(resultSet.getString(2));
				controlDTO.setControlDataType(resultSet.getString(3));
				controlDTO.setControlType(resultSet.getString(4));
				controlDTO.setControlSize(resultSet.getInt(5));
				controlDTO.setTableColName(resultSet.getString(6));
				controlDTO.setSysGeneratedCol(YES.equals(resultSet.getString(7)));
				
				list.add(controlDTO);
			}
	}catch(SQLException e){
	throw new ServletException(e.getMessage());
	}finally{
		closeConnection(resultSet, statement, connection);
	
	}
		
			return list;
			
	}
}


