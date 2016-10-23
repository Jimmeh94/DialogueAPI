package com.github.dialogueapi.core;

import com.github.dialogueapi.DialogueAPI;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.Collections;
import java.util.List;

public class Choice implements Displayable{

    /*
     * This is a clickable choice that is linked to an action
     */

    private List<DialogueAction> actions;
    private Text sentence;
    private int id;

    public Choice(Text text, List<DialogueAction> action){
        this.sentence = text;
        this.actions = action;
    }

    public Choice(Choice choice){
        this.actions = choice.getAction();
        this.sentence = Text.of(choice.getSentence());
    }

    public void setID(){
        id = DialogueAPI.getInstance().getDialogueManager().getChoiceID();
        //TODO set json string here
    }

    @Override
    public void display(Player player) {
        DialogueAPI.getInstance().getMessager().sendMessage(player, sentence);
    }

    public void performAction(){
        for(DialogueAction action: actions){
            action.doWork();
        }
    }

    public List<DialogueAction> getAction() {
        return actions;
    }

    public Text getSentence() {
        return sentence;
    }

    public int getId() {
        return id;
    }
}
