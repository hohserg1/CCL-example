package hohserg.ccl.example

import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = Main.modid, version = "1.0", name = "CCL-example", modLanguage = "scala")
object Main {
  final val modid = "ccl_example"

  @SidedProxy(clientSide = "hohserg.ccl.example.ClientProxy", serverSide = "hohserg.ccl.example.CommonProxy")
  var proxy: CommonProxy = _

  @Mod.EventHandler
  def preinit(e: FMLPreInitializationEvent): Unit =
    proxy.preinit(e)

}
