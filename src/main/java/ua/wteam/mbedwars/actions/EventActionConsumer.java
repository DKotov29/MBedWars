package ua.wteam.mbedwars.actions;

import org.bukkit.event.Event;

import java.util.function.Consumer;

@FunctionalInterface
public interface EventActionConsumer<T extends Event> extends Consumer<T> {

    @Override
    void accept(T t);

}
