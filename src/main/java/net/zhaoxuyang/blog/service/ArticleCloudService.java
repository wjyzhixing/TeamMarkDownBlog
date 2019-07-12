/*
__        ____  __ ____    ____  _     ___   ____ 
\ \      / /  \/  |  _ \  | __ )| |   / _ \ / ___|
 \ \ /\ / /| |\/| | | | | |  _ \| |  | | | | |  _ 
  \ V  V / | |  | | |_| | | |_) | |__| |_| | |_| |
   \_/\_/  |_|  |_|____/  |____/|_____\___/ \____|
 */ 
package net.zhaoxuyang.blog.service;

import net.zhaoxuyang.blog.model.User;
import java.util.List;
import net.zhaoxuyang.blog.model.ArticleCloud;
import net.zhaoxuyang.blog.model.ArticleTopInfo;

/**
 *
 * @author zhaoxuyang
 */
public interface ArticleCloudService {
    
    public List<ArticleCloud> list();

}
