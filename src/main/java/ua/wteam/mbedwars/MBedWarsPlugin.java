package ua.wteam.mbedwars;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import ua.wteam.mbedwars.handlers.MainHandler;
import ua.wteam.mbedwars.services.AsyncService;
import ua.wteam.mbedwars.services.GUIService;
import ua.wteam.mbedwars.services.PerkService;

// todo старт игры командой

@Plugin(name = "MBedWars", version = "1.0")
public class MBedWarsPlugin extends JavaPlugin {

    private AsyncService asyncService;
    private MainHandler mainHandler;
    private PerkService perkService;
    private DefaultsInitializing defaultsInitializing;
    private GUIService guiService;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        asyncService = new AsyncService();
        mainHandler = new MainHandler(this);
        getServer().getPluginManager().registerEvents(mainHandler, this);
        perkService = new PerkService(this);
        guiService = new GUIService();
        defaultsInitializing = new DefaultsInitializing(this);


        //++ загрузка карты,
        // найти спец блоки - генераторы, запомнить корды и тип генераторов
        //
        // при заходе игроков кидать в "лобби" вверху карты, нет возможности ламать ничего, в лобби на голограммах описана игра
        // сервис который проверяет можно ли запустить игру
        //... ожидание 16 игроков, во время этого можно выбрать команду, 3 перка, кит с помощью gui
        // запуск игры
        // отсчет n секунд из конфига
        // раскидать игроков по островам,
        // началась игра, можно ломать поставленные игроками блоки, запустить генераторы
        // с каждым умершим игроком его тиммейтам даются мелкие бонусы в защите+атаке (увеличивается на 0.1 ?)
        // когда остаются люди из 1 тимы - они победили, всех кто еще на сервере кидает в лобби , по центру фигурки этих игроков
        // 15 секунд после победы: стоп сервера
        defaultsInitializing.init();
    }

    public MainHandler getMainHandler() {
        return mainHandler;
    }

    @Override
    public void onDisable() {
        saveConfig();
        asyncService.stopService();
    }

    public GUIService getGuiService() {
        return guiService;
    }

    public AsyncService getAsyncService() {
        return asyncService;
    }

    public PerkService getPerkService() {
        return perkService;
    }
}
