package com.github.dialogueapi.core;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.utilities.AltCodes;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Choice implements Consumer<CommandSource>{

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
        sentence = Text.builder().append(Text.of(TextColors.GOLD, TextStyles.BOLD, AltCodes.ARROW_RIGHT.getSign() + " "), sentence)
                .onClick(TextActions.executeCallback(this)).build();
    }

    public void display(Player player) {
        DialogueAPI.getInstance().getMessager().sendMessage(player, sentence);
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

    @Override
    public void accept(CommandSource commandSource) {
        for(DialogueAction action: actions){
            action.doWork();
        }
    }
}
