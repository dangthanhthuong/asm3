package vn.funix.fx20081.java.Asm3.model;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DataTime {



    public String getDivider() {
        return "+------------+-----------------------+--------------+";
    }
    public String getDateTime() {
        Date d = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return df.format(d);
    }
    public String formatBalance(double amount) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(amount);
    }

}