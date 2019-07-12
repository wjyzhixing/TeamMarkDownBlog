/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqoop.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author hadoop
 */
public class ProcMul {
      public  void showProcStream(Process proc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            //执行结果加上回车
            sb.append(line).append("\n");

        }
        System.out.println(sb.toString());

        BufferedReader br2 = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        StringBuffer sb2 = new StringBuffer();
        String line2;

        while ((line2 = br2.readLine()) != null) {
            //执行结果加上回车
            sb2.append(line2).append("\n");

        }

        System.out.println(sb2.toString());

//            OutputStream output = proc.getOutputStream();
//
//            byte[] bytes = new byte[1024];
//            output.write(bytes);
//            System.out.println(bytes.toString());
    }

    public  void processMul(String[] cmdstring) throws IOException, InterruptedException {
        Process proc = Runtime.getRuntime().exec(cmdstring);
        proc.waitFor(); //阻塞，直到上述命令执行
        showProcStream(proc);
    }
}
