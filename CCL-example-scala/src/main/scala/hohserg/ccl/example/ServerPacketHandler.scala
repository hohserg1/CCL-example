package hohserg.ccl.example

import codechicken.lib.packet.ICustomPacketHandler.IServerPacketHandler
import codechicken.lib.packet.PacketCustom
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.init.Items
import net.minecraft.network.play.INetHandlerPlayServer

class ServerPacketHandler extends IServerPacketHandler {
  override def handlePacket(packet: PacketCustom, player: EntityPlayerMP, handler: INetHandlerPlayServer): Unit =
    packet.getType match { //чтобы определить тип-идентификатор пакета
      case 1 =>
        val potionHotSlot = packet.readInt() //читаем из пакета слот, из которого нужно выпить зелье
        val stack = player.inventory.getStackInSlot(9 + potionHotSlot)
        if (stack.getItem == Items.POTIONITEM) { //если в слоте зелька, то Стив выпьет ее одним глотком :D
          val stack1 = Items.POTIONITEM.onItemUseFinish(stack, player.world, player)
          player.inventory.setInventorySlotContents(9 + potionHotSlot, stack1)
        }
      case _ =>
    }
}
