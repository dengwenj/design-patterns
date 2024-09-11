package vip.dengwj.structPattern.adapter;

/**
 * @date 2024/9/11 15:03
 * @author 朴睦
 * @description 目标接口
 */
public interface SDCard {
    String readSDCard();

    void writeSDCard(String sdCard);
}
