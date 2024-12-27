package fr.mikam06.main.packet.impl;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import fr.mikam06.main.gui.TestUI;
import fr.mikam06.main.packet.IEQPacket;
import net.minecraft.client.Minecraft;

public class TestUiPacket implements IEQPacket {

    Minecraft mc = Minecraft.getMinecraft();

    @Override
    public void fromByte(ByteArrayDataInput data) {
    }

    @Override
    public void toByte(ByteArrayDataOutput data) {
    }

    @Override
    public void handle() {
        mc.displayGuiScreen(new TestUI());
    }
}
