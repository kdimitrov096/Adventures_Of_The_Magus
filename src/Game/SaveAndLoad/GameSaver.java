package Game.SaveAndLoad;

import Game.GameLevels;
import Game.Platforms;
import Game.ReaderAndWriter.HighScoreWriter;
import Hero.Wizard;
import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {

    private String fileName;

    public GameSaver(String fileName) {
        this.fileName = fileName;
    }

    public void saveGame(GameLevels gameLevels ) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {

            writer.write(gameLevels.getLevelNumber() + "\n");


            writer.write(
                    gameLevels.getPlayer().getClass().getSimpleName() + "," +
                            gameLevels.getPlayer().getPosition().x + "," +
                            gameLevels.getPlayer().getPosition().y + "," +
                            gameLevels.getPlayer().getShardcount() + "\n");

            for (DynamicBody body : gameLevels.getDynamicBodies()) {
                if (!(body instanceof Wizard)) {
                    writer.write(body.getClass().getSimpleName() + "," + body.getPosition().x + "," + body.getPosition().y + "\n");
                }
            }
            for (StaticBody body : gameLevels.getStaticBodies()) {

                if (body instanceof Platforms)
                    writer.write(
                            body.getClass().getSimpleName() + "," +
                                    body.getPosition().x + "," +
                                    body.getPosition().y + "," +
                                    ((Platforms) body).getWidth() + "," +
                                    ((Platforms) body).getHeight() + "," +

                                    "\n");
            }

        }
    }

    public static void main(String[] args) throws IOException {
        HighScoreWriter hsWriter = new HighScoreWriter("sample.hs");
        for (int i = 0; i < args.length; i += 2) {
            String name = args[i];
            int score = Integer.parseInt(args[i + 1]);
            hsWriter.writeHighScore(name, score);
        }
    }

}
