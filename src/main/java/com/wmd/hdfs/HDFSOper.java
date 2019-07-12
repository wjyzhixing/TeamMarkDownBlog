package com.wmd.hdfs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;

public class HDFSOper {

    private FileSystem fs;
    private Configuration conf;

    private String hdfsUrl = "hdfs://localhost:9000";

    public void init() throws Exception {
        conf = new Configuration();
        conf.set("fs.defaultFS", hdfsUrl);
        //拿到操作HDFS的一个实例，并且设置其用户
        fs = FileSystem.get(new URI(hdfsUrl), conf, "hadoop");
    }

    /**
     * 上传操作<br>
     * 不建议使用这种<br>
     * 这种上传会遇到一个问题，会抛出空指，使用fs.copyFromLocalFile这种命令，会调用hadoop的shell，但是却找不到这个shell，所以需要配置一下HADOOP_HOME的环境变量。
     * 而且这个目录中的hadoop还需要是windows版本的hadoop，所以需要自行在windows版本中编译<br>
     * 当然，也可以不使用shell，可以使用流的形式来上传下载
     *
     * @throws IOException
     * @throws IllegalArgumentException
     */
    public void upload() throws Exception {
        init();
        fs.copyFromLocalFile(new Path("F:\\新-简历.doc"), new Path("/README.txt"));
        fs.close();

    }

    /**
     * 创建文件夹
     *
     * @throws Exception
     */
    public void mkdir() throws Exception {
        init();
        boolean mkdirs = fs.mkdirs(new Path("/mkdir/a/b"));
        if (mkdirs) {
            System.out.println("创建文件夹成功");
        }
        fs.close();
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    public void delete(String str) throws Exception {
        init();
        //递归删除
        boolean delete;
        delete = fs.delete(new Path(str), true);
        if (delete) {
            System.out.println("删除成功");
        }
        fs.close();
    }

    /**
     * 列出文件，可以递归所有文件，它是一个迭代器，因为客户端无法接收所有文件信息
     */
    public void listFile() throws Exception {
        init();
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        while (listFiles.hasNext()) {
            LocatedFileStatus lfs = listFiles.next();
            System.out.println("块大小:" + lfs.getBlockSize());
            System.out.println("所属组:" + lfs.getOwner());
            System.out.println("大小:" + lfs.getLen());
            System.out.println("文件名:" + lfs.getPath().getName());
            System.out.println("是否目录:" + lfs.isDirectory());
            System.out.println("是否文件:" + lfs.isFile());
            System.out.println();
            BlockLocation[] blockLocations = lfs.getBlockLocations();
            for (BlockLocation blockLocation : blockLocations) {
                System.out.println("块偏移数:" + blockLocation.getOffset());
                System.out.println("块长度:" + blockLocation.getLength());
                System.out.println("块名称:" + Arrays.toString(blockLocation.getNames()));
                System.out.println("块名称:" + Arrays.toString(blockLocation.getHosts()));
            }
            System.out.println("--------------------------");
        }
    }

    /**
     * 列出文件，但是不可以递归，所以可以直接用数组存储，
     *
     * @throws Exception
     */
    public void listFile2() throws Exception {
        init();
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : listStatus) {
            System.out.println("块大小:" + fileStatus.getBlockSize());
            System.out.println("所属组:" + fileStatus.getOwner());
            System.out.println("大小:" + fileStatus.getLen());
            System.out.println("文件名:" + fileStatus.getPath().getName());
            System.out.println("是否目录:" + fileStatus.isDirectory());
            System.out.println("是否文件:" + fileStatus.isFile());
        }
    }
}
