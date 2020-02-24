package ua.wteam.mbedwars.actions;

import java.util.function.Consumer;

@FunctionalInterface
public interface EventActionConsumer<T> extends Consumer<T> {

    @Override
    void accept(T t);

}
