package ls;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileInfoLong extends FileInfo {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    public FileInfoLong(File file) {
        super(file);
    }

    @Override
    public String getAccessRights() {
        return (getFile().canRead() ? "1" : "0") +
                (getFile().canWrite() ? "1" : "0") +
                (getFile().canExecute() ? "1" : "0");
    }

    @Override
    public String getLastModifiedDate() {
        return new SimpleDateFormat(dateFormat).format(new Date(getFile().lastModified()));
    }

    @Override
    public String getSize() {
        return String.valueOf(getFile().length());
    }

    @Override
    public String toString() {
        return String.format("%s    %s    %s    %s", getAccessRights(), getSize(), getLastModifiedDate(), getName());
    }
}
