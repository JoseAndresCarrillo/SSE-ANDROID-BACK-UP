package com.banzaidevelopers.ssefisi;

import java.util.Calendar;

/**
 *
 * @author luigi
 */
public class DateConverter {
    public static Calendar convert(String string){
        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.YEAR,Integer.parseInt(string.substring(0,4)));
        rightNow.set(Calendar.MONTH,Integer.parseInt(string.substring(5,7))-1);
        rightNow.set(Calendar.DAY_OF_MONTH,Integer.parseInt(string.substring(8,10)));
        return rightNow;
    }
    public static String convert(Calendar calendar){
        String string=Integer.toString(calendar.get(Calendar.YEAR));
        int month=calendar.get(Calendar.MONTH)+1;
        if(month<10)
            string=string.concat("-0"+month);
        else
            string=string.concat("-"+month);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        if(day<10)
            string=string.concat("-0"+day);
        else
            string=string.concat("-"+day);
        return string;
//        Calendar rightNow = Calendar.getInstance();
//        rightNow.set(Calendar.YEAR,Integer.parseInt(string.substring(0,4)));
//        rightNow.set(Calendar.MONTH,Integer.parseInt(string.substring(5,7))-1);
//        rightNow.set(Calendar.DAY_OF_MONTH,Integer.parseInt(string.substring(8,10)));
//        return rightNow;
    }
}