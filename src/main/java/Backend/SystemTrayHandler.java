package Backend;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 *
 */
public class SystemTrayHandler
{
    public static volatile boolean openSettings = false;
    public static volatile boolean showUI = false;

    /**
     * Returns a boolean if succesful or not.
     */
    public static void createSystemTray()
    {
        if (!SystemTray.isSupported()) {
            //System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();

        URL url = System.class.getResource("/tray/baseTray.png");
        Image image = null;
        try
        {
            image = ImageIO.read(url);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //Image image = Toolkit.getDefaultToolkit().getImage(url);

        if (image == null)
        {
            System.out.println("WARNING: NO SYSTEMTRAY CAN BE MADE.");
            return;
        }

        final TrayIcon trayIcon = new TrayIcon(image);

        final SystemTray tray = SystemTray.getSystemTray();

        // Create a pop-up menu components
        MenuItem showItem = new MenuItem("Show PAL");
        showItem.addActionListener(e -> showUI = true);

        MenuItem settingsItem = new MenuItem("Settings");
        settingsItem.addActionListener(e -> openSettings = true);
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        //Add components to pop-up menu
        popup.add(showItem);
        popup.add(settingsItem);
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        trayIcon.setToolTip("PoE Addon Launcher\nmade by: twitch.tv/Rizlim");

        try
        {
            tray.add(trayIcon);
        } catch (AWTException e) {
            //System.out.println("TrayIcon could not be added.");
        }
    }
}
