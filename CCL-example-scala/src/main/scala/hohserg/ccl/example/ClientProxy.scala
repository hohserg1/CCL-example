package hohserg.ccl.example

import codechicken.lib.packet.PacketCustom
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

class ClientProxy extends CommonProxy{
  override def preinit(e: FMLPreInitializationEvent): Unit = {
    super.preinit(e)
    PacketCustom.assignHandler(Main.modid, new ClientPacketHandler)
    ClientUpdate.init()
  }
}
