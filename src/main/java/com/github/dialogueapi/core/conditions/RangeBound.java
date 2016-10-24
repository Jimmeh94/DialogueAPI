package com.github.dialogueapi.core.conditions;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.Condition;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.world.Location;

public class RangeBound implements Condition {

    private double radius = 5.0;
    private Location center;

    public RangeBound(Location center){
        this.center = center;
    }

    public RangeBound(Location center, double radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public boolean isValid(Player player) {
        return center.getPosition().distance(player.getLocation().getPosition()) <= radius;
    }

    @Override
    public void sendErrorMessage(Player player) {
        DialogueAPI.getInstance().getMessager().sendMessage(player, Text.of(TextColors.RED, TextStyles.BOLD, "Too far away from the source to perform that action!"));
    }
}
