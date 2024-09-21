package vip.dengwj.behavioralPattern.state;

/**
 * @date 2024/9/21 14:50
 * @author 朴睦
 * @description 状态模式上下文
 */
public class Context {
    public static final LifeState OPEN = new OpeningState();
    public static final LifeState CLOSE = new CloseState();
    public static final LifeState RUN = new RunState();
    public static final LifeState STOP = new StopState();

    // 当前状态
    private LifeState state;

    public LifeState getState() {
        return state;
    }

    public void setState(LifeState state) {
        this.state = state;
        this.state.setContext(this);
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void run() {
        state.run();
    }

    public void stop() {
        state.stop();
    }
}
