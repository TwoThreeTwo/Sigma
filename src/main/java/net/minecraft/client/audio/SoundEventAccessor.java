package net.minecraft.client.audio;

public class SoundEventAccessor implements ISoundEventAccessor {
    private static final String __OBFID = "CL_00001153";
    private final SoundPoolEntry entry;
    private final int weight;

    SoundEventAccessor(SoundPoolEntry entry, int weight) {
        this.entry = entry;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public SoundPoolEntry cloneEntry() {
        return new SoundPoolEntry(this.entry);
    }
}
