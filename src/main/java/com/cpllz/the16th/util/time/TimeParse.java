package com.cpllz.the16th.util.time;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 文件名称：Bdemo
 * 作者：Admin
 * 创建时间：2021/3/27 17:46
 * 描述：TODO
 */
public class TimeParse {
    public static void main(String[] args) throws ParseException {
        String str1 = "2021-03-27 18:20:40";
        String str2 = "20210318190325";
        String str3 = "2021-03-27 19:20:40";
        String s = parse1(str1);
        System.out.println("s = " + s);

        String s1 = parse2(str2);
        System.out.println("s1 = " + s1);
        boolean b = parse3(str1, str3);
        System.out.println("b = " + b);

    }
    public static String parse1(String str){
        //str是yyyy-MM-dd HH:mm:ss型
        DateTimeFormatter dfDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parses = LocalDateTime.parse(str, dfDate);
        String format = dfDate.format(parses.plusHours(10));
        System.out.println("format = " + format);
        return format;
    }
    public static String parse2(String str) throws ParseException {
        //str是yyyyMMddHHmmss型
        Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
        String stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("stime = " + stime);
        return stime;
    }
    public static boolean parse3(String str1,String str2) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //将字符串形式的时间转化为Date类型的时间
        Date a=sdf.parse(str1);
        Date b=sdf.parse(str2);
        //Date类的一个方法，如果a早于b返回true，否则返回false
        if(a.before(b))
            return true;
        else
            return false;
    }

}
