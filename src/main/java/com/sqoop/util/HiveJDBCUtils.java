package com.sqoop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 工具类：
 * 1、获取数据库Hive链接
 * 2、释放资源
 */
public class HiveJDBCUtils {
    //Hive数据库的驱动

    private static String driver = "org.apache.hive.jdbc.HiveDriver";
    //Hive位置
    private static String url = "jdbc:hive2://127.0.0.1:10000/default";

    //标准JDBC：用户名和密码(省略)
    //注册驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    //获取链接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,"hive","hive");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源
    /*
	 * 问题1： Java,对象引用指向null，什么意思？  --->  该对象会被立即成为GC的对象
	 * 问题2：能不能通过Java的程序干预Java的GC？ --->  不能
	 *       运行Java程序:
	 *       
	 *       java -Xms100m -Xmx200m HelloWorld
	 * 
     */
    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }

        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                st = null;
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
