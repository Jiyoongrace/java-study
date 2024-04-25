package tv;

public class TV {
    private int channel; // 1~255
    private int volume; // 0~100
    private boolean power;

    public TV() {
    }

    public TV(int channel, int volume, boolean power) {
        this.channel = channel;
        this.volume = volume;
        this.power = power;
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPower() {
        return power;
    }

    public void power(boolean on) {
        if (on) {
            power = true;
        } else {
            power = false;
        }
    }

    public void channel(int channel) {
        if (channel >= 1 && channel <= 255) {
            this.channel = channel;
        } else if (channel == 0){
            this.channel = 255;
        } else {
            System.out.println("채널은 1~255번까지 존재합니다.");
        }
    }

    public void channel(boolean channel) {
        if (channel) {
            this.channel += 1;
            if (this.channel > 255) {
                this.channel = 1;
            }
        } else {
            this.channel -= 1;
            if (this.channel < 1) {
                this.channel = 255;
            }
        }
    }

    public void volume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
        } else {
            System.out.println("volume은 0~100 범위입니다.");
        }
    }

    public void volume(boolean up) {
        if (up) {
            this.volume += 1;
        } else {
            if (getVolume() == 0) {
                this.volume = 100;
            }
            this.volume -= 1;
        }
    }

    public void status() {
        System.out.println("TV [power=" + power + ", channel="
                        + channel + ", volume=" + volume + "]");
    }
}
