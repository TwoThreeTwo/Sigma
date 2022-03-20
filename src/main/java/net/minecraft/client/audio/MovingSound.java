package net.minecraft.client.audio;

import net.minecraft.util.ResourceLocation;

public abstract class MovingSound extends PositionedSound implements ITickableSound {
    private static final String __OBFID = "CL_00001117";
    protected boolean donePlaying = false;

    protected MovingSound(ResourceLocation location) {
        super(location);
    }

    public boolean isDonePlaying() {
        return this.donePlaying;
    }
}
