package com.wz.util.springbootutil.util;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    /**
     * 往文件中写入内容并换行
     * @param fileName 写入的文件路径
     * @param content 写入文件的内容
     */
    public static synchronized void appendContentToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content + "\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
