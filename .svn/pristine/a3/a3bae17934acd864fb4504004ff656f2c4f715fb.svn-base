/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.blog.service.impl;

import java.util.List;
import net.zhaoxuyang.blog.model.ArticleTopInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.zhaoxuyang.blog.service.ArticleTopInfoService;
import net.zhaoxuyang.blog.mapper.ArticleTopInfoMapper;


@Service
public class ArticleTopInfoServiceImpl implements ArticleTopInfoService {

    @Autowired
    ArticleTopInfoMapper topMapper;

    @Override
    public List<ArticleTopInfo> list() {
        List<ArticleTopInfo> result  = topMapper.list();

//        PageHelper.startPage(1, 10);
//        List<Country> list = countryMapper.selectIf(1);
        return result;
    }

}
