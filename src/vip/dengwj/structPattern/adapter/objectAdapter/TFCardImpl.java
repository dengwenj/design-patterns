package vip.dengwj.structPattern.adapter.objectAdapter;

public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        return "readTF";
    }

    @Override
    public void writeTF(String tf) {
        System.out.println("writeTF" + tf);
    }
}
