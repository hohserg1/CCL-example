package hohserg.ccl.example;

import codechicken.lib.packet.PacketCustom;

public class Packet {
    public static PacketCustom createPacket(int type) {
        return new PacketCustom(Main.modid, type);
    }
}
