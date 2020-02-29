package ua.wteam.mbedwars.scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreBoard {

    private Scoreboard scoreboard;
    private Objective objective;

    public ScoreBoard(String scoreboardName){
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.objective = scoreboard.registerNewObjective(scoreboardName, "dummy");
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public Scoreboard getScoreboard(){
        return scoreboard;
    }

    public ScoreBoard addLine(String teamIndent, String value){
        Team team = scoreboard.registerNewTeam(teamIndent);
        team.addEntry(value);
        objective.getScore("").setScore(0);
        return this;
    }

    public ScoreBoard build(){
        return this;
    }
}
