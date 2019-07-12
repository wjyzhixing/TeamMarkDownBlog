/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zhaoxuyang.blog.model;

/**
 *
 * @author hadoop
 */
public class AnalysisGlobal {
    String shenghui;
    String jingdu;
    String weidu;
    int renshu;

    public String getShenghui() {
        return shenghui;
    }

    public void setShenghui(String shenghui) {
        this.shenghui = shenghui;
    }

    public String getJingdu() {
        return jingdu;
    }

    public void setJingdu(String jingdu) {
        this.jingdu = jingdu;
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }

    public int getRenshu() {
        return renshu;
    }

    public void setRenshu(int renshu) {
        this.renshu = renshu;
    }

    @Override
    public String toString() {
        return "AnalysisGlobal{" + "shenghui=" + shenghui + ", jingdu=" + jingdu + ", weidu=" + weidu + ", renshu=" + renshu + '}';
    }
    
}
