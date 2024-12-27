package fr.mikam06.main.proxy;

import fr.mikam06.main.packet.PacketRegistry;
import fr.mikam06.main.packet.impl.TestUiPacket;

public class CommonProxy {
    public void registerRender() {
    }

    public void registerPacket() {
        PacketRegistry.registerPacket((Class) TestUiPacket.class);
    }
}
