package hohserg.ccl.example;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

public class ClientUpdate {
    private KeyBinding key = new KeyBinding("potionUse", Keyboard.KEY_H, "HotKeys");

    public ClientUpdate() {
        ClientRegistry.registerKeyBinding(key);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent e) {
        if (Keyboard.isKeyDown(key.getKeyCode())) {
            KeyBinding[] keyBindsHotbar = Minecraft.getMinecraft().gameSettings.keyBindsHotbar;

            for (int i = 0; i < keyBindsHotbar.length; i++) {
                KeyBinding hotbarKeyBinding = keyBindsHotbar[i];
                if (Keyboard.isKeyDown(hotbarKeyBinding.getKeyCode()))
                    Packet.createPacket(1)//Создаем пакет с типом-идентификатором 1
                            .writeInt(i)//Записываем в него индекс хоткея слота инвентаря
                            .sendToServer();//Отправляем}
            }
        }
    }
}
