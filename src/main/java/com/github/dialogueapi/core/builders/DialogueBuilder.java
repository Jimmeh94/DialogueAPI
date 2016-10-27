package com.github.dialogueapi.core.builders;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.Displayable;
import com.github.dialogueapi.core.containers.Dialogue;

import java.util.ArrayList;
import java.util.List;

public class DialogueBuilder {

    /*
     * Use to build a Dialogue
     * Must have a StringID
     * Use the DisplayableBuilder to build sentences and choices, then loadDialogue
     */

    private List<Displayable> dialogue = new ArrayList<>();
    private DisplayableBuilder displayableBuilder = new DisplayableBuilder();
    private String stringID = null;

    public DialogueBuilder stringID(String stringID){this.stringID = stringID; return this;}

    public DialogueBuilder loadDialogue(DisplayableBuilder displayableBuilder){
        dialogue.add(displayableBuilder.load());
        return this;
    }

    public DisplayableBuilder displayableBuilder(){
        return displayableBuilder;
    }

    public DialogueBuilder build(){
        Dialogue give = new Dialogue(new ArrayList<>(dialogue), stringID);
        DialogueAPI.getInstance().getDialogueManager().addDialogue(give);
        reset();
        return this;
    }

    private void reset(){
        dialogue.clear();
        stringID = null;
    }
}
