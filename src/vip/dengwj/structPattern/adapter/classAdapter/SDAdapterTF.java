package vip.dengwj.structPattern.adapter.classAdapter;

/**
 * @date 2024/9/11 15:07
 * @author 朴睦
 * @description 适配器类
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {
    @Override
    public String readSDCard() {
        return readTF();
    }

    @Override
    public void writeSDCard(String sdCard) {
        writeTF(sdCard);
    }
}
