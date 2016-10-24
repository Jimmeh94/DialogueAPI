package com.github.dialogueapi.core.player;

import com.github.dialogueapi.core.containers.Dialogue;

import java.util.UUID;

public class PlayerInfo {

    private UUID uuid;
    private Dialogue currentDialogue;

    public PlayerInfo(UUID uuid){
        this.uuid = uuid;
    }

    public void setCurrentDialogue(Dialogue currentDialogue) {
        this.currentDialogue = currentDialogue;
    }

    public Dialogue getCurrentDialogue() {
        return currentDialogue;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void resetDialogue() {
        currentDialogue = null;
    }

    public void startDialogue() {
        currentDialogue.displayNext();
    }
}
