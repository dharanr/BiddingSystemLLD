package Model;
import java.util.Date;

public class TimeSlot {

    //Everything should be in Millies
    Date fromTime;
    Date toTime;
    
    public TimeSlot(Date fromTime, Date toTime) {
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public Date getFromTime() {
        return this.fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return this.toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }
}
