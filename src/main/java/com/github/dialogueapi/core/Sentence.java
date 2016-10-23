package com.github.dialogueapi.core;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.utilities.Messager;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence implements Displayable{
    /*
     * This is text presented by the server/NPC to a player
     */

    private List<Text> sentences;
    private boolean timedDisplay = false;

    public Sentence(Text... texts){
        sentences = Arrays.asList(texts);
    }

    public Sentence(boolean timedDisplay, Text... texts){
        this.timedDisplay = timedDisplay;
        sentences = Arrays.asList(texts);
    }

    public Sentence(Sentence sentence){
        this.sentences = new ArrayList<>(sentence.getSentences());
        this.timedDisplay = sentence.isTimedDisplay();
    }

    @Override
    public void display(Player player) {
        if(isTimedDisplay()){
            //display one at a time
            //remove the most recent displayed
        } else {
            for(Text text: sentences) {
                DialogueAPI.getInstance().getMessager().sendMessage(player, text);
            }
        }
    }

    public boolean isAllDisplayed(){
        return sentences.size() == 0;
    }

    public List<Text> getSentences() {
        return sentences;
    }

    public boolean isTimedDisplay() {
        return timedDisplay;
    }
}
