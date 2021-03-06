package hohserg.ccl.example;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Main.modid, value = Side.CLIENT)
public class ClientUpdate {
    private static KeyBinding key = new KeyBinding("potionUse", Keyboard.KEY_H, "HotKeys");

    public static void init() {
        ClientRegistry.registerKeyBinding(key);
    }

    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent e) {
        if (Keyboard.isKeyDown(key.getKeyCode())) {
            KeyBinding[] keyBindsHotbar = Minecraft.getMinecraft().gameSettings.keyBindsHotbar;

            for (int key = 0; key < keyBindsHotbar.length; key++)
                if (Keyboard.isKeyDown(keyBindsHotbar[key].getKeyCode()))
                    Packet.createPacket(1)//Создаем пакет с типом-идентификатором 1
                            .writeInt(key)//Записываем в него индекс хоткея слота инвентаря
                            .sendToServer();//Отправляем
        }
    }
}
