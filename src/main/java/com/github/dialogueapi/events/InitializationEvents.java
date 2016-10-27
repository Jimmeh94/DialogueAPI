package com.github.dialogueapi.events;

import com.github.dialogueapi.core.test.TestDialogue;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;

public class InitializationEvents {

    /*
     * Load dialogues here
     */

    @Listener
    public void serverStarting(GameStartedServerEvent event){
        new TestDialogue();
    }

}
