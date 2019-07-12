/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.hive;

import com.myf.hivetest.HiveExec;
import net.zhaoxuyang.story.*;
import com.wmd.story.show.StoryDriver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zhaoxuyang.blog.model.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zhaoxuyang
 */
public class HiveTest {

    public HiveTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class ArticleAuth.
     */
    @Test
    public void HiveTest() throws IOException, InterruptedException {
        HiveExec hive = new HiveExec();
//        String sql = "select * from \n"
//                + "            (select brand_id, count(*) as cnt  from t_alibaba_data\n"
//                + "             where type='1'  and visit_date <= '20150715'\n"
//                + "             group by brand_id) t1\n"
//                + "order by cnt desc limit 5 ";
//        String sql = "select * from \n"
//                + "(select brand_id, count(*) as cnt  from t_alibaba_data\n"
//                + "where type='1'  and visit_date <= '20150715'\n"
//                + "group by brand_id) t1\n"
//                + "order by cnt desc limit 5";

//        String sql = "select * from "
//                + "            (select brand_id, count(*) as cnt  from t_alibaba_data "
//                + "             where type='1'  and visit_date <= '20150715' "
//                + "             group by brand_id) t1 "
//                + "order by cnt desc limit 5 ";

         String sql = "select * from "
                + "             visit_article ";
       
         
        hive.execSelect(sql);
        // System.out.println(auth.getValue());
    }

}
