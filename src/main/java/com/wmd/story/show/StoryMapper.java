package com.wmd.story.show;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class StoryMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private Text text = new Text();
    private LongWritable longWritable = new LongWritable();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString().trim();
        //剔除空的一行
        if(!StringUtils.isBlank(line)){
            //分词的代码
            Result parse = ToAnalysis.parse(line);
            List<Term> terms = parse.getTerms();
            Iterator<Term> iterator = terms.iterator();
            while (iterator.hasNext()){
                Term term = iterator.next();
                longWritable.set(1);
                text.set(term.getName());
                context.write(text,longWritable);
            }
        }
    }
}
