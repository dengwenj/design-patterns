package vip.dengwj.behavioralPattern.responsibility;

/**
 * @date 2024/9/19 21:45
 * @author 朴睦
 * @description 请假条类
 */
public class LeaveRequest {
    private String name;

    private String reason;

    private int day;

    public LeaveRequest(String name, String reason, int day) {
        this.name = name;
        this.reason = reason;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public String getReason() {
        return reason;
    }
}
