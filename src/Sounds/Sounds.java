package Sounds;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Sounds {

    private static SoundClip background;
    private static SoundClip background1;
    private static SoundClip background2;
    private static SoundClip background3;
    private static SoundClip button;
    private static SoundClip bullet;

    /**
     * @param background  level 1 background music
     * @param background1 level 2 background music
     * @param background2 level 3 background music
     * @param background3 level 4 background music
     * @param button button sound for the game panels
     * @param bullet sound for projectiles
     */


    static {
        try {
            background = new SoundClip("data/Sounds/Background/Volume Alpha - 18 - Sweden.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    static {
        try {
            background1 = new SoundClip("data/Sounds/Background/Volume Alpha - 03 - Subwoofer Lullaby.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    static {
        try {
            background2 = new SoundClip("data/Sounds/Background/Volume Alpha - 12 - Dry Hands.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    static {
        try {
            background3 = new SoundClip("data/Sounds/Background/Volume Alpha - 04 - Death.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }


    static {
        try {
            button = new SoundClip("data/Sounds/Button/button.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    static {
        try {
            bullet = new SoundClip("data/Sounds/Bullet/bullet.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Getters for the sounds
     */


    public static SoundClip getBullet() { return bullet; }

    public static SoundClip getBackground(){
        return background;
    }

    public static SoundClip getBackground1(){
        return background1;
    }

    public static SoundClip getBackground2(){
        return background2;
    }

    public static SoundClip getBackground3(){
        return background3;
    }

    public static SoundClip getButton(){
        return button;
    }
}
