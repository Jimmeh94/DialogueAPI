package com.github.dialogueapi.core.actions;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.DialogueAction;
import com.github.dialogueapi.core.player.PlayerInfo;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Optional;

public class DisplayDialogue extends DialogueAction {

    private String id;

    public DisplayDialogue(String id){
        this.id = id;
    }

    @Override
    public void doWork(Player player) {
        Optional<PlayerInfo> temp = DialogueAPI.getInstance().getPlayerManager().findPlayerInfo(player);
        if(temp.isPresent()){
            DialogueAPI.getInstance().getDialogueManager().giveDialogue(player, id);
            temp.get().startDialogue();
        }
    }
}
