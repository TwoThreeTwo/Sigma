package net.minecraft.realms;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;

public class RealmsEditBox {
    private static final String __OBFID = "CL_00001858";
    private final GuiTextField editBox;

    public RealmsEditBox(int p_i45743_1_, int p_i45743_2_, int p_i45743_3_, int p_i45743_4_, int p_i45743_5_) {
        editBox = new GuiTextField(p_i45743_1_, Minecraft.getMinecraft().fontRendererObj, p_i45743_2_, p_i45743_3_, p_i45743_4_, p_i45743_5_);
    }

    public String getValue() {
        return editBox.getText();
    }

    public void setValue(String p_setValue_1_) {
        editBox.setText(p_setValue_1_);
    }

    public void tick() {
        editBox.updateCursorCounter();
    }

    public void setFocus(boolean p_setFocus_1_) {
        editBox.setFocused(p_setFocus_1_);
    }

    public void keyPressed(char p_keyPressed_1_, int p_keyPressed_2_) {
        editBox.textboxKeyTyped(p_keyPressed_1_, p_keyPressed_2_);
    }

    public boolean isFocused() {
        return editBox.isFocused();
    }

    public void mouseClicked(int p_mouseClicked_1_, int p_mouseClicked_2_, int p_mouseClicked_3_) {
        editBox.mouseClicked(p_mouseClicked_1_, p_mouseClicked_2_, p_mouseClicked_3_);
    }

    public void render() {
        editBox.drawTextBox();
    }

    public void setMaxLength(int p_setMaxLength_1_) {
        editBox.setMaxStringLength(p_setMaxLength_1_);
    }

    public void setIsEditable(boolean p_setIsEditable_1_) {
        editBox.setEnabled(p_setIsEditable_1_);
    }
}
