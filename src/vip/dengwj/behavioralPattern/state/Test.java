package vip.dengwj.behavioralPattern.state;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new OpeningState());

        context.open();
        context.close();
        context.run();
        context.stop();
        System.out.println("----------------");
        context.open();
        context.run();
        context.close();
        context.stop();
    }
}
