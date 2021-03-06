package net.minecraft.commands.synchronization.brigadier;

import com.google.gson.JsonObject;
import com.mojang.brigadier.arguments.LongArgumentType;
import net.minecraft.commands.synchronization.ArgumentSerializer;
import net.minecraft.network.PacketDataSerializer;

public class ArgumentSerializerLong implements ArgumentSerializer<LongArgumentType> {

    public ArgumentSerializerLong() {}

    public void serializeToNetwork(LongArgumentType longargumenttype, PacketDataSerializer packetdataserializer) {
        boolean flag = longargumenttype.getMinimum() != Long.MIN_VALUE;
        boolean flag1 = longargumenttype.getMaximum() != Long.MAX_VALUE;

        packetdataserializer.writeByte(ArgumentSerializers.createNumberFlags(flag, flag1));
        if (flag) {
            packetdataserializer.writeLong(longargumenttype.getMinimum());
        }

        if (flag1) {
            packetdataserializer.writeLong(longargumenttype.getMaximum());
        }

    }

    @Override
    public LongArgumentType deserializeFromNetwork(PacketDataSerializer packetdataserializer) {
        byte b0 = packetdataserializer.readByte();
        long i = ArgumentSerializers.numberHasMin(b0) ? packetdataserializer.readLong() : Long.MIN_VALUE;
        long j = ArgumentSerializers.numberHasMax(b0) ? packetdataserializer.readLong() : Long.MAX_VALUE;

        return LongArgumentType.longArg(i, j);
    }

    public void serializeToJson(LongArgumentType longargumenttype, JsonObject jsonobject) {
        if (longargumenttype.getMinimum() != Long.MIN_VALUE) {
            jsonobject.addProperty("min", longargumenttype.getMinimum());
        }

        if (longargumenttype.getMaximum() != Long.MAX_VALUE) {
            jsonobject.addProperty("max", longargumenttype.getMaximum());
        }

    }
}
