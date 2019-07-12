package com.sqoop.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqoopExportUtil {

    ProcMul pm;

    public SqoopExportUtil() {
        pm = new ProcMul();
    }

    public static void clearInfo() {

        String[] sql = {"truncate table article_top10", "truncate table article_cloud", "truncate table analysis_3d", "truncate table analysis_global"};

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = MySQLJDBCUtils.getConnection();

            st = conn.createStatement();

            st.execute(sql[0]);
            st.execute(sql[1]);

//            while (rs.next()) {
//
//                String ename = rs.getString(2);
//                System.out.println(ename);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HiveJDBCUtils.release(conn, st, rs);
        }
    }

    public void exportToMysql(String columns, String whereStr) {
        clearInfo();
        try {
            String[] cmdstring = {"/bin/sh", "-c", "sqoop export --connect 'jdbc:mysql://118.24.178.170:3306/test?useUnicode=true&characterEncoding=utf-8' "
                + "--username zhaoxuyang --password zhaoxuyang --export-dir '/user/hive/warehouse/article_top10'  --table article_top10   "
                + "-m 1 --fields-terminated-by '\t' "};
            String[] cmdstring2 = {"/bin/sh", "-c", "sqoop export --connect 'jdbc:mysql://118.24.178.170:3306/test?useUnicode=true&characterEncoding=utf-8' "
                + "--username zhaoxuyang --password zhaoxuyang --export-dir '/user/hive/warehouse/article_cloud'  --table article_cloud   "
                + "-m 1 --fields-terminated-by '\t' "};
             String[] cmdstring3 = {"/bin/sh", "-c", "sqoop export --connect 'jdbc:mysql://118.24.178.170:3306/test?useUnicode=true&characterEncoding=utf-8' "
                + "--username zhaoxuyang --password zhaoxuyang --export-dir '/user/hive/warehouse/analysis_3d'  --table analysis_3d   "
                + "-m 1 --fields-terminated-by '\t' "};
             String[] cmdstring4 = {"/bin/sh", "-c", "sqoop export --connect 'jdbc:mysql://118.24.178.170:3306/test?useUnicode=true&characterEncoding=utf-8' "
                + "--username zhaoxuyang --password zhaoxuyang --export-dir '/user/hive/warehouse/analysis_global'  --table analysis_global   "
                + "-m 1 --fields-terminated-by '\t' "};
            pm.processMul(cmdstring);
           pm.processMul(cmdstring2);
//            pm.processMul(cmdstring3);
//            pm.processMul(cmdstring4);

        } catch (Exception e) {
            System.out.println("执行sqoop exception");
        }
        System.out.println("执行sqoop结束");
    }

//    public static void main(String[] args) {
//        SqoopExportUtil sq = new SqoopExportUtil();
//        clearInfo();
//        sq.exportToMysql(null, null);
//    }
}
