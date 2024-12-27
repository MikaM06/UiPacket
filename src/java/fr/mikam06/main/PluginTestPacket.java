package fr.mikam06.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import fr.mikam06.main.cmd.GuiCommand;
import fr.mikam06.main.packet.PacketRegistry;

public class PluginTestPacket extends JavaPlugin {

    PluginManager pluginManager = Bukkit.getPluginManager();
    public static PluginTestPacket plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Register the command
        this.getCommand("gui").setExecutor(new GuiCommand());

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "testui");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "testui", new PacketRegistry());

        getLogger().info("PluginTestPacket has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PluginTestPacket has been disabled!");
    }
}