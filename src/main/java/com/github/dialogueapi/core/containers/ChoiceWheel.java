package com.github.dialogueapi.core.containers;

import com.github.dialogueapi.DialogueAPI;
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

    public ChoiceWheel(ChoiceWheel wheel, Player player){
        for(Choice choice: wheel.getChoices()){
            choices.add(new Choice(choice, player));
        }
    }

    private List<Choice> getChoices(){return choices;}

    @Override
    public void display(Player player) {
        for(Choice choice: choices){
            choice.display(player);
        }
    }

    public boolean hasID(int id) {
        for(Choice choice: choices){
            if(choice.getId() == id)
                return true;
        }
        return false;
    }
}
