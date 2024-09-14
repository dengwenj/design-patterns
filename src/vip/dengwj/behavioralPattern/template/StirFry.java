package vip.dengwj.behavioralPattern.template;

public abstract class StirFry {
    // 模板方法，执行的流程
    public final void cookProcess() {
        oilDown();
        oilHot();
        pourVegetables();
        condiments();
        fry();
    }

    // 下油,流程是固定的
    public void oilDown() {
        System.out.println("第一步下油");
    }

    // 热油 流程是固定的
    public void oilHot() {
        System.out.println("第二步热油");
    }

    // 倒蔬菜，具体的东西不知道，抽象方法
    public abstract void pourVegetables();

    // 倒调料品，具体的东西不知道，抽象方法
    public abstract void condiments();

    // 翻炒菜
    public void fry() {
        System.out.println("翻炒菜");
    }
}
