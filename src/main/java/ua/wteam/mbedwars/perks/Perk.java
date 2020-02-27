package ua.wteam.mbedwars.perks;

import org.bukkit.event.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Perk {

    private double allDamageMultiplier = 1;
    private double allDefenseMultipler = 1;
    private double allEttackExtension = 0;
    private double allDefenseExtension = 0;
    private List<Consumer<? extends Event>> actions;

    public Perk(double allDamageMultiplier, double allDefenseMultipler, double allEttackExtension,
                double allDefenseExtension, List<Consumer<? extends Event>> actions) {
        this.allDamageMultiplier = allDamageMultiplier;
        this.allDefenseMultipler = allDefenseMultipler;
        this.allEttackExtension = allEttackExtension;
        this.allDefenseExtension = allDefenseExtension;
        this.actions = actions;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private static class Builder {

        private double allDamageMultiplier = 1;
        private double allDefenseMultipler = 1;
        private double allAttackExtension = 0;
        private double allDefenseExtension = 0;
        private List<Consumer<? extends Event>> actions;

        public Builder() {
            actions = new ArrayList<>();
        }

        public Builder withAllDamageMultiplier(double allDamageMultiplier) {
            this.allDamageMultiplier = allDamageMultiplier;
            return this;
        }

        public Builder withAllDefenseMultipler(double allDefenseMultipler) {
            this.allDefenseMultipler = allDefenseMultipler;
            return this;
        }

        public Builder withAllAttackExtension(double allAttackExtension) {
            this.allAttackExtension = allAttackExtension;
            return this;
        }

        public Builder withAllDefenseExtension(double allDefenseExtension) {
            this.allDefenseExtension = allDefenseExtension;
            return this;
        }

        public Builder addAction(Consumer<? extends Event> action) {
            this.actions.add(action);
            return this;
        }

        public Perk build() {
            return new Perk(this.allDamageMultiplier, this.allDefenseMultipler,
                    this.allAttackExtension, this.allDefenseExtension, this.actions);
        }

    }

}

