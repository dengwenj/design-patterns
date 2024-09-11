package vip.dengwj.structPattern.adapter.objectAdapter;

public class SDCardImpl implements SDCard {
    @Override
    public String readSDCard() {
        return "readSDCard";
    }

    @Override
    public void writeSDCard(String sdCard) {
        System.out.println("writeSDCard" + sdCard);
    }
}
