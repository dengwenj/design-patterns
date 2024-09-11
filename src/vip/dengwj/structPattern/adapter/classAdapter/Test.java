package vip.dengwj.structPattern.adapter.classAdapter;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        String msg = computer.readCard(new SDCardImpl());
        System.out.println(msg);

        System.out.println("-------------");
        String msg1 = computer.readCard(new SDAdapterTF());
        System.out.println(msg1);
    }
}
