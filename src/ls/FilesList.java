package ls;

import java.io.File;
import java.util.*;

public class FilesList {
    private File _root;

    public FilesList(File root) {
        _root = root;
    }

    public String getList(Boolean isReverse, Boolean isLong, Boolean isHumanReadable) {
        if (_root == null) {
            return "";
        }

        File[] files = _root.listFiles();
        if (files == null) {
            return "";
        }

        List<FileInfo> result = new ArrayList<>();
        for (File file : files) {
            result.add(buildFileInfo(file, isLong, isHumanReadable));
        }

        if (isReverse) {
            Collections.reverse(result);
        } else {
            Collections.sort(result);
        }

        return buildOutput(result);
    }

    private String buildOutput(List<FileInfo> files) {
        StringBuilder sb = new StringBuilder();
        for (FileInfo file : files) {
            sb.append(file.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    private FileInfo buildFileInfo(File file, Boolean isLong, Boolean isHumanReadable) {
        if (isHumanReadable) {
            return new FileInfoHumanReadable(file);
        }

        if (isLong) {
            return new FileInfoLong(file);
        }

        return new FileInfo(file);
    }
}
