package com.bsuir.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Егор on 12.04.17.
 */
public class DateParser {
    public static Calendar parseDate(String date){
        String[] arr = date.split("-");
        Calendar c = new GregorianCalendar(Integer.parseInt(arr[2]),Integer.parseInt(arr[1]),Integer.parseInt(arr[0]));
        //System.out.println(c.get(Calendar.DAY_OF_WEEK));
        return c;
    }
}
