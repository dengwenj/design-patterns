package vip.dengwj.behavioralPattern.responsibility;

/**
 * @date 2024/9/19 21:59
 * @author 朴睦
 * @description 具体处理者
 */
public class GroupLeader extends Handler {
    public GroupLeader() {
        super(0, Handler.NUM_ONE);
    }

    @Override
    public void leave(LeaveRequest leaveRequest) {
        System.out.println(leaveRequest.getName() + "请假" + leaveRequest.getDay() + "天，" +  leaveRequest.getReason());
        System.out.println("GroupLeader 领导同意！");
    }
}
