package vip.dengwj.behavioralPattern.command;


/**
 * @date 2024/9/18 22:12
 * @author 朴睦
 * @description 厨师类 接收者
 */
public class SeniorChef {
    // 制作食物
    public void  makeFood(String foodName, Integer num) {
        System.out.println("厨师正在制作" + num + "份" + foodName);
    }
}
