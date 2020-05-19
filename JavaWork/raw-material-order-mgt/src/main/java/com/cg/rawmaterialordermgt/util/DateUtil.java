package com.cg.rawmaterialordermgt.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	

	    public static String toString(Date date, String pattern) {
	        DateFormat format = new SimpleDateFormat(pattern);
	        String dateText = format.format(date);
	        return dateText;
	    }
}
