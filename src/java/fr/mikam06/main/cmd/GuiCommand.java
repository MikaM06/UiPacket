package fr.mikam06.main.cmd;

import fr.mikam06.main.packet.PacketRegistry;
import fr.mikam06.main.packet.impl.TestUiPacket;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuiCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            TestUiPacket packet = new TestUiPacket();
            player.sendMessage("Opening GUI...");
            PacketRegistry.sendToPlayer(player, packet);
            return true;
        }
        return false;
    }
}