package pl.edu.wszib.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormattingDate {
    public static Date StringToDate(String dt) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dt);
        System.out.println("Date object value: "+date);
        return date;
    }
}
