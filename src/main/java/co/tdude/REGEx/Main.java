package co.tdude.REGEx;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tristan on 2015-05-30.
 */
public class Main extends JavaPlugin implements Listener{

    private List<String> regexes;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        regexes = new ArrayList<String>();

        regexes.add("\\/(tell|me) @(p|r|e|a).*[\\s\\w]*$");
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onText(PlayerCommandPreprocessEvent event) {
        for (String reg : regexes) {
            if (event.getMessage().matches(reg)) {
                event.setCancelled(true);
            }
        }
    }

}
