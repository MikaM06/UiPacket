package fr.mikam06.main.packet;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import fr.mikam06.main.packet.impl.TestUiPacket;

public class PacketHandler {


    @SubscribeEvent
    public void onClientPacketData(FMLNetworkEvent.ClientCustomPacketEvent event) {
        if (event.packet.channel().equals("testui")) {
            TestUiPacket packet = new TestUiPacket();
            packet.handle();
        }
    }
}
