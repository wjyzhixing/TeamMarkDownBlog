/*
__        ____  __ ____    ____  _     ___   ____ 
\ \      / /  \/  |  _ \  | __ )| |   / _ \ / ___|
 \ \ /\ / /| |\/| | | | | |  _ \| |  | | | | |  _ 
  \ V  V / | |  | | |_| | | |_) | |__| |_| | |_| |
   \_/\_/  |_|  |_|____/  |____/|_____\___/ \____|
 */ 
package net.zhaoxuyang.blog.model;

import java.lang.invoke.MethodHandles;
import java.util.Date;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文章排行类
 *
 * @author maoyufeng
 */
public class ArticleTopInfo {
final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private Integer articleId;//文章ID
    private Integer countTimes;//访问次数
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ArticleTopInfo{" + "articleId=" + articleId + ", countTimes=" + countTimes + ", title=" + title + '}';
    }
    

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getCountTimes() {
        return countTimes;
    }

    public void setCountTimes(Integer countTimes) {
        this.countTimes = countTimes;
    }

}
