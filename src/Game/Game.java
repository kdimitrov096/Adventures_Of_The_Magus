package Game;

import GUI.AudioControls;
import GUI.ControlPanel;
import GUI.Main_Frame;
import Hero.Controller;
import Hero.Spells.SpellController;
import Hero.Tracker;
import Hero.Wizard;
import Mobs.Golem;
import Sounds.Sounds;
import city.cs.engine.DebugViewer;

import javax.swing.*;
import java.awt.*;


public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevels world;

    /**
     * The Levels
      * @param level1 The first game level of the game.
      * @param level2 The second game level of the game.
      * @param level3 The third game level of the game.
      * @param level4 The forth game level of the game.
     */

    private GameLevels1 level1 = new GameLevels1();
    private GameLevels2 level2 = new GameLevels2();
    private GameLevels3 level3 = new GameLevels3();
    private GameLevels4 level4 = new GameLevels4();

    /**
     * A graphical display of the world (a specialised JPanel).
     * @param view The view of the levels
     */
    private GameView view;

    /**
     * A controller to allow the used to move
     * @param controller A controller for the Wizard
     */
    private Controller controller;

    /**
     * Tracker to follow the controllable Walker(Wizard)
     * @param tracker A controller for the Wizard
     */
    private Tracker tracker;

    /**
     * Integer to keep track of the levels
     * @param level Keeping track of the current level as integer.
     */
    private int level;

    /**
     * The frame of the game in which all action happens.
     * @param frame
     */
    private Main_Frame frame;

    /**
     * The frame of the debug viewer.
     * @param debugView Keeping track of the current debugger
     */
    private JFrame debugView;

    /**
     * The Control Panel
     * @param controlPanel
     */
    private ControlPanel controlPanel;

    /**
     * Controller for the shooting inside the game
     * @param sc keeps track of the controller
     */
    private SpellController sc;


    public Game() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //create the world
        frame = new Main_Frame("Adventures of the Magus", 1000, 500);
        level = 1;
        world = level1;
        Sounds.getBackground().loop();
        world.populate(this);
        //create view
        view = new GameView(this, world, frame.getWidth(), frame.getHeight());

        sc = new SpellController(view, world.getPlayer());
        view.addMouseListener(sc);
        view.addMouseMotionListener(sc);

        view.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());

        controlPanel = new ControlPanel(this);
        controlPanel.setOpaque(false);

        view.add(controlPanel, BorderLayout.CENTER);
        view.add(new AudioControls().getPanControls(), BorderLayout.NORTH);
        getControlPanel().incrementProgressBar(level);
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        // display the view in a frame
        // uncomment this to make a debugging view
        debugView = new DebugViewer(world, 500, 500);
        // display the world in the window
        frame.add(view);
        // size the game window to fit the world view
        frame.pack();
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        //uncomment this to track the player
        tracker = new Tracker(world.getPlayer(), view);
        world.addStepListener(tracker);
        controller = new Controller(world.getPlayer(), world, this);
        frame.addKeyListener(controller);
        //start!
        world.start();
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        new Game();
    }

    public void goToLevel(GameLevels lev) {
        world.stop();

        level = lev.getLevelNumber();

        world = lev;

        view.setWorld(world);

        view.removeMouseListener(sc);
        sc = new SpellController(view, world.getPlayer());
        view.addMouseListener(sc);
        view.addMouseMotionListener(sc);

        //switch the keyboard control to the new player
        controller.setBody(world.getPlayer(), world);
        //transfer the tracker to the new world
        tracker.setBody(world.getPlayer(), view);
        world.addStepListener(tracker);

        debugView.dispose();
        debugView = new DebugViewer(world, 500, 500);

        world.start();

    }

    /**
     * Restart the game
     */
    public void restart() {
        if (level == 1) {
            world.dispose(this);
            world.removeStepListener(tracker);
            world = level1;
            getControlPanel().getHealthBar().setValue(10);
            getControlPanel().getHealthBar().setForeground(Color.GREEN);
            getControlPanel().getShardsBar().setValue(0);
            getControlPanel().setForeground(Color.CYAN);
            getPlayer().setShardcount(0);
            getControlPanel().incrementProgressBar(level);
            world.populate(this);
            view.setWorld(world);

            view.removeMouseListener(sc);
            sc = new SpellController(view, world.getPlayer());
            view.addMouseListener(sc);
            view.addMouseMotionListener(sc);

            controller.setBody(world.getPlayer(), world);
            tracker.setBody(world.getPlayer(), view);
            world.addStepListener(tracker);
            debugView.dispose();
            debugView = new DebugViewer(world, 500, 500);
            world.start();
        } else if (level == 2) {
            world.dispose(this);
            world.removeStepListener(tracker);
            world = level2;
            getControlPanel().getHealthBar().setValue(10);
            getControlPanel().getHealthBar().setForeground(Color.GREEN);
            getControlPanel().getShardsBar().setValue(0);
            getControlPanel().setForeground(Color.CYAN);
            getPlayer().setShardcount(0);
            getControlPanel().incrementProgressBar(level);
            world.populate(this);
            view.setWorld(world);

            view.removeMouseListener(sc);
            sc = new SpellController(view, world.getPlayer());
            view.addMouseListener(sc);
            view.addMouseMotionListener(sc);

            controller.setBody(world.getPlayer(), world);
            tracker.setBody(world.getPlayer(), view);
            world.addStepListener(tracker);
            debugView.dispose();
            debugView = new DebugViewer(world, 500, 500);
            world.start();
        } else if (level == 3) {
            world.dispose(this);
            world.removeStepListener(tracker);
            world = level3;
            getControlPanel().getHealthBar().setValue(10);
            getControlPanel().getHealthBar().setForeground(Color.GREEN);
            getControlPanel().getShardsBar().setValue(0);
            getControlPanel().setForeground(Color.CYAN);
            getPlayer().setShardcount(0);
            getControlPanel().incrementProgressBar(level);
            world.populate(this);
            view.setWorld(world);

            view.removeMouseListener(sc);
            sc = new SpellController(view, world.getPlayer());
            view.addMouseListener(sc);
            view.addMouseMotionListener(sc);

            controller.setBody(world.getPlayer(), world);
            tracker.setBody(world.getPlayer(), view);
            world.addStepListener(tracker);
            debugView.dispose();
            debugView = new DebugViewer(world, 500, 500);
            world.start();
        }
        else if (level == 4) {
            world.dispose(this);
            world.removeStepListener(tracker);
            world = level4;
            getControlPanel().getHealthBar().setValue(10);
            getControlPanel().getHealthBar().setForeground(Color.GREEN);
            getControlPanel().getShardsBar().setValue(0);
            getControlPanel().setForeground(Color.CYAN);
            getPlayer().setShardcount(0);
            getControlPanel().incrementProgressBar(level);
            world.populate(this);
            view.setWorld(world);

            view.removeMouseListener(sc);
            sc = new SpellController(view, world.getPlayer());
            view.addMouseListener(sc);
            view.addMouseMotionListener(sc);

            controller.setBody(world.getPlayer(), world);
            tracker.setBody(world.getPlayer(), view);
            world.addStepListener(tracker);
            debugView.dispose();
            debugView = new DebugViewer(world, 500, 500);
            world.start();
        }
    }

    /**
     * Advance to the next Level of the game.
     */
    void goNextLevel() {
        if (level == 4) {
            System.exit(0);
        } else if (level == 1) {
            level++;
            getControlPanel().incrementProgressBar(level);
            Sounds.getBackground().close();
            if (isCurrentLevelCompleted()) {
                world.getPlayer().destroy();
                world.removeStepListener(tracker);
            }
            //get new level
            world = level2;
            Sounds.getBackground1().loop();
            Sounds.getBackground1().setVolume(0.5f);
            //populate the world
            world.populate(this);
            //show the new level in the view
            view.setWorld(world);

            view.removeMouseListener(sc);
            sc = new SpellController(view, world.getPlayer());
            view.addMouseListener(sc);
            view.addMouseMotionListener(sc);

            //switch the keyboard control to the new player
            controller.setBody(world.getPlayer(), world);
            controller.setWorld(world);
            //transfer the tracker to the new world
            tracker.setBody(world.getPlayer(), view);
            world.addStepListener(tracker);

            debugView.dispose();
            debugView = new DebugViewer(world, 500, 500);

            Sounds.getBackground().loop();
            world.start();
        } else if (level == 2) {
            level++;
            Sounds.getBackground1().close();
            if (isCurrentLevelCompleted()) {
//                getDebugView().dispose();
                world.getPlayer().destroy();
                world.removeStepListener(tracker);
            }
            //get new level
            world = level3;
            Sounds.getBackground2().loop();
            Sounds.getBackground2().setVolume(0.5f);
            getControlPanel().getHealthBar().setValue(10);
            //populate the world
            world.populate(this);
            //show the new level in the view
            view.setWorld(world);

            view.removeMouseListener(sc);
            sc = new SpellController(view, world.getPlayer());
            view.addMouseListener(sc);
            view.addMouseMotionListener(sc);

            //switch the keyboard control to the new player
            controller.setBody(world.getPlayer(), world);
            controller.setWorld(world);
            //transfer the tracker to the new world
            tracker.setBody(world.getPlayer(), view);
            //update tracker
            world.removeStepListener(tracker);
            world.addStepListener(tracker);

            debugView.dispose();
            debugView = new DebugViewer(world, 500, 500);

            world.start();

        }
        else if (level == 3) {
            level++;
            Sounds.getBackground2().close();
            if (isCurrentLevelCompleted()) {
//                getDebugView().dispose();
                world.getPlayer().destroy();
                world.removeStepListener(tracker);
            }
            //get new level
            world = level4;
            Sounds.getBackground3().loop();
            Sounds.getBackground3().setVolume(0.5f);
            getControlPanel().getHealthBar().setValue(10);
            //populate the world
            world.populate(this);
            //show the new level in the view
            view.setWorld(world);

            view.removeMouseListener(sc);
            sc = new SpellController(view, world.getPlayer());
            view.addMouseListener(sc);
            view.addMouseMotionListener(sc);

            //switch the keyboard control to the new player
            controller.setBody(world.getPlayer(), world);
            controller.setWorld(world);
            //transfer the tracker to the new world
            tracker.setBody(world.getPlayer(), view);
            //update tracker
            world.removeStepListener(tracker);
            world.addStepListener(tracker);

            debugView.dispose();
            debugView = new DebugViewer(world, 500, 500);

            world.start();


        }
    }

    /**
     * Is the current level of the game completed?
     */
    boolean isCurrentLevelCompleted() { return world.isCompleted(); }

    /**
     * Getter for the world
     */
    public GameLevels getWorld() { return world; }

    /**
     * The player in the current level.
     */
    Wizard getPlayer() { return world.getPlayer(); }

    /**
     * The golem in the current level.
     */
    Golem getGolem() { return world.getGolem(); }

    /**
     * pauses the game
     */
    public void pause() { world.stop(); }

    /**
     * resumes the game
     */
    public void resume() {
        world.start();
    }

    /**
     * Getter for the view
     */
    GameView getView() {
        return view;
    }

    /**
     * Getter for the frame
     */
    JFrame getFrame() {
        return frame;
    }

    /**
     * Getter for the game
     */
    public Game getGame() { return this; }

    /**
     * Getter for the Control Panel
     */
    public ControlPanel getControlPanel() { return this.controlPanel; }
}
