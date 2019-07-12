/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.blog.service;

import java.util.List;
import net.zhaoxuyang.blog.model.AnalysisArticle;
import net.zhaoxuyang.blog.model.AnalysisGlobal;

/**
 *
 * @author hadoop
 */
public interface AnalysisService {
    public List<AnalysisArticle> listAnalysis(String year,String month);
    public List<AnalysisGlobal> listGlobal();
}
