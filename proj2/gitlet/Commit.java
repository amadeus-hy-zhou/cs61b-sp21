package gitlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import java.io.Serializable;

import static gitlet.Repository.OBJECT_DIR;
import static gitlet.Utils.join;
import static gitlet.Utils.writeObject;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author amadeus_zhy
 */
public class Commit implements Serializable {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private final String message;

    private final Date currentTime;

    private final String id;

    private final List<String> parents;

    private final Map<String, String> pathToBlobId;

    private final String timeStamp;

    private final File commitSaveFileName;

    public Commit() {
        this.currentTime = new Date(0);
        this.timeStamp = dateToTimeStamp(this.currentTime);
        this.message = "initial commit";
        this.pathToBlobId = new HashMap<>();
        this.parents = new ArrayList<>();
        this.id = generateId();
        this.commitSaveFileName = generateCommitFileName();
    }

    public Commit(String message, Map<String, String> pathToBlobId, List<String> parents) {
        this.message = message;
        this.pathToBlobId = pathToBlobId;
        this.parents = parents;
        this.currentTime = new Date();
        this.timeStamp = dateToTimeStamp(this.currentTime);
        this.id = generateId();
        this.commitSaveFileName = generateCommitFileName();
    }

    /**
     * Get the Date instance when a commit object is created.
     *
     * @return Date instance
     */
    public Date getCurrentTime() {
        return currentTime;
    }

    /**
     * Transform Date instance into TimeStamp instance.
     *
     * @param date Date instance
     * @return TimeStamp instance in the form of String.
     */
    private String dateToTimeStamp (Date date) {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy Z", Locale.US);
        return dateFormat.format(date);
    }

    public List<String> getParentsCommitId() {
        return parents;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public Map<String, String> getPathToBlobId() {
        return pathToBlobId;
    }

    public List<String> getBlobId() {
        return new ArrayList<>(pathToBlobId.values());
    }

    public String getId(){
        return id;
    }

    private String generateTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy Z", Locale.CHINA);
        return dateFormat.format(currentTime);
    }

    private String generateId() {
        return Utils.sha1(generateTimeStamp(), message, parents.toString(), pathToBlobId.toString());
    }

    private File generateCommitFileName() {
        return join(OBJECT_DIR, id);
    }

    public void save() {
        writeObject(commitSaveFileName, this);
    }
}