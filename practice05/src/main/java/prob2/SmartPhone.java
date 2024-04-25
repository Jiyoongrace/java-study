package prob2;

public class SmartPhone extends MusicPhone {
    @Override
    public void execute(String function) {
        if (function.equals("앱")) {
            executeApp();
        } else if (function.equals("음악")) {
            super.playMusic();
        } else {
            super.call();
        }
    }

    private void executeApp() {
        System.out.println("앱실행");
    }
}
