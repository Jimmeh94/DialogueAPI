package com.github.dialogueapi.managers;

import com.github.dialogueapi.DialogueAPI;
import com.github.dialogueapi.core.containers.Dialogue;
import com.github.dialogueapi.core.player.PlayerInfo;
import org.spongepowered.api.entity.living.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class DialogueManager {

    private List<Dialogue> dialogues = new ArrayList<>();

    public int getChoiceID(){
        Random random = new Random();
        int id = random.nextInt();
        while(isChoiceIDTaken(id)){
            id = random.nextInt();
        }
        return id;
    }

    private boolean isChoiceIDTaken(int id){
        for(PlayerInfo playerInfo: DialogueAPI.getInstance().getPlayerManager().getPlayers()){
            if(playerInfo.getCurrentDialogue() != null && playerInfo.getCurrentDialogue().hasChoiceID(id))
                return true;
        }
        return false;
    }

    public void giveDialogue(Player player, int dialogueID){
        for(Dialogue dialogue: dialogues){
            if(dialogue.getDialogueID().getValue() == dialogueID){
                Optional<PlayerInfo> temp = DialogueAPI.getInstance().getPlayerManager().findPlayerInfo(player);
                if(temp.isPresent()){
                    temp.get().setCurrentDialogue(new Dialogue(player, dialogue));
                }
            }
        }
    }

    public void giveDialogue(Player player, String dialogueID){
        for(Dialogue dialogue: dialogues){
            if(dialogue.getDialogueID().getKey().equalsIgnoreCase(dialogueID)){
                Optional<PlayerInfo> temp = DialogueAPI.getInstance().getPlayerManager().findPlayerInfo(player);
                if(temp.isPresent()){
                    temp.get().setCurrentDialogue(new Dialogue(player, dialogue));
                }
            }
        }
    }

    public void removeDialogue(Player player) {
        Optional<PlayerInfo> temp = DialogueAPI.getInstance().getPlayerManager().findPlayerInfo(player);
        if(temp.isPresent()){
            temp.get().resetDialogue();
        }
    }

    public void addDialogue(Dialogue give) {
        dialogues.add(give);
    }
}
