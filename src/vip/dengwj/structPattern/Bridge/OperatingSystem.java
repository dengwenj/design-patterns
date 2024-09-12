package vip.dengwj.structPattern.Bridge;

/**
 * @date 2024/9/12 14:48
 * @author 朴睦
 * @description 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用
 */
public abstract class OperatingSystem {
    protected VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void openVideo();
}
