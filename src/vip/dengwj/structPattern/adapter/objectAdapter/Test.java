package vip.dengwj.structPattern.adapter.objectAdapter;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        String string = computer.readCard(new SDCardImpl());
        System.out.println(string);

        System.out.println("11---------------");
        SDAdapterTF sdAdapterTF = new SDAdapterTF(new TFCardImpl());
        String string1 = computer.readCard(sdAdapterTF);
        System.out.println(string1);
    }
}
