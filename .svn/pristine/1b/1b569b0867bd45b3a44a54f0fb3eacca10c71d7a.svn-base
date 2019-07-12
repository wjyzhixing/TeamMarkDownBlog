package com.wmd.story.sort;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class SortMapper extends Mapper<LongWritable, Text, MyLongWritable, Text> {
    private Text text = new Text();
    private MyLongWritable longWritable = new MyLongWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String content = value.toString().trim();
        if(!StringUtils.isBlank(content)){
            String[] split = content.split("\t");
            if(split.length == 2){
                long number = Long.parseLong(split[0]);//出现的次数
                String word = split[1];  //词汇
                longWritable.set(number);
                text.set(word);
                context.write(longWritable,text);
            }
        }
    }
}
