package controller;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundController {
    private Clip c;

    public SoundController(String son) {
        try {
            AudioInputStream a = AudioSystem.getAudioInputStream(getClass().getResource(son));
            c = AudioSystem.getClip();
            c.open(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        c.start();
    }

    public void stop() {
        c.stop();
    }

    public Clip getClip() {
        return c;
    }

    public static void playTempSound(String son) {
        SoundController s = new SoundController(son);
        s.play();
    }
}
