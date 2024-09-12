package vip.dengwj.structPattern.decorator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("路径");
        BufferedWriter bw = new BufferedWriter(fw);
        // 写数据
        bw.write("hello");
        bw.close();
    }
}
