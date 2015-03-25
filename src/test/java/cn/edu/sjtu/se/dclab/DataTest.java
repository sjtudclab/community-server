package cn.edu.sjtu.se.dclab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *2015年3月19日 上午11:00:23
 *@author changyi yuan
 */
public class DataTest {
	
	private static String url = "jdbc:mysql://192.168.1.254:3306/cs?useUnicode=true&characterEncoding=UTF-8";
	private static String username = "root";
	private static String password = "root";
	
	private static void operate(String sql) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,username,password);
		Statement st = conn.createStatement();
		//PreparedStatement pst = conn.prepareStatement(sql);
		st.executeUpdate(sql);
		//pst.executeBatch();
		st.close();
		st.close();
		conn.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		/*Map<Integer,String> params = new HashMap<Integer,String>();
		String sql = getParams(params);*/
		
		/*String insertSql = "insert into building (name) values('";
		for(int i = 11;i < 68;i++)		
			operate(insertSql + i + "栋')");*/
		for(int i = 1; i <= 100;i++)
			operate(getSql());
		
		/*String deleteSql = "delete from building where id > 11";
		operate(deleteSql);*/
	}
	
	public static String getSql(){
		String sql = "insert into apartment (floor,location,owner,serial_number,building_id) values(";
		Random rand = new Random();
		int floor = rand.nextInt(6) + 1;
		char location = (char) ('A' + rand.nextInt(6));
		int owner = rand.nextInt(13) + 1;
		if(owner == 2 || owner == 4)
			owner += 4;
		int serial = floor*100 + rand.nextInt(2) + 1;
		int building_id = rand.nextInt(127);
		if(building_id > 10 && building_id < 69)
			building_id += 50;
		sql += "'" + floor + "楼',";
		sql += "'" + location + "区',";
		sql += "'" + owner + "',";
		sql += "'31011011303401" + serial + "',";
		sql += building_id + ")";
		return sql;
	}

}
