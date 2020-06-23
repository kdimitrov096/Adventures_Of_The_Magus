package Game.SaveAndLoad;

import Collectables.Shards;
import Game.Platforms;
import Game.Portal;
import Game.PortalListener;
import Game.Game;
import Game.Pickup;
import Game.GameLevels;
import Game.GameLevels1;
import Game.GameLevels2;
import Game.GameLevels3;
import Game.ReaderAndWriter.HighScoreReader;
import Hero.Wizard;
import Mobs.Golem;
import city.cs.engine.Body;
import org.jbox2d.common.Vec2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameLoader {
    private String fileName;
    private static Game game;

    /**
     * Initialise a new HighScoreReader
     * @param fileName the name of the high-score file
     */
    public GameLoader(String fileName, Game game) {
        this.fileName = fileName;
        GameLoader.game = game;

    }

    /**
     * Read the high-score data from the high-score file and print it to
     * the terminal window.
     */
    public GameLevels loadGame() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);

            String line = reader.readLine();
            int levelNumber = Integer.parseInt(line);

            GameLevels level = null;
            if (levelNumber == 1){
                level = new GameLevels1();

            }
            else if (levelNumber == 2 ) {
                level = new GameLevels2();
            }
            else if (levelNumber == 3 ) {
                level = new GameLevels3();
            }

            while ((line = reader.readLine()) != null){
                String[] tokens = line.split(",");
                String className = tokens[0];
                float xPlayer = Float.parseFloat(tokens[1]);
                float yPlayer = Float.parseFloat(tokens[2]);
                Vec2 posPlayer = new Vec2(xPlayer,yPlayer);

                if (className.equals("Wizard")) {
                    int count = Integer.parseInt(tokens[3]);
                    Wizard b = new Wizard(game, level);
                    b.setPosition(posPlayer);
                    b.setShardcount(count);
                    assert level != null;
                    level.setPlayer(b);
                }
                if (className.equals("Portal")) {
                    Body b = new Portal(level);
                    b.setPosition(posPlayer);
                    b.addCollisionListener(new PortalListener(game));
                }
                if (className.equals("Shards")) {
                    Body b = new Shards(level);
                    b.setPosition(posPlayer);
                    assert level != null;
                    b.addCollisionListener(new Pickup(level.getPlayer()));
                }
                if (className.equals("Golem")) {
                    Body b = new Golem(level);
                    b.setPosition(posPlayer);
                }
                if (className.equals("Platforms")){
                    float w = Float.parseFloat(tokens[3]);
                    float h = Float.parseFloat(tokens[4]);

                    Body b = new Platforms(level, w, h );
                    b.setPosition(posPlayer);
                }
            }
            return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HighScoreReader demo = new HighScoreReader(args[0]);
        demo.readScores();
    }
}
