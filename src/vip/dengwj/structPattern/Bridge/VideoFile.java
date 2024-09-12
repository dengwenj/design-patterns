package vip.dengwj.structPattern.Bridge;

/**
 * @date 2024/9/12 14:43
 * @author 朴睦
 * @description 实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用
 */
public interface VideoFile {
    // 解码
    void decode(String path);
}
