package com.github.dialogueapi.core.containers;

import com.github.dialogueapi.core.Choice;
import com.github.dialogueapi.core.Displayable;
import org.spongepowered.api.entity.living.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChoiceWheel implements Displayable {

    /*
     * Container for holding choices
     */

    private List<Choice> choices = new ArrayList<>();

    public ChoiceWheel(List<Choice> choices){this.choices = choices;}

    public ChoiceWheel(ChoiceWheel wheel){
        Collections.copy(choices, wheel.getChoices());
        for(Choice choice: choices){
            choice.setID();
        }
    }

    private List<Choice> getChoices(){return choices;}

    @Override
    public void display(Player player) {

    }

}
