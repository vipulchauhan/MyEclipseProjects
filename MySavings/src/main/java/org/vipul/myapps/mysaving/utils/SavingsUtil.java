package org.vipul.myapps.mysaving.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsUtil {
	
	public static String dateString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
		return sdf.format(date);
	}

}
