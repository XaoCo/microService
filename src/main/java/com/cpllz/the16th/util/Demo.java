package com.cpllz.the16th.util;

import com.cpllz.the16th.pojo.UploadFileStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @auther CPP
 * @date 2020/3/13 0:03
 * 　　　　　　　 ┏┓       ┏┓+ +
 * 　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　 ┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 █████━█████  ┃+
 * 　　　　　　　┃　　　　　　 ┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　 ┃ + +
 * 　　　　　　　┗━━┓　　　 ┏━┛
 * ┃　　  ┃
 * 　　　　　　　　　┃　　  ┃ + + + +
 * 　　　　　　　　　┃　　　┃　Code is far away from     bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　 ┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 * 　　　　　　　　　 ┃┫┫　 ┃┫┫
 * 　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 */
public class Demo {
    public static void main(String[] args) {
        File file = new File("D:/SFTP/log1.log");
        UploadFileStatus fileStatus = new UploadFileStatus();
        // 上传到服务器后的文件名
        fileStatus.setFileName("test2");
        // 上传到服务器的哪个位置
        fileStatus.setFilePath("/root/myFile/");
        // 文件的大小
        fileStatus.setFileSize(file.length());
        // 文件的类型
        fileStatus.setFileType("log");
        try {
            fileStatus.setInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String result = HttpUtils.postFile("http://118.25.125.187:8000/upload", fileStatus);
        System.out.println(result);
    }
}
