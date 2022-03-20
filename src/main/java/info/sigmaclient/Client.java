package info.sigmaclient;

import info.sigmaclient.gui.altmanager.FileManager;
import info.sigmaclient.gui.click.ClickGui;
import info.sigmaclient.gui.screen.impl.mainmenu.ClientMainMenu;
import info.sigmaclient.management.ColorManager;
import info.sigmaclient.management.FontManager;
import info.sigmaclient.management.command.CommandManager;
import info.sigmaclient.management.friend.FriendManager;
import info.sigmaclient.management.upgrade.UpgradeManager;
import info.sigmaclient.management.users.UserManager;
import info.sigmaclient.management.waypoints.WaypointManager;
import info.sigmaclient.module.Module;
import info.sigmaclient.module.ModuleManager;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;

import java.io.File;

public class Client {
    // Client data
    public static final String author = "Arithmo";

    //Credits: LPK, Tojatta, Aristhena, OG
    public static final String version = "v2.08";
    public static final String clientName = "Sigma";
    public static final int VERSION_CHECK = 3;
    public static Client instance;
    public static ColorManager cm = new ColorManager();
    public static UserManager um;
    public static UpgradeManager upgradeManager;
    public static boolean isLowEndPC;
    public static boolean hasSetup;
    public static ClickGui clickGui;
    public static CommandManager commandManager;
    public static FontManager fm = new FontManager();
    public static WaypointManager wm = new WaypointManager();
    public static boolean outdated;
    private static FileManager fileManager;
    // Managers
    private final ModuleManager moduleManager;
    // Other data
    private File dataDirectory;
    private GuiScreen mainMenu = new ClientMainMenu();
    private boolean isHidden;

    /**
     * TODO: - Work on vanilla hidden mode - Work on making the renderers (help
     * UI vs frame UI) use the same class - Work on MP3 player (See above point)
     * - Add more themes
     **/

    public Client() throws Exception {
        Client.instance = this;
        commandManager = new CommandManager();
        moduleManager = new ModuleManager(Module.class);
        um = new UserManager();
        FriendManager.start();
    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static ClickGui getClickGui() {
        return clickGui;
    }

    public static ModuleManager<Module> getModuleManager() {
        return instance.moduleManager;
    }

    public static File getDataDir() {
        return instance.dataDirectory;
    }

    public static boolean isHidden() {
        return instance.isHidden;
    }

    public static void setHidden(boolean hidden) {
        instance.isHidden = hidden;
        if (hidden) {
            instance.mainMenu = new GuiMainMenu();
        } else {
            instance.mainMenu = new ClientMainMenu();
        }
    }

    public void setup() {
        commandManager.setup();
        dataDirectory = new File(Client.clientName);
        moduleManager.setup();
        (Client.fileManager = new FileManager()).loadFiles();
        clickGui = new ClickGui();
        Module.loadStatus();
        Module.loadSettings();
    }

}
