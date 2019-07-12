package com.wmd.hdfs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 用流的方式来操作hdfs<br>
 * 可以指定偏移量的文件部分
 *
 * @author Administrator
 *
 */
public class HDFSStreamAccess {

    private FileSystem fs;
    private Configuration conf;
    private String hdfsUrl = "hdfs://localhost:9000";

    @Before
    public void init() throws IOException, InterruptedException, URISyntaxException {
        conf = new Configuration();
        conf.set("fs.defaultFS", hdfsUrl);
        //拿到操作HDFS的一个实例，并且设置其用户
        fs = FileSystem.get(new URI(hdfsUrl), conf, "hadoop");
    }

    /**
     * 上传
     *
     * @throws Exception
     */
    @Test
    public void upload() throws Exception {
        //后面的true，是指如果文件存在，则覆盖
        FSDataOutputStream fout = fs.create(new Path("/xx.jpg"), true);
        InputStream in = new FileInputStream("C:/Users/Administrator/Pictures/1.png");

        //复制流，并且完成之后关闭流
        IOUtils.copyBytes(in, fout, 1024, true);
    }

    /**
     * 下载
     *
     * @throws Exception
     */
    @Test
    public void download() throws Exception {
        FSDataInputStream fin = fs.open(new Path("/story/output2/part-r-00000"));

        OutputStream out = new FileOutputStream("d://sort.txt");

        IOUtils.copyBytes(fin, out, 1024, true);
    }

    /**
     * 在指定位置读写
     *
     * @throws Exception
     */
    @Test
    public void random() throws Exception {
        FSDataInputStream fin = fs.open(new Path("xx.jpg"));
        //从12的位置开始读
        fin.seek(12);

        OutputStream out = new FileOutputStream("d://axx.jpg");

        IOUtils.copyBytes(fin, out, 1024, true);
    }

}
