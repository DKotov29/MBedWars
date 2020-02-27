package ua.wteam.mbedwars.scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.TreeMap;

public class ScoreBoard {
    private Scoreboard scoreboard;

    public ScoreBoard(String scoreboardName) {
        ScoreBoard.this.scoreboardManager = Bukkit.getScoreboardManager();
        ScoreBoard.this.scoreboard = scoreboardManager.getNewScoreboard();
        ScoreBoard.this.objective = scoreboard.registerNewObjective(scoreboardName, "dummy");
        ScoreBoard.this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        ScoreBoard.this.scores = new TreeMap<>();
    }

    public void addLine(String value) {
        ScoreBoard.this.scores.put(scores.size(), value);
        return this;
    }

    public void editLine(int key, String value) {
        ScoreBoard.this.scores.replace(key, value);
        return this;
    }

    public ScoreBoard build() {
        scores.forEach((key, value) -> {
            Score score = objective.getScore(value);
            score.setScore(key);
        });
        return ScoreBoard.this;
    }
}
