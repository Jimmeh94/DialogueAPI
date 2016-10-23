package com.github.dialogueapi.core.builders;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.Displayable;
import com.github.dialogueapi.core.containers.Dialogue;

import java.util.ArrayList;
import java.util.List;

public class DialogueBuilder {

    private List<Displayable> dialogue = new ArrayList<>();
    private DisplayableBuilder displayableBuilder = new DisplayableBuilder();
    private int intID = -1, autoIntID = 0;
    private String stringID = null;

    public DialogueBuilder intID(int id){intID = id; return this;}
    public DialogueBuilder stringID(String stringID){this.stringID = stringID; return this;}

    public DialogueBuilder loadDialogue(){
        dialogue.add(displayableBuilder.load());
        return this;
    }

    public DisplayableBuilder displayableBuilder(){
        return displayableBuilder;
    }

    public DialogueBuilder build(){
        Dialogue give;
        if(intID == -1)
            give = new Dialogue(new ArrayList<>(dialogue), stringID, autoIntID++);
        else give = new Dialogue(new ArrayList<>(dialogue), stringID, intID++);
        DialogueAPI.getInstance().getDialogueManager().addDialogue(give);
        reset();
        return this;
    }

    private void reset(){
        dialogue.clear();
        intID = -1;
        stringID = null;
    }
}
