package ua.wteam.mbedwars;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import ua.wteam.mbedwars.handlers.MainHandler;
import ua.wteam.mbedwars.services.ActionTimersService;

// todo старт игры командой

@Plugin(name = "MBedWars", version = "1.0")
public class MBedWarsPlugin extends JavaPlugin {

    private ActionTimersService actionTimersService;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        actionTimersService = new ActionTimersService();
        getServer().getPluginManager().registerEvents(new MainHandler(this), this);


/*
        String[] strings = getConfig().getString("magic_cores_types").split(";");
        for (String s : strings){
            System.out.println(getConfig().getString("magic_cores." + s + ".manaPerTick"));
        }*/
        /// TEST
        //List<String> baseCoords = new ArrayList<>();
        //baseCoords.add(new Coords(0, 100, 50).toString());
        //baseCoords.add(new Coords(0, -100, 50).toString());
        //baseCoords.add(new Coords(100, 0, 50).toString());
        //baseCoords.add(new Coords(-100, 0, 50).toString());
        //getConfig().set("base_coordinates", baseCoords);
        //saveConfig();
        //List<String> coords = (List<String>) getConfig().getList("base_coordinates");
        //List<Coords> coordsList = new ArrayList<>();
        //coords.forEach(coord -> coordsList.add(new CoordsUtils().getFromString(coord)));
        //coordsList.forEach(System.out::println);
        /// TEST

        //++ загрузка карты,
        // найти спец блоки - генераторы, запомнить корды и тип генераторов
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
    }

    @Override
    public void onDisable() {
        saveConfig();
        actionTimersService.stopService();
    }
}
