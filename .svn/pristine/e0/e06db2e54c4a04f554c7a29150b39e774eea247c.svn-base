package com.wmd.story.show;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;


    public class SortCombiner extends Reducer<Text, LongWritable, Text, LongWritable> {
    private LongWritable longWritable = new LongWritable();

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        Iterator<LongWritable> iterator = values.iterator();
        long num = 0;
        while (iterator.hasNext()){
            LongWritable longWritable = iterator.next();
            num += longWritable.get();
        }
        longWritable.set(num);
        context.write(key,longWritable);
    }
}
