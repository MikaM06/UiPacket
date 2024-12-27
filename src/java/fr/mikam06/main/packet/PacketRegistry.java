package fr.mikam06.main.packet;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.mikam06.main.PluginTestPacket;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PacketRegistry implements PluginMessageListener {

    public static void registerPacket(Class<? extends IECPacket> packetClass) {
    }

    public static void sendToPlayer(Player player, IECPacket packet) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        packet.toByte(out);
        player.sendPluginMessage(PluginTestPacket.plugin, "testui", out.toByteArray());
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
    }
}