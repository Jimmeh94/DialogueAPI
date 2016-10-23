package com.github.dialogueapi;

import com.google.inject.Inject;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;

import java.util.logging.Logger;

@Plugin(id = "dialogueapi", name = "DialogueAPI", version = "1.0.0")
public class DialogueAPI {

    private static DialogueAPI instance;

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameInitializationEvent event){
        instance = this;

        registerListeners();
        registerCommands();
        registerRunnables();
    }

    private void registerRunnables() {

    }

    private void registerCommands() {

    }

    private void registerListeners() {

    }

    public static DialogueAPI getInstance() {
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }
}
