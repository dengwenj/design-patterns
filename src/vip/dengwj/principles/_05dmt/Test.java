package vip.dengwj.principles._05dmt;

public class Test {
    public static void main(String[] args) {
        Agent agent = new Agent();

        agent.setStar(new Star("朴睦"));
        agent.setFans(new Fans("李雷"));
        agent.setCompany(new Company("飞天科技"));

        agent.meeting();
        agent.business();
    }
}
