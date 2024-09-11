package vip.dengwj.structPattern.adapter.objectAdapter;

public class SDAdapterTF implements SDCard {
    private final TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSDCard() {
        return tfCard.readTF();
    }

    @Override
    public void writeSDCard(String sdCard) {
        tfCard.writeTF(sdCard);
    }
}
