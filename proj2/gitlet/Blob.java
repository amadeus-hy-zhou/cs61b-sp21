package gitlet;

import java.io.File;
import java.io.Serializable;
import java.util.*;

import static gitlet.Repository.OBJECT_DIR;
import static gitlet.Utils.*;

public class Blob implements Serializable {
    private final String id;

    private final byte[] bytes;

    private final File fileName;

    private final String filePath;

    private final File blobSaveFileName;

    public Blob(File fileName){
        this.fileName = fileName;
        this.bytes = readFile();
        this.filePath = fileName.getPath();
        this.id = generateId();
        this.blobSaveFileName = generateBlobSaveFileName();
    }

    public String getBolbId() {
        return id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String getFileName() {
        return fileName.getName();
    }

    public String getFilePath() {
        return filePath;
    }

    public File getBlobSaveFileName() {
        return blobSaveFileName;
    }

    private byte[] readFile() {
        return readContents(fileName);
    }

    private String generateId() {
        return sha1(filePath, bytes);
    }

    private File generateBlobSaveFileName() {
        return join(OBJECT_DIR, id);
    }
    public void save() {
        writeObject(blobSaveFileName, this);
    }
}