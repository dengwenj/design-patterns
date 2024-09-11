package vip.dengwj.structPattern.adapter.objectAdapter;

public class Computer {
    public String readCard(SDCard card) {
        if (card == null) {
            return null;
        }
        return card.readSDCard();
    }
}
