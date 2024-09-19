package vip.dengwj.behavioralPattern.responsibility;

/**
 * @date 2024/9/19 21:59
 * @author 朴睦
 * @description 具体处理者
 */
public class GeneralManager extends Handler {
    public GeneralManager() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    public void leave(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getDay() + "天，" +  leaveRequest.getReason());
        System.out.println("GeneralManager 该领导同意！");
    }
}
