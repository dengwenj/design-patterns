package vip.dengwj.principles.demo1;

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
