package ua.wteam.mbedwars.world;

public class CoordsUtils {

    public Coords getFromString(String coordsSting) {
        String[] strings = coordsSting.replace("[", "").replace("]", "").split(";");
        return new Coords(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
    }

}
