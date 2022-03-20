package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiScreenOptionsSounds extends GuiScreen {
    private static final String __OBFID = "CL_00000716";
    private final GuiScreen field_146505_f;
    /**
     * Reference to the GameSettings object.
     */
    private final GameSettings game_settings_4;
    protected String field_146507_a = "Options";
    private String field_146508_h;

    public GuiScreenOptionsSounds(GuiScreen p_i45025_1_, GameSettings p_i45025_2_) {
        this.field_146505_f = p_i45025_1_;
        this.game_settings_4 = p_i45025_2_;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui() {
        byte var1 = 0;
        this.field_146507_a = I18n.format("options.sounds.title", new Object[0]);
        this.field_146508_h = I18n.format("options.off", new Object[0]);
        this.buttonList.add(new GuiScreenOptionsSounds.Button(SoundCategory.MASTER.getCategoryId(), this.width / 2 - 155 + var1 % 2 * 160, this.height / 6 - 12 + 24 * (var1 >> 1), SoundCategory.MASTER, true));
        int var6 = var1 + 2;
        SoundCategory[] var2 = SoundCategory.values();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            SoundCategory var5 = var2[var4];

            if (var5 != SoundCategory.MASTER) {
                this.buttonList.add(new GuiScreenOptionsSounds.Button(var5.getCategoryId(), this.width / 2 - 155 + var6 % 2 * 160, this.height / 6 - 12 + 24 * (var6 >> 1), var5, false));
                ++var6;
            }
        }

        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }

    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.enabled) {
            if (button.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.field_146505_f);
            }
        }
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.field_146507_a, this.width / 2, 15, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    protected String getSoundVolume(SoundCategory p_146504_1_) {
        float var2 = this.game_settings_4.getSoundLevel(p_146504_1_);
        return var2 == 0.0F ? this.field_146508_h : (int) (var2 * 100.0F) + "%";
    }

    class Button extends GuiButton {
        private static final String __OBFID = "CL_00000717";
        private final SoundCategory field_146153_r;
        private final String field_146152_s;
        public float field_146156_o = 1.0F;
        public boolean field_146155_p;

        public Button(int p_i45024_2_, int p_i45024_3_, int p_i45024_4_, SoundCategory p_i45024_5_, boolean p_i45024_6_) {
            super(p_i45024_2_, p_i45024_3_, p_i45024_4_, p_i45024_6_ ? 310 : 150, 20, "");
            this.field_146153_r = p_i45024_5_;
            this.field_146152_s = I18n.format("soundCategory." + p_i45024_5_.getCategoryName(), new Object[0]);
            this.displayString = this.field_146152_s + ": " + GuiScreenOptionsSounds.this.getSoundVolume(p_i45024_5_);
            this.field_146156_o = GuiScreenOptionsSounds.this.game_settings_4.getSoundLevel(p_i45024_5_);
        }

        protected int getHoverState(boolean mouseOver) {
            return 0;
        }

        protected void mouseDragged(Minecraft mc, int mouseX, int mouseY) {
            if (this.visible) {
                if (this.field_146155_p) {
                    this.field_146156_o = (float) (mouseX - (this.xPosition + 4)) / (float) (this.width - 8);
                    this.field_146156_o = MathHelper.clamp_float(this.field_146156_o, 0.0F, 1.0F);
                    mc.gameSettings.setSoundLevel(this.field_146153_r, this.field_146156_o);
                    mc.gameSettings.saveOptions();
                    this.displayString = this.field_146152_s + ": " + GuiScreenOptionsSounds.this.getSoundVolume(this.field_146153_r);
                }

                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                this.drawTexturedModalRect(this.xPosition + (int) (this.field_146156_o * (float) (this.width - 8)), this.yPosition, 0, 66, 4, 20);
                this.drawTexturedModalRect(this.xPosition + (int) (this.field_146156_o * (float) (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
            }
        }

        public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
            if (super.mousePressed(mc, mouseX, mouseY)) {
                this.field_146156_o = (float) (mouseX - (this.xPosition + 4)) / (float) (this.width - 8);
                this.field_146156_o = MathHelper.clamp_float(this.field_146156_o, 0.0F, 1.0F);
                mc.gameSettings.setSoundLevel(this.field_146153_r, this.field_146156_o);
                mc.gameSettings.saveOptions();
                this.displayString = this.field_146152_s + ": " + GuiScreenOptionsSounds.this.getSoundVolume(this.field_146153_r);
                this.field_146155_p = true;
                return true;
            } else {
                return false;
            }
        }

        public void playPressSound(SoundHandler soundHandlerIn) {
        }

        public void mouseReleased(int mouseX, int mouseY) {
            if (this.field_146155_p) {
                if (this.field_146153_r == SoundCategory.MASTER) {
                    float var10000 = 1.0F;
                } else {
                    GuiScreenOptionsSounds.this.game_settings_4.getSoundLevel(this.field_146153_r);
                }

                GuiScreenOptionsSounds.this.mc.getSoundHandler().playSound(PositionedSoundRecord.createPositionedSoundRecord(new ResourceLocation("gui.button.press"), 1.0F));
            }

            this.field_146155_p = false;
        }
    }
}
