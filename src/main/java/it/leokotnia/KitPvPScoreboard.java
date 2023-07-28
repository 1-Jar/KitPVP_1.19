package it.leokotnia;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class KitPvPScoreboard implements Listener {

    private final JavaPlugin plugin;
    private final ScoreboardManager scoreboardManager;
    private final Scoreboard scoreboard;
    private final Objective objective;

    public KitPvPScoreboard(KitPVP plugin) {
        this.plugin = plugin;
        this.scoreboardManager = Bukkit.getScoreboardManager();
        this.scoreboard = scoreboardManager.getNewScoreboard();
        this.objective = scoreboard.registerNewObjective("kitpvp", "dummy", ChatColor.BLUE + "PowerPixel");
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    public void setScoreboard(Player player) {
        player.setScoreboard(scoreboard);
    }

    public void updateFooter() {
        objective.setDisplayName(ChatColor.GREEN + "KitPVP");
        scoreboard.getTeam("footer").setPrefix(ChatColor.YELLOW + "powerpixel.cloud");
    }
}

