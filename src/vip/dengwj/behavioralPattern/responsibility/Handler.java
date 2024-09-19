package vip.dengwj.behavioralPattern.responsibility;

/**
 * @date 2024/9/19 21:46
 * @author 朴睦
 * @description 抽象处理者
 */
public abstract class Handler {
    public static final int NUM_ONE = 1;
    public static final int NUM_THREE = 3;
    public static final int NUM_SEVEN = 7;

    // 领导审核天数的区间
    private int numStart;

    private int numEnd;

    // 上级领导（下一个链）
    private Handler nextHandler;

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 各领导审核
    protected abstract void leave(LeaveRequest leaveRequest);

    // 提交请假条
    public void submit(LeaveRequest leaveRequest) {
        leave(leaveRequest);

        // 上一级领导审批
        if (leaveRequest.getDay() > numEnd && nextHandler != null) {
            nextHandler.leave(leaveRequest);
        } else {
            // 当前领导有能力审批
        }
        System.out.println("审批完成 " + leaveRequest.getName() + " 通过！");
    }
}
