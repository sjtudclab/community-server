package cn.edu.sjtu.se.dclab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 *2015年3月19日 上午11:00:23
 *@author changyi yuan
 */
public class DataTest {
	
	private static String url = "jdbc:mysql://192.168.1.254:3306/community_server?useUnicode=true&characterEncoding=UTF-8";
	private static String username = "root";
	private static String password = "root";
	
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	private static void connect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,username,password);
	}
	
	private static void addUserRolePermission() throws Exception{
		connect();
		//居委会
		String[] committee = new String[]{"居委会首页","居委会管理","居委会通知","居委会楼栋","居委会市民",
										  "居委会议题","查看述职报告页面","添加述职报告页面","查看房屋",
										  "查看房屋居民信息","管理群众查看居委会","管理群众查看物业","修改管理群众角色",
										  "查看管理群众","查看生活群众","查看服务群众","上传社区公告和社区活动","查看所有角色",
										  "查看具体角色","查看所有议题","修改议题","查看具体议题","查看述职报告",
										  "查看所有述职报告","新建述职报告"};
																	
		//居民
		String[] resident = new String[]{"居民首页","居民查看居委会","居民查看业委会","居民查看物业","居民通知","居民左邻右舍",
										 "居民议题","居民市场","居民维修","居民活动","居民设置",
										 "居民查看它人详细信息","查看所有议题"};
		
		//物业
		String[] tenement = new String[]{"物业首页","物业查看邮箱","物业维修管理","物业设置"};
		
		//业委会
		String[] owner = new String[]{"业委会首页","管理群众查看业委会"};
		
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		ArrayList<Integer> committeeIds = new ArrayList<Integer>();
		ArrayList<Integer> tenementIds = new ArrayList<Integer>();
		ArrayList<Integer> ownerIds = new ArrayList<Integer>();
		ArrayList<Integer> residentIds = new ArrayList<Integer>();
		map.put("居委会",committeeIds);
		map.put("物业", tenementIds);
		map.put("业委会", ownerIds);

		List<String> committeeList = Arrays.asList(committee);
		List<String> tenementList = Arrays.asList(tenement);
		List<String> residentList = Arrays.asList(resident);
		List<String> ownerList = Arrays.asList(owner);
		
		String querySql = "SELECT * FROM permission";
		pst = conn.prepareStatement(querySql);
		rs = pst.executeQuery();
		while(rs.next()){
			int permissionId = rs.getInt("permission_id");
			String desc = rs.getString("description");
			if(committeeList.contains(desc)){
				committeeIds.add(permissionId);
			}else if(tenementList.contains(desc)){
				tenementIds.add(permissionId);
			}else if(ownerList.contains(desc)){
				ownerIds.add(permissionId);
			}else if(residentList.contains(desc)){
				residentIds.add(permissionId);
			}
		}
		
		/*String insertSql = "INSERT INTO user_role_permission (user_role_id,permission_id) values(?,?)";
		for(int id : committeeIds){
			pst = conn.prepareStatement(insertSql);
			pst.setInt(1, 75);
			pst.setInt(2, id);
			pst.execute();
		}
		for(int id : tenementIds){
			pst = conn.prepareStatement(insertSql);
			pst.setInt(1, 76);
			pst.setInt(2, id);
			pst.execute();
		}
		for(int id : residentIds){
			pst = conn.prepareStatement(insertSql);
			pst.setInt(1, 77);
			pst.setInt(2, id);
			pst.execute();
		}*/
		
		querySql = "SELECT ur.user_role_id FROM user_role ur, role r, role_type rt "
				+ "WHERE ur.role_id = r.role_id AND r.role_type_id = rt.role_type_id AND rt.type = ?";
		for(Entry<String,List<Integer>> entry : map.entrySet()){
			pst = conn.prepareStatement(querySql);
			pst.setString(1, entry.getKey());
			rs = pst.executeQuery();
			while(rs.next()){
				int userRoleId = rs.getInt("user_role_id");
				String insertSql = "INSERT INTO user_role_permission (user_role_id,permission_id) values(?,?)";
				for(int id : entry.getValue()){
					pst = conn.prepareStatement(insertSql);
					pst.setInt(1, userRoleId);
					pst.setInt(2, id);
					pst.execute();
				}
			}
		}
		
	}
	
	private static void addApartments() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,username,password);
		String sql = "INSERT INTO apartment (name, owner_id, serial_number, building_id, area)"
				+ "VALUES (?, ?, ?, ?, ?)";

		PreparedStatement pst = conn.prepareStatement(sql);

		Random random = new Random();
		String serial = (random.nextInt(6) + 1) + "0" + random.nextInt(2);
		pst.setString(1, serial);
		pst.setInt(2, random.nextInt(10) + 1);
		pst.setString(3, "31011011303401" + serial);
		pst.setInt(4, random.nextInt(70) + 1);
		pst.setFloat(5, random.nextInt(50) + 50);

		pst.execute();
		//st.executeUpdate(sql);
		//pst.executeBatch();
		//st.close();
		//st.close();
		conn.close();
	}

	private static void addBuildings() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,username,password);
		String sql = "INSERT INTO building (name)"
				+ "VALUES (?)";

		PreparedStatement pst = conn.prepareStatement(sql);

		for (int i = 1; i < 101; ++i) {
			pst.setString(1, i + "栋");
			pst.addBatch();
		}

		pst.executeBatch();
		//st.executeUpdate(sql);
		//pst.executeBatch();
		//st.close();
		//st.close();
		conn.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		/*Map<Integer,String> params = new HashMap<Integer,String>();
		String sql = getParams(params);*/
		
		/*String insertSql = "insert into building (name) values('";
		for(int i = 11;i < 68;i++)		
			operate(insertSql + i + "栋')");*/
		//addBuildings();
		
		/*String deleteSql = "delete from building where id > 11";
		operate(deleteSql);*/
		
		addUserRolePermission();
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
