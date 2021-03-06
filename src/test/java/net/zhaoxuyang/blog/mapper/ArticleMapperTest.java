/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.blog.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.zhaoxuyang.blog.model.Article;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author zhaoxuyang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {

    public ArticleMapperTest() {
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

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArticleMapper articleMapper;

//    /**
//     * Test of getById method, of class ArticleMapper.
//     */
//    @Test
//    public void testGetById() {
//        System.out.println("getById");
//        Integer id = 1;
//        
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listAnd method, of class ArticleMapper.
//     */
//    @Test
//    public void testListAnd() {
//        System.out.println("listAnd");
//        Article article = null;
//        ArticleMapper instance = new ArticleMapperImpl();
//        List<Article> expResult = null;
//        List<Article> result = instance.listAnd(article);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listOr method, of class ArticleMapper.
//     */
//    @Test
//    public void testListOr() {
//        System.out.println("listOr");
//        Article article = null;
//        ArticleMapper instance = new ArticleMapperImpl();
//        List<Article> expResult = null;
//        List<Article> result = instance.listOr(article);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of insert method, of class ArticleMapper.
     */
    @Test
    public void testInsert() throws ParseException {
        System.out.println("insert");
        String[] types = {"程序人生", "Python", "Java", "C", "C++", "C#", "前端", "架构", "区块链", "数据库", "游戏开发", "移动开发", "运维", "人工智能", "云计算", "大数据", "研发管理", "物联网", "计算机基础", "其他"};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        for (int i = 0; i < 100000; i++) {
            Article article = new Article();

            Integer userId = ((int) (Math.random() * 1000));
            article.setUserId(userId);
            article.setId(i + 5000000);
            article.setAuth((int) (Math.random() * 3));
            article.setCategory(userId + "-" + (int) (Math.random() * 10000));
            article.setTitle("标题" + i);
            article.setType(types[(int) (Math.random() * types.length)]);
            article.setMarkdown("内容" + i);

            long start = sdf.parse("20120101000000").getTime();
            Date now = new Date();
            long end = now.getTime();
            long time = (long) ((end - start) * Math.random() + start);
            Date gmtCreate = new Date(time);

            article.setGmtCreate(gmtCreate);
            article.setGmtUpdate(gmtCreate);

            article.setSummary(article.createSummary());
            int result = articleMapper.insert(article);
            System.out.println(result + ":" + article);
        }

    }

    /**
     * Test of update method, of class ArticleMapper.
     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Article article = null;
//        ArticleMapper instance = new ArticleMapperImpl();
//        int expResult = 0;
//        int result = instance.update(article);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delete method, of class ArticleMapper.
//     */
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        Article article = null;
//        ArticleMapper instance = new ArticleMapperImpl();
//        int expResult = 0;
//        int result = instance.delete(article);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
