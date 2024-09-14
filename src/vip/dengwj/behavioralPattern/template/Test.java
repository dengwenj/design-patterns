package vip.dengwj.behavioralPattern.template;

public class Test {
    public static void main(String[] args) {
        StirFry baicai = new Baicai();
        baicai.cookProcess();
        System.out.println("--------------");
        StirFry kongxincai = new Baicai();
        kongxincai.cookProcess();
    }
}
