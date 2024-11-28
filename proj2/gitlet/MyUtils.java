package gitlet;

import java.io.File;
import java.io.Serializable;

import static gitlet.Utils.*;

public class MyUtils {
    public static void mkdir(File dir) {
        if (!dir.mkdir()) {
            throw new IllegalArgumentException(String.format("mkdir: %s: Failed to create.", dir.getPath()));
        }
    }
}
