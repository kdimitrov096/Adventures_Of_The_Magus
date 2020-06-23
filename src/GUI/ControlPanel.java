package GUI;

import Game.Game;
import Game.GameLevels;
import Game.SaveAndLoad.GameLoader;
import Game.SaveAndLoad.GameSaver;
import Sounds.Sounds;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class ControlPanel extends JPanel {
    private GameLevels levels;
    /**
     * @param pause Jbutton in the Control panel to pause the world
     * @param healthBar JProgressBar in the Control Panel to keep track of the player health
     * @param shardsBar JProgressBar in the Control Panel to keep track of the player shards count
     * @param gameProgressBar JProgressBar to keep track of the game progress
     * @param levels used to call the appropriate game world
     */

    private int clicks = 0;
    private JButton pause = new JButton("Pause");
    private JProgressBar healthBar;
    private JProgressBar shardsBar;
    private JProgressBar gameProgressBar;


    public  ControlPanel(Game game){
        levels = game.getWorld();
        int healthBarMax = 10;
        int shardsBarMax = 25;
        setLayout(new BorderLayout());

        JPanel north = new JPanel(new FlowLayout());
        north.setOpaque(false);
        JPanel center = new JPanel();
        center.setOpaque(false);
        JPanel south = new JPanel(new FlowLayout());
        south.setOpaque(false);

        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        UIManager.put("ProgressBar.selectionForeground", Color.red);
        UIManager.put("ProgressBar.selectionBackground", Color.green);

        int wizCurrentHealth = game.getWorld().getPlayer().getLiveCount();
        int wizCurrentShards = game.getWorld().getPlayer().getShardcount();

        healthBar = new JProgressBar();
        healthBar.setStringPainted(true);
        healthBar.setString("Health");
        Font font = new Font("Castellar", Font.BOLD, 16);
        healthBar.setFont(font);
        healthBar.setForeground(Color.GREEN);

        healthBar.setMinimum(1);
        healthBar.setMaximum(healthBarMax);
        healthBar.setValue(wizCurrentHealth);

        shardsBar = new JProgressBar();
        shardsBar.setStringPainted(true);
        shardsBar.setString("Mana");
        shardsBar.setFont(font);
        shardsBar.setForeground(Color.CYAN);


        shardsBar.setMinimum(1);
        shardsBar.setMaximum(shardsBarMax);
        shardsBar.setValue(wizCurrentShards);

        south.add(healthBar);
        south.add(pause);
        JButton restart = new JButton("Restart");
        south.add(restart);
        JButton quit = new JButton("Quit");
        south.add(quit);
        south.add(shardsBar);

        gameProgressBar = new JProgressBar();
        gameProgressBar.setStringPainted(true);
        gameProgressBar.setString("Game Progress");
        gameProgressBar.setFont(font);
        gameProgressBar.setForeground(Color.ORANGE);

        JButton saveGameButton = new JButton("Save");
        saveGameButton.setFont(font);
        saveGameButton.addActionListener(e -> {
            Sounds.getButton().setVolume(0.1f);
            Sounds.getButton().play();
            GameSaver sw = new GameSaver("data/Game_Data/newsavefile.txt");
            try {
                sw.saveGame(game.getWorld());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        JButton loadGameButton = new JButton("Load");
        loadGameButton.setFont(font);
        loadGameButton.addActionListener(e -> {
            Sounds.getButton().setVolume(1f);
            Sounds.getButton().play();
            GameLoader sr = new GameLoader("data/Game_Data/newsavefile.txt", game);
            try {
                levels = sr.loadGame();
                game.goToLevel(levels);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        north.add(saveGameButton);
        north.add(gameProgressBar, BorderLayout.NORTH);
        north.add(loadGameButton);


        pause.setFont(font);
        pause.addActionListener(e -> {
            Sounds.getButton().setVolume(1f);
            Sounds.getButton().play();

            switch (clicks){
               case 0:
                   clicks++;
                   pause.setText("Resume");
                   game.pause();
                   break;
               case 1:
                   clicks--;
                   pause.setText("Pause");
                   game.resume();
               default:
            }
            });

        restart.setFont(font);
        restart.addActionListener(e -> {
            Sounds.getButton().setVolume(1f);
            Sounds.getButton().play();
            game.restart();
        });

        quit.setFont(font);
        quit.addActionListener(e -> SwingUtilities.invokeLater(() -> System.exit(0)));


    }

    public void incrementProgressBar(int levelNum){
        int n = 0;
        System.out.println("Level Number" + levelNum);
        int limit = levelNum * 25;
        System.out.println("Limits: " + limit);
        while (n <= limit) {
            this.gameProgressBar.setValue(n);
            System.out.println("|:" + (n + 25));
            this.gameProgressBar.updateUI();
            n += 25;
        }
    }

    /**
     * Getters for the JProgressbars
     */

    public JProgressBar getHealthBar() {
        return healthBar;
    }

    public JProgressBar getShardsBar() {
        return shardsBar;
    }

}