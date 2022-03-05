package Utils;

import java.util.Date;
import Model.TimeSlot;

public class BTime {
    public static TimeSlot set(int minutes1, int minutes2){
        Date dt1= new Date(); 
        dt1.setMinutes(minutes1); 
        dt1.setSeconds(0);

        Date dt2= new Date(); 
        dt2.setMinutes(minutes2); 
        dt2.setSeconds(0);

        return new TimeSlot(dt1,dt2);
    }

    public static boolean isBiddingExpired(TimeSlot timeSlot){
        Long currentTime = new Date().getTime();
        return currentTime > timeSlot.getToTime().getTime();
    }

    public static boolean isBiddingProduct(TimeSlot timeSlot){
        Long currentTime = new Date().getTime();
        return currentTime > timeSlot.getFromTime().getTime() && currentTime < timeSlot.getToTime().getTime();
    }
}
