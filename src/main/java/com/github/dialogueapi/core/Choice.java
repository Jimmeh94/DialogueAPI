package com.github.dialogueapi.core;

import org.spongepowered.api.entity.living.player.Player;

public class Choice implements Displayable{

    /*
     * This is a clickable choice that is linked to an action
     */

    private DialogueAction action;

    @Override
    public void display(Player player) {

    }

    public Choice(DialogueAction action){
        this.action = action;
    }

}
