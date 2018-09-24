package Data;

/**
 *
 */
public class Launcher_Data
{
    private String install_dir;
    private String launcher_location;

    private Launcher_Data()
    {}

    public Launcher_Data(String install, String launcher)
    {
        install_dir = install;
        launcher_location = launcher;
    }

    public String getInstall_dir()
    {
        return install_dir;
    }

    public void setInstall_dir(String install_dir)
    {
        this.install_dir = install_dir;
    }

    public String getLauncher_location()
    {
        return launcher_location;
    }

    public void setLauncher_location(String launcher_location)
    {
        this.launcher_location = launcher_location;
    }
}
