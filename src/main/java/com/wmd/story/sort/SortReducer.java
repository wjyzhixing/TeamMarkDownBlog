package com.wmd.story.sort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.LongWritable;


public class SortReducer extends Reducer<MyLongWritable, Text, Text, MyLongWritable> {
    @Override
    protected void reduce(MyLongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
         Iterator<Text> iterator = values.iterator();
        while (iterator.hasNext()){
//                Term term = iterator.next();
//                longWritable.set(1);
//                text.set(term.getName());
//                context.write(text,longWritable);
                context.write(iterator.next(),key);
            }
        
    }
}
