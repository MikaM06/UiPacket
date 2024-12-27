package fr.mikam06.main.packet.impl;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import fr.mikam06.main.packet.IECPacket;
import org.bukkit.entity.Player;

public class TestUiPacket implements IECPacket {


    @Override
    public void fromByte(ByteArrayDataInput data) { }

    @Override
    public void toByte(ByteArrayDataOutput data) {

    }

    @Override
    public void handle(Player player) {

    }
}