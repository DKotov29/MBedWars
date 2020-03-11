package ua.wteam.mbedwars.animations;

import org.bukkit.Location;
import org.bukkit.Particle;
import ua.wteam.mbedwars.services.AsyncService;
import ua.wteam.mbedwars.timers.ActionTimer;

import java.util.concurrent.TimeUnit;

public class Animation implements Animator {

    private Particle particle;
    private AsyncService asyncService;
    private Location location;

    private AnimationType animationType;
    private AnimationLevel animationLevel;


    public Animation(Particle particle, Location location){
        this.particle = particle;
        this.location = location;
        this.asyncService = new AsyncService();
    }

    //

    @Override
    public void init(AnimationType animationType, AnimationLevel animationLevel) {
        this.animationType = animationType;
        this.animationLevel = animationLevel;

        // Init animation type and level, can be changed later..

    }

    @Override
    public void draw() {
        asyncService.scheduleRepeatingTask(new ActionTimer(() -> {

        }), 1, 1, TimeUnit.SECONDS);
    }

    @Override
    public void animationFinished() {
        // Stop animation

        //ралзлетятся все партиклы?
        // можно типа растворение в небе сделать, ну в общем разлетаютя вверх
    }
}
