package vip.dengwj.creatorPattern.prototype.deepClone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @date 2024/9/9 15:44
 * @author 朴睦
 * @description 深克隆
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 浅克隆
        //C c = new C();
        //Student student = new Student();
        //student.setName("朴睦");
        //c.setStudent(student);
        //
        //C clone = c.clone();
        //clone.getStudent().setName("李雷");
        //
        //c.show();
        //clone.show();

        // 深克隆
        C c = new C();
        Student student = new Student();
        student.setName("朴睦");
        c.setStudent(student);

        // 创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/deepClone.txt"));
        oos.writeObject(c);
        oos.close();

        // 创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/deepClone.txt"));
        C c1 = (C) ois.readObject();
        ois.close();
        c1.getStudent().setName("李雷");

        c.show();
        c1.show();
    }
}
