package com.hive.analysis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sqoop.util.HiveJDBCUtils;
import com.wmd.hdfs.HDFSOper;
import com.wmd.story.show.StoryDriver;
import java.util.ArrayList;
import java.util.List;
import net.zhaoxuyang.blog.model.AnalysisGlobal;

public class HiveAnalysis {

    public static void createCloud() throws Exception {
        HDFSOper oper = new HDFSOper();
        StoryDriver sd = new StoryDriver();

        String[] sql = new String[2];
        sql[0] = "drop table if exists article_cloud ";
        sql[1] = "CREATE TABLE `article_cloud` ("
                + "  `word` string,"
                + "   `count` bigint"
                + ") row format delimited fields terminated by '\t'";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = HiveJDBCUtils.getConnection();

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
        oper.delete("/tmp/cloud");
        oper.delete("/user/hive/warehouse/article_cloud");
        sd.storyshowAndSort("/user/hive/warehouse/article_contents", "/tmp/cloud", "/user/hive/warehouse/article_cloud");

    }

    public static void createTop10() {
        String[] sql = new String[2];
        sql[0] = "drop table if exists article_top10 ";
        sql[1] = "create table article_top10  row format delimited fields terminated by '\t' as "
                + "select article_id,"
                + "count_times "
                + "from (select article_id,"
                + "    count(visitor_id) as  count_times"
                + "       from visit_article"
                + "       group by article_id"
                + ") t1 order by count_times desc limit 10  ";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = HiveJDBCUtils.getConnection();

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

    public static void analysisData() {
        String sql = "select * from visit_article";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = HiveJDBCUtils.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery(sql);
            while (rs.next()) {

                String ename = rs.getString(2);
                System.out.println(ename);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HiveJDBCUtils.release(conn, st, rs);
        }
    }
    
     public static void createGlobal() {
        String[] sql = new String[2];
        sql[0] = "drop table if exists analysis_global ";
        sql[1] = "create table analysis_global  row format delimited fields terminated by '\t' as "
                + "select address_jingweidu.shenghui,jingdu,weidu,count(*) as renshu from address_diqu,address_jingweidu,address_user "
                + "where address_diqu.id=address_user.address_id and address_jingweidu.shenghui = address_diqu.sheng GROUP BY address_jingweidu.shenghui,jingdu,weidu";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = HiveJDBCUtils.getConnection();

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
     
        public static void create3D() {
        String[] sql = new String[2];
        sql[0] = "drop table if exists analysis_3d ";
        sql[1] = "create table analysis_3d  row format delimited fields terminated by '\t' as "+
                "select type,year,month,day,count(*) as cnt from (select type,DATE_FORMAT(article.gmt_create,\"yyyy\") as year,DATE_FORMAT(article.gmt_create,'MM') as month,DATE_FORMAT(article.gmt_create,'dd') as day from article) aa GROUP BY year,month,day,type";
                

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = HiveJDBCUtils.getConnection();

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

   /* public static List<AnalysisGlobal> analysisglobal() {
        String sql = "select address_jingweidu.shenghui,jingdu,weidu,count(*) as renshu from address_diqu,address_jingweidu,address_user "
                + "where address_diqu.id=address_user.address_id and address_jingweidu.shenghui = address_diqu.sheng GROUP BY address_jingweidu.shenghui,jingdu,weidu";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<AnalysisGlobal> list = new ArrayList<>();
        
        try {
            conn = HiveJDBCUtils.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery(sql);
            while (rs.next()) {
                AnalysisGlobal temp = new AnalysisGlobal();
                String shenghui=rs.getString(1);
                String jingdu = rs.getString(2);
                String weidu = rs.getString(3);
                int renshu = rs.getInt(4);
                System.out.println("AnalysisGlobal"+temp);
                temp.setJingdu(jingdu);
                temp.setRenshu(renshu);
                temp.setShenghui(shenghui);
                temp.setWeidu(weidu);
                
                list.add(temp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HiveJDBCUtils.release(conn, st, rs);
        }
         return list;
    }*/

//    public static void main(String[] args) throws Exception {
//        createCloud();
//       createTop10();
//      //  createGlobal();
//      //  create3D();
//        /*List<AnalysisGlobal> list;
//        list = analysisglobal();*/
//    }

}
