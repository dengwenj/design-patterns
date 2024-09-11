package vip.dengwj.structPattern.adapter.classAdapter;

/**
 * @date 2024/9/11 15:01
 * @author 朴睦
 * @description 适配者接口
 */
public interface TFCard {
    // 读取 tf 卡
    String readTF();

    void writeTF(String text);
}
