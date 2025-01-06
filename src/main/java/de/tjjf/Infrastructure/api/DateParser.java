package de.tjjf.Infrastructure.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateParser {
    public static String getDateFromDBInRFC3339(String date) {
        String[] dateArr = date.split(" ");

        // if date format is already in RFC3339
        if(dateArr.length == 2) return date;

        String month = switch (dateArr[1]) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "00";
        };

        return dateArr[5] + "-" + month + "-" + dateArr[2];
    }

    public static String getDateTimeFromDBInRFC3339(String date) {
        String[] dateArr = date.split(" ");

        // if date format is already in RFC3339
        if(dateArr.length == 2) return date;

        String month = switch (dateArr[1]) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "00";
        };

        return dateArr[5] + "-" + month + "-" + dateArr[2] + "T" + dateArr[3] + "Z";
    }

    public static Date getDateFromRFC3339(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date dateAsDate;
        try {
            dateAsDate = formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }

        return dateAsDate;
    }

    public static Date getDateTimeFromRFC3339(String date) {

        if(date.matches("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z$")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                System.err.println("Error parsing date: " + e.getMessage());
            }
        }
        //TODO: d zu dd geändert
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        Date dateAsDate;
        try {
            dateAsDate = formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }

        return dateAsDate;
    }
}
