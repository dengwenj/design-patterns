package vip.dengwj.behavioralPattern.responsibility;

/**
 * @date 2024/9/19 21:59
 * @author 朴睦
 * @description 具体处理者
 */
public class Manager extends Handler {
    public Manager() {
        super(Handler.NUM_ONE, Handler.NUM_THREE);
    }

    @Override
    public void leave(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getDay() + "天，" +  leaveRequest.getReason());
        System.out.println("Manager 该领导同意！");
    }
}
