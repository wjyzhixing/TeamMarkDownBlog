/*
__        ____  __ ____    ____  _     ___   ____ 
\ \      / /  \/  |  _ \  | __ )| |   / _ \ / ___|
 \ \ /\ / /| |\/| | | | | |  _ \| |  | | | | |  _ 
  \ V  V / | |  | | |_| | | |_) | |__| |_| | |_| |
   \_/\_/  |_|  |_|____/  |____/|_____\___/ \____|
 */
package net.zhaoxuyang.blog.model;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文章排行类
 *
 * @author maoyufeng
 */
public class ArticleCloud implements java.lang.Comparable {

    final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private String word;//文章ID
    private Long count;//访问次数

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
    
    @Override
    public int compareTo(Object t) {
        ArticleCloud ac = (ArticleCloud) t;
        return (int) (ac.getCount() - getCount() );//降序
    }

}
