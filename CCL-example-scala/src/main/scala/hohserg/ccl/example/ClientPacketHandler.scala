package hohserg.ccl.example

import codechicken.lib.packet.ICustomPacketHandler.IClientPacketHandler
import codechicken.lib.packet.PacketCustom
import net.minecraft.client.Minecraft
import net.minecraft.network.play.INetHandlerPlayClient

class ClientPacketHandler extends IClientPacketHandler {
  override def handlePacket(packet: PacketCustom, mc: Minecraft, handler: INetHandlerPlayClient): Unit = {}
}
