package vip.dengwj.behavioralPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/9/18 22:19
 * @author 朴睦
 * @description 调用者
 */
public class Waitor {
    private List<Command> commands = new ArrayList<>();

    public void setCommands(Command command) {
        commands.add(command);
    }

    public void orderUp() {
        // 调用命令者方法
        commands.forEach(Command::execute);
    }
}
