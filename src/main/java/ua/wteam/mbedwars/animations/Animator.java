package ua.wteam.mbedwars.animations;

public interface Animator {
    void init(AnimationType animationType, AnimationLevel animationLevel);
    void draw();
    void animationFinished();
}
