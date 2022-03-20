package info.sigmaclient.module.impl.minigames;

import info.sigmaclient.event.Event;
import info.sigmaclient.event.RegisterEvent;
import info.sigmaclient.event.impl.EventTick;
import info.sigmaclient.management.command.Command;
import info.sigmaclient.module.Module;
import info.sigmaclient.module.data.ModuleData;
import info.sigmaclient.module.data.Options;
import info.sigmaclient.module.data.Setting;
import info.sigmaclient.util.misc.ChatUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;

/**
 * Created by Arithmo on 5/5/2017 at 12:35 AM.
 */
public class Murder extends Module {

    private String MESSAGE = "MESSAGE";
    private String MODE = "MODE";
    private info.sigmaclient.util.Timer timer = new info.sigmaclient.util.Timer();

    public Murder(ModuleData data) {
        super(data);
        settings.put(MESSAGE, new Setting<>(MESSAGE, "{P} is trying to kill me!", "Sends a chat message. {P} = Murderer"));
        settings.put(MODE, new Setting<>(MODE, new Options("Chat Mode", "Client", new String[]{"Client", "Server"}), "Chat mesage mode."));
    }

    @Override
    @RegisterEvent(events = EventTick.class)
    public void onEvent(Event event) {
        for (Object o : mc.theWorld.loadedEntityList) {
            if (o instanceof EntityPlayer && timer.delay(15000)) {
                EntityPlayer ent = (EntityPlayer) o;
                if (ent != mc.thePlayer && ent.getCurrentEquippedItem() != null && ent.getCurrentEquippedItem().getItem() instanceof ItemSword && !ent.isMurderer) {
                    ent.isMurderer = true;
                    switch (((Options) settings.get(MODE).getValue()).getSelected()) {
                        case "Server": {
                            String customChat = ((String) settings.get(MESSAGE).getValue());
                            customChat = customChat.replace("{P}", "%s");
                            ChatUtil.sendChat(String.format(customChat, ent.getName()));
                            break;
                        }
                        case "Client": {
                            ChatUtil.printChat(Command.chatPrefix + "\247d" + ent.getName() + " \2477is the murderer!");
                            break;
                        }
                    }
                }
            }
        }
    }

}
