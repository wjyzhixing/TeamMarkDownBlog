package com.wmd.story.sort;

import org.apache.hadoop.io.LongWritable;


public class MyLongWritable extends LongWritable {
    @Override
    public int compareTo(LongWritable o) {
        if(o.get() > this.get()){
            return 1;
        }else if (o.get() == this.get()){
            return 0;
        }else{
            return -1;
        }
    }
}
