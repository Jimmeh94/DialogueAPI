package com.github.dialogueapi.core.builders;

import com.github.dialogueapi.core.Choice;
import com.github.dialogueapi.core.DialogueAction;
import com.github.dialogueapi.core.Displayable;
import com.github.dialogueapi.core.Sentence;
import com.github.dialogueapi.core.containers.ChoiceWheel;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayableBuilder {

    /*
     * Here, if choice wheel is left false, this will build a sentence
     * Otherwise, it will build a choice wheel
     */

    private List<Text> sentences = new ArrayList<>();
    private boolean timedDisplay = false, choiceWheel = false;
    private List<Choice> choices = new ArrayList<>();

    public DisplayableBuilder addSentence(Text text){
        sentences.add(text);
        return this;
    }

    public DisplayableBuilder addChoice(Text text, DialogueAction... action){
        choices.add(new Choice(text, Arrays.asList(action)));
        return this;
    }

    public DisplayableBuilder setTimedDisplay(boolean value){
        timedDisplay = value;
        return this;
    }

    public DisplayableBuilder setChoiceWheel(boolean value){
        choiceWheel = value;
        return this;
    }

    public Displayable load(){
        Displayable give;
        if(choiceWheel){
            give = new ChoiceWheel(new ArrayList<>(choices));
        } else {
            give = new Sentence(timedDisplay, (new ArrayList<>(sentences)).toArray(new Text[]{}));
        }
        reset();
        return give;
    }

    private void reset(){
        sentences.clear();
        choices.clear();
        timedDisplay = choiceWheel = false;
    }
}
