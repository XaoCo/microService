package com.cpllz.the16th;

import com.cpllz.the16th.controller.UploadFileController;
import com.cpllz.the16th.pojo.UploadFileStatus;
import com.cpllz.the16th.util.HttpUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UploadFileController.class)
@SpringBootTest
class The16thApplicationTests {

    @Test
//    void contextLoads() {
//    }

    public void uploadFileTest() throws FileNotFoundException {

        // 要上传的文件
        File file = new File("D:/SFTP/log1.log");
        UploadFileStatus fileStatus = new UploadFileStatus();
        // 上传到服务器后的文件名
        fileStatus.setFileName("test2");
        // 上传到服务器的哪个位置
        fileStatus.setFilePath("/root/myFile/");
        // 文件的大小
        fileStatus.setFileSize(file.length());
        // 文件的类型
        fileStatus.setFileType("png");
        fileStatus.setInputStream(new FileInputStream(file));

        String result = HttpUtils.postFile("http://118.25.125.187:8000/upload", fileStatus);
        System.out.println(result);
    }

}
