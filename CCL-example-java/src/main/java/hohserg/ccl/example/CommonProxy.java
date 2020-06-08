package hohserg.ccl.example;

import codechicken.lib.packet.PacketCustom;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preinit(FMLPreInitializationEvent e) {
        //Даже, если у вас есть отдельный класс для серверного прокси, все равно регистрацию серверного обработчика делайте здесь
        PacketCustom.assignHandler(Main.modid/*имя канала не длиннее 20*/, new ServerPacketHandler());
    }
}
