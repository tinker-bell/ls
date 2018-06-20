package ls;

import java.io.File;

public class FileInfo implements Comparable<FileInfo> {
    private File _file;

    public FileInfo(File file) {
        _file = file;
    }

    public File getFile() {
        return _file;
    }

    public String getName() {
        return _file.getName();
    }

    public String getAccessRights() {
        return "";
    }

    public String getLastModifiedDate() {
        return "";
    }

    public String getSize() {
        return "";
    }

    @Override
    public int compareTo(FileInfo o) {
        if (o == null) {
            return 1;
        }

        return getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
