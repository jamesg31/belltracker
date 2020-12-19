package me.jamesg31.belltracker;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;

public class BellTracker extends JavaPlugin {
    public static Scoreboard scoreboard;
    public static Objective objective;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        objective = scoreboard.registerNewObjective("bells_interact", "bells_interact");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("Bells Rung");
    }

    public static void playerJoin(Player player) {
        Score newScore = objective.getScore(player.getName());
        newScore.setScore(0);

        player.setScoreboard(scoreboard);
    }

    public static void setScore(Player player) {
        Score score = objective.getScore(player.getName());
        score.setScore(score.getScore() + 1);
    }
}
