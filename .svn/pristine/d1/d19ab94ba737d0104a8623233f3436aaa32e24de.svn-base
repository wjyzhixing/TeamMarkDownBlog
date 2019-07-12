/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.zhaoxuyang.blog.mapper.AnalysisMapper;
import net.zhaoxuyang.blog.model.AnalysisArticle;
import net.zhaoxuyang.blog.model.AnalysisGlobal;
import net.zhaoxuyang.blog.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    AnalysisMapper analysisMapper;
    @Override
    public List<AnalysisArticle> listAnalysis(String year,String month) {
        Map<String,String> map = new HashMap<>();
        map.put("year",year);
        map.put("month",month);
        return analysisMapper.listAnalysis(map);
    }

    @Override
    public List<AnalysisGlobal> listGlobal() {
        return analysisMapper.listGlobal();
    }
    
}
