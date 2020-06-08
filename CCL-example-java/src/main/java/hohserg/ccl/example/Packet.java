package hohserg.ccl.example;

import codechicken.lib.packet.PacketCustom;

public class Packet {
    public static PacketCustom createPacket(int t) {
        return new PacketCustom(Main.modid, t);
    }
}
