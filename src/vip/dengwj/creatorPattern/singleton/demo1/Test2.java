package vip.dengwj.creatorPattern.singleton.demo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test2 {
    public static void main(String[] args) throws Exception {
        //writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    // 从文件读取数据（对象）
    public static void readObjectFromFile() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(
            new FileInputStream("src/vip/dengwj/creatorMode/singleton/pumu.txt")
        );

        Singleton5 singleton5 = (Singleton5) ois.readObject();
        System.out.println(singleton5);

        ois.close();
    }

    // 把数据写入到文件中（对象）
    public static void writeObject2File() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream("src/vip/dengwj/creatorMode/singleton/pumu.txt")
        );

        // 写入数据
        oos.writeObject(Singleton5.getInstance());

        oos.close();
    }
}
