/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myf.hivetest;

/**
 *
 * @author hadoop
 */
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.Statement;

public class HiveExec {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    //填写hive的IP，之前在配置文件中配置的IP
    private static String Url = "jdbc:hive2://127.0.0.1:10000/";

    private static Connection conn;

    private static PreparedStatement ps;

    private static ResultSet rs;

    //创建连接
    public static Connection getConnnection() {

        try {

            Class.forName(driverName);

            //此处的用户名一定是有权限操作HDFS的用户，否则程序会提示"permission deny"异常
            conn = DriverManager.getConnection(Url, "hive", "hive");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

            System.exit(1);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return conn;

    }

    public static PreparedStatement prepare(Connection conn, String sql) {

        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement(sql);

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return ps;

    }
   


    public  void execSelect(String sql) {

    conn = getConnnection();

//        String sql="select * from "+tablename;
//        String sql = "select * from \n"
//                + "            (select brand_id, count(*) as cnt  from t_alibaba_data\n"
//                + "             where type='1'  and visit_date <= '20150715'\n"
//                + "             group by brand_id) t1\n"
//                + "order by cnt desc limit 5 ";

        System.out.println(sql);

        try {

            ps = prepare(conn, sql);

            rs = ps.executeQuery();

            int columns = rs.getMetaData().getColumnCount();

            while (rs.next()) {

                for (int i = 1; i <= columns; i++) {

                    System.out.print(rs.getString(i));

                    System.out.print("\t\t");

                }

                System.out.println();

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }


}
}
