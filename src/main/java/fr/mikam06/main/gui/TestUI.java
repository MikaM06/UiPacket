package fr.mikam06.main.gui;

import fr.mikam06.main.Main;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class TestUI extends GuiScreen {

    private GuiButton button1;
    private GuiButton button2;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Main.MODID, "textures/gui/demo_background.png");

    @Override
    public void initGui() {
        buttonList.add(button1 = new GuiButton(0, this.width / 2 - 100, this.height / 2 - 24, "Button 1"));
        buttonList.add(button2 = new GuiButton(1, this.width / 2 - 100, this.height / 2, "Button 2"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Button 1 pressed!"));
        } else if (button.id == 1) {
            mc.thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Button 2 pressed!"));
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        mc.getTextureManager().bindTexture(TEXTURE);
        int x = (this.width - 256) / 2;
        int y = (this.height - 256) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, 256, 256);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}