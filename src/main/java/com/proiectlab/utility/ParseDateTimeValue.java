/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proiectlab.utility;

import com.proiectlab.entity.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ParseDateTimeValue {
    
    public static java.sql.Timestamp parseTimestamp(String timestamp) {
        Timestamp t = Timestamp.valueOf(timestamp);

        return t;
    }

    public static java.sql.Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        java.util.Date dateJava = formatter.parse(dateString);
        java.sql.Date dateSQL = new java.sql.Date(dateJava.getTime());

        return dateSQL;
    }

    public static String fromStringDateToTimestamp(String dateString) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateJava = formatter.parse(dateString);
            Timestamp timestamp = new java.sql.Timestamp(dateJava.getTime());
            return timestamp.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
  
    public static Double roundToTwoDecimals(Double value) {
        return new BigDecimal(value.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
    }
    
    public static Double computeTotalSumOfCart(List<Product> productsInCart){
        return roundToTwoDecimals(productsInCart.stream().mapToDouble(p -> p.getPrice()).sum());
    }
    
    public static Double computeTaxes(Double value, Double taxPercentage){
        return roundToTwoDecimals(value * taxPercentage);
    }
  
}
