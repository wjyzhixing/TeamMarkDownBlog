
select * from article_cloud where word regexp "[^,.\";/():{}=<#`>!-\\]\\[-]" limit 10;


CREATE TABLE `visit_article` (
  `id` int,
  `visitor_id` int,
  `article_id` int,
  `gmt_create` string
 
) row format delimited fields terminated by '\t';


CREATE TABLE `article` (
  `id` int  ,
  `type` string,
  `gmt_create` timestamp
  
)  row format delimited fields terminated by '\t';


CREATE TABLE `article_contents` (
  `word` string

) row format delimited fields terminated by '\t';


CREATE TABLE `article_cloud` (
  `word` string,
   `count` bigint

) row format delimited fields terminated by '\t';

CREATE TABLE `address_diqu` (
  `id` string  ,
  `sheng` string ,
  `shi` string,
  `xian` string 

)  row format delimited fields terminated by '\t';

CREATE TABLE `address_jingweidu` (
  `shenghui` string ,
  `jingdu` float,
  `weidu` float 

)  row format delimited fields terminated by '\t';

CREATE TABLE `address_user` (
  `id` int ,
  `realname` string,
  `address_id` string  

)  row format delimited fields terminated by '\t';

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


CREATE TABLE `article_top10` (
  `article_id` int,
  `count_times` bigint,
 
) row format delimited fields terminated by '\t';


sqoop import --connect jdbc:mysql://118.24.178.170:3306/test --username zhaoxuyang --password zhaoxuyang --table visit_article --target-dir 'hdfs://zjmyf-pc:9000/hiveTest' -m 1 --hive-import  --hive-table visit_article  --fields-terminated-by '\t'

select * from 
       (select article_id, count(*) as visit  from visit_article
        group by article_id) t1
order by visit desc limit 5

vim  $HADOOP_HOME/etc/hadoop/hdfs-site.xml

<property>
  <name>dfs.permissions.enabled</name>
  <value>false</value>
  <description>
    If "true", enable permission checking in HDFS.
    If "false", permission checking is turned off,
    but all other behavior is unchanged.
    Switching from one parameter value to the other does not change the mode,
    owner or group of files or directories.
  </description>
</property>

  select type,DATE_FORMAT(article.gmt_create,"%Y") as year,DATE_FORMAT(article.gmt_create,"%m") as month,DATE_FORMAT(article.gmt_create,"%d")  as day
        ,count(*)  as cnt from article
        GROUP BY year,month,day,type	
        having year=19 and month=#{ month }


CREATE TABLE article_top10_bac LIKE article_top10 ;
INSERT INTO article_top10_bac SELECT * FROM article_top10;