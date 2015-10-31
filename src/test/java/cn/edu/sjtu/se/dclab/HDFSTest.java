package cn.edu.sjtu.se.dclab;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;
import org.apache.hadoop.conf.Configuration;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;
import java.net.URI;

/**
 * Created by Yongfeng on 10/31/15.
 */
public class HDFSTest {

    @Test
    public void testHDFSRead() throws Exception{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.1.108:9000"), conf);
        Path file = new Path("/user/hadoop/test.txt");
        FSDataInputStream getIt = fs.open(file);
        BufferedReader d = new BufferedReader(new InputStreamReader(getIt));
        String s = "";
        while ((s = d.readLine()) != null) {
            System.out.println(s);
        }
        d.close();
        fs.close();
    }

    @Test
    public void testHDFSWrite() throws Exception{
        Configuration conf = new Configuration();
        System.setProperty("HADOOP_USER_NAME", "hadoop");
        System.setProperty("hadoop.home.dir", "/");
//        System.setProperty("hadoop.home.dir", "/");
//        String home = System.getProperty("hadoop.home.dir");
//        if(home == null) {
//            home = System.getenv("HADOOP_HOME");
//        }
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.1.108:9000"), conf);
        Path outFile = new Path("/user/hadoop/test.txt");
        FSDataOutputStream out = fs.create(outFile);
        BufferedWriter br=new BufferedWriter(new OutputStreamWriter(out));
        br.write("This is test string");
        br.close();
    }

    @Test
    public void testHDFSUtil() throws Exception{
        FileInputStream inputFile = new FileInputStream("/");
        MockMultipartFile file = new MockMultipartFile("file", "NameOfTheFile", "multipart/form-data", inputFile);
    }
}
