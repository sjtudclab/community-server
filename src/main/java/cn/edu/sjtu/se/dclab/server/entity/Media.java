package cn.edu.sjtu.se.dclab.server.entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by hadoop on 10/30/15.
 */
public class Media {
    private int contentType;
    private int fileIndex;
    private MultipartFile file;

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public int getFileIndex() {
        return fileIndex;
    }

    public void setFileIndex(int fileIndex) {
        this.fileIndex = fileIndex;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
