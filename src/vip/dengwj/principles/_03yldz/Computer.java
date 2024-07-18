package vip.dengwj.principles._03yldz;

public class Computer {
    private Cpu cpu;

    private HardDisk hardDisk;

    private Memory memory;

    public void run() {
        hardDisk.save();
        String string = hardDisk.get();
        System.out.println(string);
        memory.save();
        cpu.run();
    }

    /**
     * 获取
     * @return cpu
     */
    public Cpu getCpu() {
        return cpu;
    }

    /**
     * 设置
     * @param cpu
     */
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    /**
     * 获取
     * @return hardDisk
     */
    public HardDisk getHardDisk() {
        return hardDisk;
    }

    /**
     * 设置
     * @param hardDisk
     */
    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    /**
     * 获取
     * @return memory
     */
    public Memory getMemory() {
        return memory;
    }

    /**
     * 设置
     * @param memory
     */
    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public String toString() {
        return "Computer{cpu = " + cpu + ", hardDisk = " + hardDisk + ", memory = " + memory + "}";
    }
}
