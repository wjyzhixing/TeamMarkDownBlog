package com.sqoop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqoopImportUtil {

    ProcMul pm;

    public SqoopImportUtil() {
        pm = new ProcMul();
    }

    public void importToHdfs(String columns, String whereStr) {
        System.out.println("sqoop start 1!~~");
        try {
            String[] cmdstring1 = {"/bin/sh", "-c", "hdfs dfs -rmr  /user/hive/warehouse/"};

            String[] cmdstring2 = {"/bin/sh", "-c", "sqoop import --connect jdbc:mysql://118.24.178.170:3306/test "
                + "--username zhaoxuyang --password zhaoxuyang --table visit_article "
                + "--target-dir /user/hive/warehouse/visit_article" + " -m 1 --fields-terminated-by '\t'"};

            String[] cmdstring3 = {"/bin/sh", "-c", "sqoop import --connect jdbc:mysql://118.24.178.170:3306/test "
                + "--username zhaoxuyang --password zhaoxuyang --table article "
                + "--target-dir /user/hive/warehouse/article --columns id,type,gmt_create" + " -m 1 --fields-terminated-by '\t'"};

            String[] cmdstring4 = {"/bin/sh", "-c", "sqoop import --connect jdbc:mysql://118.24.178.170:3306/test "
                + "--username zhaoxuyang --password zhaoxuyang --table address_diqu "
                + "--target-dir /user/hive/warehouse/address_diqu" + " -m 1 --fields-terminated-by '\t'"};

            String[] cmdstring5 = {"/bin/sh", "-c", "sqoop import --connect jdbc:mysql://118.24.178.170:3306/test "
                + "--username zhaoxuyang --password zhaoxuyang --table address_jingweidu "
                + "--target-dir /user/hive/warehouse/address_jingweidu" + " -m 1 --fields-terminated-by '\t'"};

            String[] cmdstring6 = {"/bin/sh", "-c", "sqoop import --connect jdbc:mysql://118.24.178.170:3306/test "
                + "--username zhaoxuyang --password zhaoxuyang --table address_user "
                + "--target-dir /user/hive/warehouse/address_user" + " -m 1 --fields-terminated-by '\t'"};

            String[] cmdstring7 = {"/bin/sh", "-c", "sqoop import --connect jdbc:mysql://118.24.178.170:3306/test "
                + "--username zhaoxuyang --password zhaoxuyang --table article "
                + "--target-dir /user/hive/warehouse/article_contents --columns 'markdown' " + " -m 1 --fields-terminated-by '\t'"};

//            pm.processMul(cmdstring1);
            //pm.processMul(cmdstring2);
//            pm.processMul(cmdstring3);
//            pm.processMul(cmdstring4);
//            pm.processMul(cmdstring5);
//            pm.processMul(cmdstring6);           
            pm.processMul(cmdstring7);
        } catch (Exception e) {
            System.out.println("执行sqoop exception");
        }
        System.out.println("执行sqoop结束");
    }

//    public static void main(String[] args) {
//        SqoopImportUtil si = new SqoopImportUtil();
//        si.importToHdfs(null, null);
//    }
}
