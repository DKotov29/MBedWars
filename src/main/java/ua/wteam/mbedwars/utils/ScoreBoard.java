package ua.wteam.mbedwars.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {

    private Scoreboard scoreboard;
    private Objective objective;
    private List<Score> scores;

    public ScoreBoard(String scoreboardName){
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.objective = scoreboard.registerNewObjective(scoreboardName, "dummy");
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        this.scores = new ArrayList<>();
    }

    public void addLines(List<String> values){
        values.forEach(value -> {
            if (value.length() > 40) return;

            scores.add(objective.getScore(value));
        });
    }

    public void addLine(String value){
        if (value.length() > 40) return;

        scores.add(objective.getScore(value));
    }

    public void editLine(int index, String newValue) {
        if (newValue.length() > 40) return;

        scoreboard.resetScores(scores.get(index).getEntry());
        scores.remove(index);
        scores.add(index, objective.getScore(newValue));

        applyToScoreboard();
    }

    public void updateForPlayer(Player player){
        player.setScoreboard(scoreboard);
    }

    public void updateForPlayers() {
        Bukkit.getOnlinePlayers().forEach(
                player -> player.setScoreboard(scoreboard)
        );
    }

    private void applyToScoreboard(){
        Collections.reverse(scores);
        for(int i = 0; i < scores.size(); i++){
            scores.get(i).setScore(i + (i / scores.size()));
        }
        Collections.reverse(scores);
    }
}
