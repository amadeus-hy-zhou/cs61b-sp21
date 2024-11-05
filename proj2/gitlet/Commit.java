package gitlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import java.io.Serializable;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author amadeus_zhy
 */
public class Commit implements Serializable{
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private String message;

    private Date currentTime;

    private String id;

    private String timeStamp;

    public Commit(){

    }

    /**
     * Get the Date instance when a commit object is created.
     *
     * @return Date instance
     */
    public Date getCurrentTime(){
        return currentTime;
    }

    /**
     * Transform Date instance into TimeStamp instance.
     *
     * @param date Date instance
     * @return TimeStamp instance in the form of String.
     */
    private static String dateToTimeStamp(Date date){
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy Z", Locale.US);
        return dateFormat.format(date);
    }

    public String getMessage(){
        return message;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public String getId(){
        return id;
    }
}