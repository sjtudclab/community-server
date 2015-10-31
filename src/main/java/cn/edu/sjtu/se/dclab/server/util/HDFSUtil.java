package cn.edu.sjtu.se.dclab.server.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;

/**
 * Created by Yongfeng on 10/31/15.
 */
public class HDFSUtil {
    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    private static String HDFS_URI = "hdfs://192.168.1.108:9000";
    public static String uploadFile(MultipartFile file, HttpServletRequest request) {
        String uploadedPath = "/messages";
        String fileName = file.getName();

        try {
            Path filePath = new Path("/user/hadoop/test.txt");
            Configuration conf = new Configuration();
            System.setProperty("HADOOP_USER_NAME", "hadoop");
            System.setProperty("hadoop.home.dir", "/");
            FileSystem fs = FileSystem.get(new URI(HDFS_URI), conf);
            uploadedPath += File.separator + getFileNameWithoutExt(fileName) + System.currentTimeMillis() + getFileType(fileName);
            Path outFile = new Path(uploadedPath);
            FSDataOutputStream out = fs.create(outFile);
            out.write(file.getBytes());
            out.close();
            fs.close();
        } catch (Exception e) {
            LOG.info("HDFS upload attachment failed.");
            return "";
        }
        return uploadedPath;
    }
    private static String getFileNameWithoutExt(String filename) {
        return filename.split("\\.")[0];
    }

    private static String getFileType(String filename){
        String[] arr = filename.split("\\.");
        return arr[1];
    }
}
