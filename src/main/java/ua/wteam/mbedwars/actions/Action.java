package ua.wteam.mbedwars.actions;

@FunctionalInterface
public interface Action extends Runnable {

    @Override
    abstract void run();

}