package vip.dengwj.structPattern.Bridge;

/**
 * @date 2024/9/12 14:48
 * @author 朴睦
 * @description 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，
 * 并通过组合关系调用实现化角色中的业务方法
 */
public class Mac extends OperatingSystem {
    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void openVideo() {
        videoFile.decode("mac");
    }
}
