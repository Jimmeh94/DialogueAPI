package com.github.dialogueapi.core.actions;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.DialogueAction;

public class DisplayDialogue extends DialogueAction {
    @Override
    public void doWork() {
        DialogueAPI.getInstance().getLogger().error("IT WORKS!!!");
    }
}
