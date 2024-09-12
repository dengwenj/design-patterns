package vip.dengwj.structPattern.Bridge;

public class Windows extends OperatingSystem {
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void openVideo() {
        videoFile.decode("Windows");
    }
}
