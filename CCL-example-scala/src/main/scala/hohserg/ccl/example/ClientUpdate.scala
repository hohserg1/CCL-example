package hohserg.ccl.example

import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent
import net.minecraftforge.fml.relauncher.{Side, SideOnly}
import org.lwjgl.input.Keyboard

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Main.modid, value = Array(Side.CLIENT))
object ClientUpdate {
  private val key = new KeyBinding("potionUse", Keyboard.KEY_H, "HotKeys")

  def init(): Unit = {
    ClientRegistry.registerKeyBinding(key)
  }

  @SubscribeEvent
  def onKeyPress(e: InputEvent.KeyInputEvent): Unit = {
    if (Keyboard.isKeyDown(key.getKeyCode)) {
      val keyBindsHotbar = Minecraft.getMinecraft.gameSettings.keyBindsHotbar
      var key = 0
      while ( {
        key < keyBindsHotbar.length
      }) {
        if (Keyboard.isKeyDown(keyBindsHotbar(key).getKeyCode)) {
          Packet.createPacket(1)
            .writeInt(key) //Создаем пакет с типом-идентификатором 1
            .sendToServer() //Записываем в него индекс хоткея слота инвентаря
          () //Отправляем
        }
        {
          key += 1;
          key - 1
        }
      }
    }
  }

}
