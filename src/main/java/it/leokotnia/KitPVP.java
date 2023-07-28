package it.leokotnia;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class KitPVP extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("KitPvP Plugin has been enabled!");
        getLogger().info("By leokotnia!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("KitPvP Plugin has been disabled!");
        getLogger().info("Need support? Join the discord below!");
        getLogger().info("https://discord.gg/EzcVzUm7Vq");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kit1")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by players.");
                return true;
            }

            Player player = (Player) sender;

            // Give the player a diamond sword
            player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));

            // Give the player 16 golden apples
            player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 16));

            player.getInventory().addItem(new ItemStack(Material.BOW));

            player.getInventory().addItem(new ItemStack(Material.ARROW, 24));

            player.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));

            // Give the player a diamond axe
            player.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));

            player.sendMessage("You have received the Normal Kit!");

            return true;
        }

        if (cmd.getName().equalsIgnoreCase("kit2")) {
            if (!sender.hasPermission("kitpvp.vip")) {
                sender.sendMessage("You don't have permission to use this command.");
                return true;
            }

            Player player = (Player) sender;

            player.getInventory().setItemInMainHand(new ItemStack(Material.NETHERITE_SWORD));
            player.getInventory().setItemInOffHand(new ItemStack(Material.TOTEM_OF_UNDYING, 24));
            player.getInventory().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            player.getInventory().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            player.getInventory().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            player.getInventory().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
            player.getInventory().addItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 25));
            player.getInventory().addItem(new ItemStack(Material.END_CRYSTAL, 576));

            player.sendMessage("You have received CrystalPVP Kit!");

            return true;
        }

        if (cmd.getName().equalsIgnoreCase("kitpvp")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be executed by players.");
                return true;
            }

            Player player = (Player) sender;

            player.sendMessage("KitPVP for 1.16 and above by leokotnia");
            player.sendMessage("Made with love!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("kits")) {
            if (!sender.hasPermission("kitpvp.vip1")) {
                sender.sendMessage("Kits available:");
                sender.sendMessage("Normal Kit (Do /kit1)");
                return true;
            } else {
                sender.sendMessage("Kits available:");
                sender.sendMessage("Normal Kit (Do /kit1)");
                sender.sendMessage("CrystalPVP Kit (Do /kit2)");
                return true;
            }
        }

        return false;
    }
}
