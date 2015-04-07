package cn.edu.sjtu.se.dclab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Huiyi on 2015/4/7.
 */
public class BuildingInsert {

    private static String url = "jdbc:mysql://192.168.1.254:3306/community_server?useUnicode=true&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "root";

    private static Connection conn = null;

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);

        Reader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String input = "";
        while ((input = br.readLine()) != null) {
            String[] data = input.split(" ");
            int buildingName = Integer.parseInt(data[0]);
            int start = Integer.parseInt(data[1]);
            int end = Integer.parseInt(data[2]);
            Set exclude = new HashSet();
            for (int i = 3; i < data.length; ++i) {
                exclude.add(Integer.parseInt(data[i]));
            }

            addBuilding(buildingName, start, end, exclude);
        }

        conn.close();
    }

    public static void addBuilding(int buildingName, int start, int end, Set exclude) throws Exception {
        String sql = "INSERT INTO building (name) VALUES (?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, buildingName + "号");
        pst.execute();
        pst.close();

        sql = "INSERT INTO apartment (name, serial_number, building_id, area)"
                + "VALUES (?, ?, ?, ?)";
        pst = conn.prepareStatement(sql);

        Random random = new Random();
        for (int i = start / 100; i <= end /100; ++i) {
            for (int j = 1; j <=2; ++j) {
                int name = i * 100 + j;
                if (exclude.contains(name))
                    continue;

                pst.setInt(1, name);
                pst.setString(2, "31011011303401" + buildingName + name);
                pst.setInt(3, buildingName);
                pst.setFloat(4, random.nextInt(50) + 50);
                pst.addBatch();
            }
        }
        pst.executeBatch();
        pst.close();
    }
}
