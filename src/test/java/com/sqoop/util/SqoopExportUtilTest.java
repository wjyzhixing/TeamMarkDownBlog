/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqoop.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hadoop
 */
public class SqoopExportUtilTest {
    
    public SqoopExportUtilTest() {
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
     * Test of clearInfo method, of class SqoopExportUtil.
     */
    @Test
    public void testClearInfo() {
        System.out.println("clearInfo");
        SqoopExportUtil.clearInfo();
 
    }

    /**
     * Test of exportToMysql method, of class SqoopExportUtil.
     */
    @Test
    public void testExportToMysql() {
        System.out.println("exportToMysql");
        String columns = "";
        String whereStr = "";
        SqoopExportUtil instance = new SqoopExportUtil();
        instance.exportToMysql(columns, whereStr);
       
    }
    
}
