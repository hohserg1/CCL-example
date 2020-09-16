package hohserg.ccl.example;

import codechicken.lib.packet.PacketCustom;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    public void preinit(FMLPreInitializationEvent e) {
        super.preinit(e);
        PacketCustom.assignHandler(Main.modid, new ClientPacketHandler());
        ClientUpdate.init();
    }
}
