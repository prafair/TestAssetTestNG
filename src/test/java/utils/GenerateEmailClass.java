package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GenerateEmailClass {

    public static String gen_email;

    public static void generateEmail() {
        DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date today = Calendar.getInstance().getTime();
        String todayDate = df.format(today);
        gen_email = "pavnovik+" + todayDate + "@gmail.com";
        System.out.println("Generated Email: " + gen_email);
    }
}
