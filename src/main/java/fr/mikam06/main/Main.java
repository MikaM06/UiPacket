package fr.mikam06.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import fr.mikam06.main.packet.PacketHandler;
import fr.mikam06.main.proxy.CommonProxy;

@Mod(modid = Main.MODID, version = Main.VERSION, name = Main.NAME)
public class Main {

    public static final String MODID = "packet";
    public static final String VERSION = "1.0";
    public static final String NAME = "UiPacket-Mods";

    public static final String CLIENT = "fr.mikam06.main.proxy.ClientProxy";
    public static final String COMMON = "fr.mikam06.main.proxy.CommonProxy";

    public static FMLEventChannel channel;


    @SidedProxy(clientSide = Main.CLIENT, serverSide = Main.COMMON)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    }

    @Mod.EventHandler
    public void init(FMLPreInitializationEvent e) {
        proxy.registerRender();
        proxy.registerPacket();

        this.channel = NetworkRegistry.INSTANCE.newEventDrivenChannel("testui");
        this.channel.register(new PacketHandler());
        Main.proxy.registerPacket();

        e.getModLog().info("QuestUI is loaded");
    }

    @Mod.EventHandler
    public void postInit(FMLPreInitializationEvent e) {
    }

}
