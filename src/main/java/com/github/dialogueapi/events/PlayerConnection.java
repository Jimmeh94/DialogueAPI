package com.github.dialogueapi.events;

import com.github.dialogueapi.DialogueAPI;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.event.network.ClientConnectionEvent;

public class PlayerConnection {

    @Listener
    public void onJoin(ClientConnectionEvent.Join event){
        event.setMessageCancelled(true);
        DialogueAPI.getInstance().getPlayerManager().registerPlayer(event.getTargetEntity());
        DialogueAPI.getInstance().getDialogueManager().giveDialogue(event.getTargetEntity(), "test");
        DialogueAPI.getInstance().getPlayerManager().findPlayerInfo(event.getTargetEntity()).get().startDialogue();
    }

    @Listener
    public void onLeave(ClientConnectionEvent.Disconnect event){
        event.setMessageCancelled(true);
        DialogueAPI.getInstance().getPlayerManager().unregister(event.getTargetEntity());
    }

}
