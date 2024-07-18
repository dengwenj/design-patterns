package vip.dengwj.principles._01kb;

public class SoGouInput {
    private AbstractSkin abstractSkin;

    public void setAbstractSkin(AbstractSkin abstractSkin) {
        this.abstractSkin = abstractSkin;
    }

    public void display() {
        if (abstractSkin == null) return;
        abstractSkin.display();
    }
}
