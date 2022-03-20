package net.minecraft.client.renderer.texture;

import net.minecraft.client.resources.IResourceManager;

import java.io.IOException;

public interface ITextureObject {
    void func_174936_b(boolean p_174936_1_, boolean p_174936_2_);

    void func_174935_a();

    void loadTexture(IResourceManager p_110551_1_) throws IOException;

    int getGlTextureId();
}
