package vip.dengwj.structPattern.adapter;

/**
 * @date 2024/9/11 15:09
 * @author 朴睦
 * @description 具体的 SD 卡
 */
public class SDCardImpl implements SDCard {
    @Override
    public String readSDCard() {
        return "readSDCard";
    }

    @Override
    public void writeSDCard(String sdCard) {
        System.out.println("writeSDCard -> " + sdCard);
    }
}
