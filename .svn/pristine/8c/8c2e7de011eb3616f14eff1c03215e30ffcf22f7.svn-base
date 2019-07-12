/*
__        ____  __ ____    ____  _     ___   ____ 
\ \      / /  \/  |  _ \  | __ )| |   / _ \ / ___|
 \ \ /\ / /| |\/| | | | | |  _ \| |  | | | | |  _ 
  \ V  V / | |  | | |_| | | |_) | |__| |_| | |_| |
   \_/\_/  |_|  |_|____/  |____/|_____\___/ \____|
 */
package net.zhaoxuyang.blog.controller;

import com.github.pagehelper.PageInfo;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.servlet.http.HttpSession;
import static net.zhaoxuyang.blog.controller.AuthorArticleController.LOG;
import net.zhaoxuyang.blog.model.AnalysisArticle;
import net.zhaoxuyang.blog.model.AnalysisGlobal;
import net.zhaoxuyang.blog.model.Article;
import net.zhaoxuyang.blog.model.ArticleCloud;
import net.zhaoxuyang.blog.model.User;
import net.zhaoxuyang.blog.service.AnalysisService;
import net.zhaoxuyang.blog.service.ArticleCloudService;
import net.zhaoxuyang.blog.service.ArticleTopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 来宾（未登录者） - 控制器类
 *
 * @author zhaoxuyang
 */
@Controller
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    AnalysisService analysisService;

    @Autowired
    ArticleTopInfoService topService;

    @Autowired
    ArticleCloudService cloudService;

    @GetMapping("/start")
    public String signForm() {
        return "Analysis.html";
    }

    @GetMapping("/start/new")
    public String signAnalysis() {
        return "Analysis_3D.html";
    }

    String[] types = {"程序人生", "Python", "Java", "C", "C++", "C#", "前端", "架构", "区块链", "数据库", "游戏开发", "移动开发", "运维", "人工智能", "云计算", "大数据", "研发管理", "物联网", "计算机基础", "其他"};

    @RequestMapping("/articleAnalysis.json")
    @ResponseBody
    public Map<String, Object> articleAnalysis(
            String year,
            String month
    ) {

        System.out.println("year:" + year);
        System.out.println("month:" + month);

        Map<String, Object> result = new HashMap<>();

        List<AnalysisArticle> list = analysisService.listAnalysis(year, month);//所有数据
        System.out.println("analysisresults:" + list);

        //List<AnalysisArticle> filterList = new ArrayList<>();//筛选的数据
        /**
         * 按照月份筛选出数据 for (AnalysisArticle entry : list) { if (year == null ||
         * month == null) { filterList.add(entry); } else if
         * (entry.getYear().equals(year) && entry.getMonth().equals(month)) {
         * //titleSet.add(entry.getTitle());//添加标题集合
         * //daySet.add(entry.getDay());//添加日期集合 filterList.add(entry); } }
         */
        /**
         * x轴
         */
        int maxDay = 0;//日期值最大的数
        for (AnalysisArticle entry : list) {
            int day = Integer.valueOf(entry.getDay());
            System.out.println("eachday:" + day);
            maxDay = (maxDay < day) ? day : maxDay;
        }
        Integer[] x = new Integer[maxDay];
        for (int i = 0; i < x.length; i++) {
            x[i] = i + 1;
        }

        /**
         * y轴
         */
        String[] y = types;

        /**
         * z轴
         */
        int[][] z = new int[x.length * y.length][3];
        for (int i = 0; i < z.length; i++) {
            z[i][1] = (i / x.length) % y.length;
            z[i][0] = i % x.length;
            z[i][2] = 0;
        }

        int maxCnt = 0;
        /**
         * 计算z
         */
        for (int i = 0; i < list.size(); i++) {
            AnalysisArticle entry = list.get(i);//记录
            String day = entry.getDay();//第几天
            int cnt = entry.getCnt();//文章数
            String type = entry.getType();

            // 查找发表日期的下标
            for (int f = 0; f < x.length; f++) {
                if (x[f].equals(Integer.valueOf(day))) {
                    z[i][0] = f;
                }
            }

            // 查找文章分类的下标
            for (int f = 0; f < types.length; f++) {
                if (y[f].equals(type)) {
                    z[i][1] = f;
                }
            }
            z[i][2] = cnt;//数值

            maxCnt = maxCnt < cnt ? cnt : maxCnt;
        }

        result.put("x", x);
        result.put("y", y);
        result.put("z", z);

        result.put("maxCnt", maxCnt);

        // 阅读量
        // 日期
        // 文章标题
        return result;
        //return "success";
    }
//
//    @RequestMapping("/listAll")
//    @ResponseBody
//    public Map<String, Object> listAll(
//            String year,
//            String month,
//            Model model) {
//        //String year=session.getAttribute("year");
//        Map<String, Object> map = new HashMap<String, Object>();
//        
//        System.out.println("year:" + year);
//        System.out.println("month:" + month);
//        
//        List<AnalysisArticle> analysisresults = analysisService.listAnalysis();
//        System.out.println("analysisresults:"+analysisresults);
//        return map;
//    }

    @RequestMapping("/globalAnalysis.json")
    @ResponseBody
    public Map<String, Object> globolAnalysis() {
        Map<String, Object> result = new HashMap<>();

        List<AnalysisGlobal> list = analysisService.listGlobal();

        result.put("dataList", list);

        return result;
    }

    /**
     *
     * @return 键值对
     */
    @RequestMapping("/cloudAnalysis/{num}")
    @ResponseBody

    public Map<String, Object> cloudAnalysis(
            @PathVariable Integer num,
            String userFilter
    ) {
        List<ArticleCloud> dataList = cloudService.list();

        Set<ArticleCloud> dataSet = new TreeSet<>(dataList);

        Set<String> filterSet = new HashSet<>();
        String[] filterStrs = new String[]{
            "《", "》", "<", ">", "?", "!",
            "/", "=", "，", "。", ".", "`",
            "\\", "|", ",", "-", "(", "+",
            "‘", " ", "[", "]", "{", "}", "？",
            "$", "#", "%", "^", "&", "*",
            "\\", "\"", "'", ":", ";", "、", ")",
            "：", "（", "）", "“", "”", "...",
            "【", "】", "；", ">>", "<<"

        };
        System.out.println("LOFFFFF:" + userFilter);
        if (userFilter != null) {
            String[] userFilter2 = userFilter.split(" ");

            int strLen1 = filterStrs.length;// 保存第一个数组长度
            int strLen2 = userFilter2.length;// 保存第二个数组长度
            System.out.println("filter2" + strLen2);

            filterStrs = Arrays.copyOf(filterStrs, strLen1 + strLen2);// 扩容
            System.out.println("filterStrs:" + filterStrs);
            System.arraycopy(userFilter2, 0, filterStrs, strLen1, strLen2);// 将第二个数组与第一个数组合并
            System.out.println(filterStrs);

        }

        for (String str : filterStrs) {
            filterSet.add(str);
        }
        List<ArticleCloud> list = new ArrayList<>();

        int i = 0;
        for (ArticleCloud entry : dataList) {
            if (i >= num) {
                break;
            }
            String word = entry.getWord();
            if (!filterSet.contains(word)) {
                list.add(entry);
                i++;
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("cloudList", list);
        System.out.println(result);
        return result;
    }
}
