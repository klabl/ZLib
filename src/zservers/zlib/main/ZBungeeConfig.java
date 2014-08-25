package zservers.zlib.main;

import java.util.logging.Level;

import net.craftminecraft.bungee.bungeeyaml.pluginapi.ConfigurablePlugin;
import net.md_5.bungee.api.ChatColor;

public abstract class ZBungeeConfig extends ConfigurablePlugin implements ZMain {

    private String pluginName;

    public ZBungeeConfig(String pluginName) {

        if(!ZLib.setMainClass(this)) throw new IllegalStateException("There's already a Main-Instance");
        this.pluginName = pluginName;
    }

    @Override
    public void err(String... err) {

        if(getLogLevel() >= 1) {

            synchronized(getLogger()) {

                for(String msg : err)
                    getLogger().log(Level.SEVERE, /*"[" + pluginName + "] "  + */ChatColor.RED + msg);
            }
        }
    }

    @Override
    public void err(Throwable ex, String... err) {

        if(getLogLevel() >= 1) {

            synchronized(getLogger()) {

                for(String msg : err)
                    getLogger().log(Level.SEVERE, /*"[" + pluginName + "] " + */ChatColor.RED + msg);
                getLogger().log(Level.SEVERE, "", ex);
            }
        }
    }

    @Override
    public void wrn(String... wrn) {

        if(getLogLevel() >= 1) {

            synchronized(getLogger()) {

                for(String msg : wrn)
                    getLogger().log(Level.WARNING, /*"[" + pluginName + "] " + */ChatColor.YELLOW + msg);
            }
        }
    }

    @Override
    public void wrn(Throwable ex, String... wrn) {

        if(getLogLevel() >= 1) {

            synchronized(getLogger()) {

                for(String msg : wrn)
                    getLogger().log(Level.WARNING, /*"[" + pluginName + "] " + */ChatColor.YELLOW + msg);
                getLogger().log(Level.WARNING, "", ex);
            }
        }
    }

    @Override
    public void inf(String... inf) {

        if(getLogLevel() >= 2) {

            synchronized(getLogger()) {

                for(String msg : inf)
                    getLogger().log(Level.INFO,	/*"[" + pluginName + "] " + */msg);
            }
        }
    }

    @Override
    public void dbg(String... dbg) {

        if(getLogLevel() >= 3) {

            synchronized(getLogger()) {

                for(String msg : dbg)
                    getLogger().log(Level.INFO, /*"[" + pluginName + "] */"[DBG] " + msg);
            }
        }
    }

    @Override
    public void dbg(Throwable ex, String... dbg) {

        if(getLogLevel() >= 3) {

            synchronized(getLogger()) {

                for(String msg : dbg)
                    getLogger().log(Level.INFO, /*"[" + pluginName + "]*/ "[DBG] " + msg);
                getLogger().log(Level.INFO, "", ex);
            }
        }
    }

    @Override
	public abstract int getLogLevel();

	@Override
	public abstract String getServerName();
}
