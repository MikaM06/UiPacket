package fr.mikam06.main.packet;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.google.gson.internal.UnsafeAllocator;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import fr.mikam06.main.Main;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.ArrayList;
import java.util.List;

public class PacketRegistry {
    public static List<Class<? extends IEQPacket>> packetList = new ArrayList<Class<? extends IEQPacket>>();

    public static void registerPacket(Class<? extends IEQPacket> packet) {
        PacketRegistry.packetList.add(packet);
    }

    public static void handlePacket(ByteBuf byteBuf) {
        ByteArrayDataInput data = ByteStreams.newDataInput(byteBuf.array());

        IEQPacket packet;
        try {
            packet = (IEQPacket) UnsafeAllocator.create().newInstance((Class)PacketRegistry.packetList.get(data.readInt()));
            packet.fromByte(data);
            packet.handle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static FMLProxyPacket getPacket(IEQPacket packet) {
        if(PacketRegistry.packetList.contains(packet.getClass())){
            ByteArrayDataOutput data = ByteStreams.newDataOutput();
            data.writeInt(PacketRegistry.packetList.indexOf(packet.getClass()));
            packet.toByte(data);
            return new FMLProxyPacket(Unpooled.wrappedBuffer(data.toByteArray()), "test");
        }
        return null;
    }

    public static void sendToServer(IEQPacket packet) {
        Main.channel.sendToServer(PacketRegistry.getPacket(packet));
    }

    public static void sendToPlayer(IEQPacket packet, EntityPlayerMP player) {
        Main.channel.sendTo(PacketRegistry.getPacket(packet), player);
    }

    public static void sendToAllPlayer(IEQPacket packet, EntityPlayerMP player) {
        Main.channel.sendToAll(PacketRegistry.getPacket(packet));
    }
}
