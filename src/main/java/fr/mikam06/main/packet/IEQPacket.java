package fr.mikam06.main.packet;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

public interface IEQPacket {

    public void fromByte(ByteArrayDataInput data);

    public void toByte(ByteArrayDataOutput data);

    public void handle();
}
