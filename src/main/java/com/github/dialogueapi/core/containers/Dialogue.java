package com.github.dialogueapi.core.containers;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.Choice;
import com.github.dialogueapi.core.Displayable;
import com.github.dialogueapi.core.Sentence;
import org.spongepowered.api.entity.living.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Dialogue {

    /*
     * Container for whole conversation, both sentences and actions
     * Each dialogue should only contain up to one choice
     * If an option in that Choice continues the conversation, that next part of the conversation
     * should be another Dialogue, using the DisplayDialogue DialogueAction as part of theat particular Choice
     */

    private List<Displayable> dialogue = new ArrayList<>();
    private Player player;
    private int dialogueID;

    public Dialogue(Player player, Dialogue dialogue){
        this.player = player;
        this.dialogue = dialogue.copyDialogueSequence();
    }

    public Dialogue(List<Displayable> displayables, int id){
        this.dialogue = displayables;
        dialogueID = id;
    }

    public Player getPlayer() {
        return player;
    }

    public int getDialogueID() {
        return dialogueID;
    }

    private List<Displayable> copyDialogueSequence(){
       List<Displayable> give = new ArrayList<>();
       for(Displayable displayable: dialogue){
           if(displayable instanceof Sentence){
                give.add(new Sentence((Sentence) displayable));
           } else {
               give.add(new ChoiceWheel((ChoiceWheel) displayable));
           }
       }
        return give;
    }

    public boolean hasChoiceID(int id){
        for(Displayable displayable: dialogue){
            if(displayable instanceof Choice && ((Choice) displayable).getId() == id){
                return true;
            }
        }
        return false;
    }

    public void displayNext(){
        if(dialogue.size() > 0){
            boolean shouldContinue = true;
            while(shouldContinue) {
                dialogue.get(0).display(this.player);
                if(dialogue.get(0) instanceof Choice)
                    shouldContinue = false;
                dialogue.remove(0);
                if (dialogue.size() == 0) {
                    DialogueAPI.getInstance().getDialogueManager().removeDialogue(player);
                    shouldContinue = false;
                }
            }
        }
    }

}
