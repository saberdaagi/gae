package com.teckup.common.helper;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateHelper {



    public static final  String DATE_FORMATTER = "MM/MM/yyyy";

    public static Date parseToDate(String dateStr) throws ParseException {
        Date date = new SimpleDateFormat(DATE_FORMATTER).parse(dateStr);
        return date ;
    }




}
