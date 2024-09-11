package vip.dengwj.structPattern.adapter;

/**
 * @date 2024/9/11 15:02
 * @author 朴睦
 * @description 适配者类
 */
public class TFCardImpl implements TFCard {

    @Override
    public String readTF() {
        return "你好 readTF";
    }

    @Override
    public void writeTF(String text) {
        System.out.println("writeTF -> " + text);
    }
}
