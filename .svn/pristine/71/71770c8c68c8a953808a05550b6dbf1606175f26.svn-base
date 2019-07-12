package com.wmd.story.show;

import com.wmd.hdfs.HDFSOper;
import com.wmd.story.sort.MyLongWritable;
import com.wmd.story.sort.SortDriver;
import com.wmd.story.sort.SortMapper;
import com.wmd.story.sort.SortReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.mapreduce.lib.jobcontrol.ControlledJob;
import org.apache.hadoop.mapreduce.lib.jobcontrol.JobControl;

public class StoryDriver {

    HDFSOper oper;

    public void storyshowAndSort(String input, String output1, String output2) throws IOException, ClassNotFoundException, InterruptedException, Exception {
        oper = new HDFSOper();
        oper.delete(output1);

        Configuration configuration = new Configuration();

        configuration.set("fs.defaultFS", "hdfs://127.0.0.1:9000");
        Job job1 = Job.getInstance(configuration);

        job1.setJarByClass(StoryDriver.class);

        job1.setMapperClass(StoryMapper.class);
        job1.setReducerClass(StoryReducer.class);

        job1.setCombinerClass(SortCombiner.class);//设置Combiner

        job1.setMapOutputKeyClass(Text.class);
        job1.setMapOutputValueClass(LongWritable.class);

        job1.setOutputKeyClass(LongWritable.class);
        job1.setOutputValueClass(Text.class);

        Configuration configuration2 = new Configuration();
        configuration2.set("fs.defaultFS", "hdfs://127.0.0.1:9000");
        Job job2 = Job.getInstance(configuration2);

        job2.setJarByClass(SortDriver.class);

        job2.setMapperClass(SortMapper.class);
        job2.setReducerClass(SortReducer.class);

        //如果不设置，默认使用的是TextInputFormat.class
/*        job.setInputFormatClass(CombineTextInputFormat.class);
        CombineTextInputFormat.setMaxInputSplitSize(job,4 * 1024 * 1024);//最大分片
        CombineTextInputFormat.setMinInputSplitSize(job,2 * 1024 * 1024);//最小分片*/
        job2.setMapOutputKeyClass(MyLongWritable.class);
        job2.setMapOutputValueClass(Text.class);

        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(MyLongWritable.class);

        FileInputFormat.setInputPaths(job1, new Path(input));
        FileOutputFormat.setOutputPath(job1, new Path(output1));

        FileInputFormat.setInputPaths(job2, new Path(output1));
        FileOutputFormat.setOutputPath(job2, new Path(output2));

        ControlledJob cJob1 = new ControlledJob(job1.getConfiguration());
        cJob1.setJob(job1);

        ControlledJob cJob2 = new ControlledJob(job2.getConfiguration());
        cJob2.setJob(job2);

        cJob2.addDependingJob(cJob1);

        JobControl jobControl = new JobControl("RecommendationJob");

        jobControl.addJob(cJob1);

        jobControl.addJob(cJob2);

        Thread jobControlThread = new Thread(jobControl);

        jobControlThread.start();

        Thread t = new Thread(jobControl);
        t.start();

        while (true) {
            if (jobControl.allFinished()) {
                //如果作业成功完成，就打印成功作业的信息
                System.out.println(jobControl.getSuccessfulJobList());
                jobControl.stop();
                break;
            }
        }
    }
//
//    public static void main(String[] args) throws Exception {
//
//        StoryDriver sd = new StoryDriver();
//        sd.storyshowAndSort("/dpcq.txt", "/data/sort1", "/data/sort2");
//
//    }
}
