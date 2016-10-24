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
                        .addSentence(Text.of("Will you help me?")))
                .loadDialogue(displayableBuilder
                        .setChoiceWheel(true)
                        .addChoice(Text.of("Yes I will"), new DisplayDialogue("testYes"))
                        .addChoice(Text.of("No I won't"), new DisplayDialogue("testNo"))
                        .addChoice(Text.of("With what?"), new DisplayDialogue("testWith")))
                .build();

        dialogueBuilder.stringID("testYes")
                .loadDialogue(displayableBuilder
                        .setChoiceWheel(false)
                        .setTimedDisplay(false)
                        .addSentence(Text.of("Oh thank you!")))
                .build();

        dialogueBuilder.stringID("testNo")
                .loadDialogue(displayableBuilder
                        .setChoiceWheel(false)
                        .setTimedDisplay(false)
                        .addSentence(Text.of("Well up yours buddy!")))
                .build();

        dialogueBuilder.stringID("testWith")
                .loadDialogue(displayableBuilder
                        .setChoiceWheel(false)
                        .setTimedDisplay(false)
                        .addSentence(Text.of("I lost some candy in my van... ;)")))
                .loadDialogue(displayableBuilder
                        .setChoiceWheel(true)
                        .addChoice(Text.of("Sure, I loooooove candy"), new DisplayDialogue("testYes"))
                        .addChoice(Text.of("Stranger danger!"), new DisplayDialogue("testNo")))
                .build();
    }

}
