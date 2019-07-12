/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hive.analysis;

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
public class HiveAnalysisTest {

    public HiveAnalysisTest() {
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
     * Test of createCloud method, of class HiveAnalysis.
     */
    @Test
    public void testCreateCloud() throws Exception {
        System.out.println("createCloud");
        HiveAnalysis.createCloud();
    }

    /**
     * Test of createTop10 method, of class HiveAnalysis.
     */
    @Test
    public void testCreateTop10() {
        System.out.println("createTop10");
        HiveAnalysis.createTop10();
    }

    /**
     * Test of analysisData method, of class HiveAnalysis.
     */
    @Test
    public void testAnalysisData() {
        System.out.println("analysisData");
        HiveAnalysis.analysisData();

    }

    /**
     * Test of createGlobal method, of class HiveAnalysis.
     */
    @Test
    public void testCreateGlobal() {
        System.out.println("createGlobal");
        HiveAnalysis.createGlobal();
    }

    /**
     * Test of create3D method, of class HiveAnalysis.
     */
    @Test
    public void testCreate3D() {
        System.out.println("create3D");
        HiveAnalysis.create3D();
    }

}
