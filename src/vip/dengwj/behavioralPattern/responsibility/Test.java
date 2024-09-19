package vip.dengwj.behavioralPattern.responsibility;

public class Test {
    public static void main(String[] args) {
        // 请假条
        LeaveRequest leaveRequest = new LeaveRequest("朴睦", "累了，休息", 11);

        // 领导
        Handler groupLeader = new GroupLeader();
        Handler manager = new Manager();
        Handler generalManager = new GeneralManager();

        // 设置上一级
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        groupLeader.submit(leaveRequest);
    }
}
