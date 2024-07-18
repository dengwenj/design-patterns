package vip.dengwj.principles._01kb;

public class Test {
    public static void main(String[] args) {
        SoGouInput soGouInput = new SoGouInput();
        //DefaultSkin ds = new DefaultSkin();
        PuMuSkin puMuSkin = new PuMuSkin();
        soGouInput.setAbstractSkin(puMuSkin);
        soGouInput.display();
    }
}
