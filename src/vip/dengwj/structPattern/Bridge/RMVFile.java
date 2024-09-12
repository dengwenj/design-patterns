package vip.dengwj.structPattern.Bridge;

/**
 * @date 2024/9/12 14:44
 * @author 朴睦
 * @description 具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现
 */
public class RMVFile implements VideoFile {
    @Override
    public void decode(String path) {
        System.out.println("RMVFile: " + path);
    }
}
