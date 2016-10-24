package com.github.dialogueapi.core.test;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.actions.DisplayDialogue;
import com.github.dialogueapi.core.builders.DialogueBuilder;
import com.github.dialogueapi.core.builders.DisplayableBuilder;
import org.spongepowered.api.text.Text;

public class TestDialogue {

    public TestDialogue(){
        DialogueBuilder dialogueBuilder = DialogueAPI.getInstance().getDialogueBuilder();
        DisplayableBuilder displayableBuilder = dialogueBuilder.displayableBuilder();

        dialogueBuilder.stringID("test")
                .loadDialogue(displayableBuilder
                        .setChoiceWheel(false)
                        .setTimedDisplay(false)
                        .addSentence(Text.of("test sentence")))
                .loadDialogue(displayableBuilder
                        .setChoiceWheel(true)
                        .addChoice(Text.of("test choice"), new DisplayDialogue()))
                .build();
    }

}
