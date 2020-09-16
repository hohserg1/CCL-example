package hohserg.ccl.example

import codechicken.lib.packet.PacketCustom

object Packet {
  def createPacket(`type`: Int) = new PacketCustom(Main.modid, `type`)
}
