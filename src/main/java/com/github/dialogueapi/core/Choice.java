package com.github.dialogueapi.core;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.player.PlayerInfo;
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
import java.util.Optional;
import java.util.function.Consumer;

public class Choice implements Consumer<CommandSource>{

    /*
     * This is a clickable choice that is linked to an action
     */

    private List<DialogueAction> actions;
    private Text sentence;
    private Player player;
    private int id;

    public Choice(Text text, List<DialogueAction> action){
        this.sentence = text;
        this.actions = action;
    }

    public Choice(Choice choice, Player player){
        this.actions = choice.getAction();
        this.sentence = Text.of(choice.getSentence());
        this.player = player;
        setID();
    }

    private void setID(){
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

    @Override
    public void accept(CommandSource commandSource) {
        Optional<PlayerInfo> temp = DialogueAPI.getInstance().getPlayerManager().findPlayerInfo(this.player);
        if (temp.isPresent() && temp.get().getCurrentDialogue() != null && temp.get().getCurrentDialogue().hasChoiceID(this.id)) {
            DialogueAPI.getInstance().getDialogueManager().removeDialogue(this.player);
            for (DialogueAction action : this.actions)
                action.doWork();
        }

    }

    public int getId() {
        return id;
    }
}
