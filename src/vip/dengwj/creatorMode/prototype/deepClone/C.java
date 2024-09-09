package vip.dengwj.creatorMode.prototype.deepClone;

import java.io.Serializable;

public class C implements Cloneable, Serializable {
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void show() {
        System.out.println(student.getName() + "哈哈哈哈");
    }

    @Override
    public C clone() throws CloneNotSupportedException {
        return (C) super.clone();
    }
}
