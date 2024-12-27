package fr.mikam06.main.packet;

import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public interface IECPacket {
    public void fromByte(ByteArrayDataInput data);

    public void toByte(ByteArrayDataOutput data);

    public void handle(Player player);
}