package vip.dengwj.creatorPattern.singleton.demo1;

import java.io.IOException;
import java.io.InputStream;

public class Test4 {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        // 调用 runtime 的方法 exec，参数要的是一个命令
        Process process = runtime.exec("ifconfig");
        // 获取输入流
        InputStream is = process.getInputStream();
        // 1KB = 1024bit，1M = 1024KB
        byte[] buffer = new byte[1024 * 1024 * 10]; // 10M
        // 读到的长度
        int len = is.read(buffer);
        System.out.println(new String(buffer, 0, len));
    }
}
