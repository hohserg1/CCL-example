package hohserg.ccl.example;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.modid, version = "1.0", name = "CCL-example")
public class Main {
    @SidedProxy(clientSide = "hohserg.ccl.example.ClientProxy", serverSide = "hohserg.ccl.example.CommonProxy")
    public static CommonProxy proxy;
    public static final String modid = "ccl_example";

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent e) {
        proxy.preinit(e);
    }
}
