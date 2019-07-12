package net.zhaoxuyang.blog.sqoop.sche;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hive.analysis.HiveAnalysis;
import com.sqoop.util.SqoopExportUtil;
import com.sqoop.util.SqoopImportUtil;
/**
 * 
 * @author maoyufeng
 */
@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTask {

    private SqoopImportUtil si;
    private SqoopExportUtil se;

    //1.导入定时任务
    /*
    先在hive中创建表：

    CREATE TABLE `visit_article` (
  `id` int,
  `visitor_id` int,
  `article_id` int,
  `gmt_create` string
 
) row format delimited fields terminated by '\t';
    
    CREATE TABLE `article_contents` (
  `word` string

) row format delimited fields terminated by '\t';


CREATE TABLE `article_cloud` (
  `word` string,
   `count` bigint

) row format delimited fields terminated by '\t';
    
    然后在mysql中建表
    
    DROP TABLE IF EXISTS `article_cloud`;
CREATE TABLE `article_cloud` (
  `word` mediumtext NOT NULL,
  `count` bigint NOT NULL

) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `article_top10`;
CREATE TABLE `article_top10` (
  `article_id` int(11) NOT NULL,
  `count_times` bigint NOT NULL

) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
    
    然后开启ssh服务，mysql服务，hadoop启动hdfs与yarn，运行hiveserver2.
    hadoop fs -chmod -R /tmp
    hadoop fs -chmod -R /user/hive
     */
    
    /**
     * 使用sqoop将mysql中待处理的数据导入到hdfs
     */
    @Scheduled(cron = "0 32 8 * * ?")
    private void importTasks() {
        si = new SqoopImportUtil();
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        si.importToHdfs(null, null);
        System.err.println("静态定时任务结束: " + LocalDateTime.now());
    }

    /**
     * 
     * @throws Exception 
     * 使用hive进行数据的分析，将使用sqoop导入的数据进行分析，
     * 生成新的表
     */
    @Scheduled(cron = "0 34 8 * * ?")
    private void analysisTasks() throws Exception {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        HiveAnalysis.createTop10();
        HiveAnalysis.createCloud();
        System.err.println("静态导入定时任务结束: " + LocalDateTime.now());
    }

    /**
     * 将hive处理过后生成的表导出到mysql
     */
    @Scheduled(cron = "0 39 8 * * ?")
    private void exportTasks() {
        se = new SqoopExportUtil();
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        se.exportToMysql(null, null);
        System.err.println("静态定时任务结束: " + LocalDateTime.now());
    }
}
