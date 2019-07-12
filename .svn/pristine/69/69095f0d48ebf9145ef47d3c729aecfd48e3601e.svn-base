/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.blog.service.impl;

import java.util.List;
import net.zhaoxuyang.blog.mapper.ArticleCloudMapper;
import net.zhaoxuyang.blog.model.ArticleCloud;
import net.zhaoxuyang.blog.service.ArticleCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleCloudServiceImpl implements ArticleCloudService {

    @Autowired
    ArticleCloudMapper cloudMapper;

    @Override
    public List<ArticleCloud> list() {
        List<ArticleCloud> result = cloudMapper.list();

        return result;
    }

}
