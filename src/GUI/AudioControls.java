package GUI;

import Sounds.Sounds;
import javax.swing.*;
import java.awt.*;


public class AudioControls extends JPanel {
    /**
     * The Constructor of the UserView
     * @param volumeSlider Used to set the Volume to all background sounds
     */
    private JSlider volumeSlider;

    public AudioControls(){
        setLayout(new FlowLayout());
        JLabel volumeLabel = new JLabel("Volume");

        volumeSlider = new JSlider(SwingConstants.HORIZONTAL);
        volumeSlider.setMaximum(100);
        volumeSlider.setMinimum(1);
        volumeSlider.getPaintTrack();
        volumeSlider.setValue(50);

        JButton muteButton = new JButton("Mute");

        add(volumeLabel);
        add(volumeSlider);
        add(muteButton);

        muteButton.addActionListener(e -> {
            Sounds.getBackground().setVolume(0.0001);
            Sounds.getButton().setVolume(1f);
            Sounds.getButton().play();
            volumeSlider.setValue(1);
        });

        volumeSlider.addChangeListener(e -> {
            float volume1 = scale((float)volumeSlider.getValue(), 1.0f, 100.0f, 0.0001f, 2f);
//                System.out.println(volume);
            Sounds.getBackground().setVolume(volume1);
            Sounds.getBackground1().setVolume(volume1);
            Sounds.getBackground2().setVolume(volume1);
            Sounds.getBackground3().setVolume(volume1);
        });

    }

    private float scale(float sliderVal, float minSliderVal, float maxSliderVal, float minRange, float maxRange) {
        return ((maxRange - minRange) * (sliderVal - minSliderVal) /
                (maxSliderVal - minSliderVal)) + minRange;
    }

    public JPanel getPanControls(){
        return this;
    }

}
