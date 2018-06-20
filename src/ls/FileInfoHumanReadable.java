package ls;

import java.io.File;

public class FileInfoHumanReadable extends FileInfoLong {
    public FileInfoHumanReadable(File file) {
        super(file);
    }

    @Override
    public String getAccessRights() {
        return (getFile().canRead() ? "r" : "-") +
                (getFile().canWrite() ? "w" : "-") +
                (getFile().canExecute() ? "x" : "-");
    }

    @Override
    public String getSize() {
        return utils.humanReadableBytes(getFile().length());
    }
}
