package vip.dengwj.creatorPattern.builder.Demo;

public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
            .setBrand("华为")
            .setColor("黑色")
            .setMoney("6999")
            .setWeight("1")
            .build();
        System.out.println(phone);

        Phone phone1 = new Phone();
        phone1.setBrand("小米");
        phone1.setColor("白色");
        phone1.setMoney("3999");
        phone1.setWeight("1");
        System.out.println(phone1);
    }
}
