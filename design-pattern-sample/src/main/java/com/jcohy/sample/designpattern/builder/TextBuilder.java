package com.jcohy.sample.designpattern.builder;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jcohy on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
// tag::code[]
/**
 *
 * 是Builder的子类，以一般文本格式建立文件，以String返回字符串。
 *
 */
public class TextBuilder extends Builder{
    private StringBuffer buffer = new StringBuffer();
    @Override
    public void makeTitle(String title) {
        buffer.append("====================\n");
        buffer.append("["+title+"]\n");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        //带*的字符串
        buffer.append("*"+str+"\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        //带.的项目
        for(int i=0;i<items.length;i++){
            buffer.append("."+items[i]+"\n");
        }
        buffer.append("\n");
    }

    @Override
    public Object getResult() {
        buffer.append("====================\n");
        return buffer.toString();
    }
}
// end::code[]