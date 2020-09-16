package hohserg.ccl.example;

import codechicken.lib.packet.ICustomPacketHandler.IServerPacketHandler;
import codechicken.lib.packet.PacketCustom;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.INetHandlerPlayServer;

public class ServerPacketHandler implements IServerPacketHandler {
    @Override
    public void handlePacket(PacketCustom packetCustom, EntityPlayerMP player, INetHandlerPlayServer iNetHandlerPlayServer) {
        switch (packetCustom.getType()) {//чтобы определить тип-идентификатор пакета
            case 1:
                int potionHotSlot = packetCustom.readInt();//читаем из пакета слот, из которого нужно выпить зелье
                ItemStack stack = player.inventory.getStackInSlot(9 + potionHotSlot);
                if (stack.getItem() == Items.POTIONITEM)//если в слоте зелька, то Стив выпьет ее одним глотком :D
                {
                    ItemStack stack1 = Items.POTIONITEM.onItemUseFinish(stack, player.world, player);
                    player.inventory.setInventorySlotContents(9 + potionHotSlot, stack1);
                }
                break;
            default:

        }

    }
}
