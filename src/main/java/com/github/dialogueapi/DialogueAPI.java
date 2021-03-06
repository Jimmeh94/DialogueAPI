package com.github.dialogueapi;

import com.github.dialogueapi.core.builders.DialogueBuilder;
import com.github.dialogueapi.events.InitializationEvents;
import com.github.dialogueapi.events.PlayerConnection;
import com.github.dialogueapi.managers.DialogueManager;
import com.github.dialogueapi.managers.PlayerManager;
import com.github.dialogueapi.runnables.CoreTimer;
import com.github.dialogueapi.utilities.Messager;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.scheduler.Task;

@Plugin(id = "dialogueapi", name = "DialogueAPI", version = "1.0.0")
public class DialogueAPI {

    private static DialogueAPI instance;

    @Inject
    private Logger logger;
    private DialogueManager dialogueManager;
    private Messager messager;
    private PlayerManager playerManager;
    private DialogueBuilder dialogueBuilder;

    @Listener
    public void onServerStart(GameInitializationEvent event){
        instance = this;

        dialogueManager = new DialogueManager();
        messager = new Messager();
        playerManager = new PlayerManager();
        dialogueBuilder = new DialogueBuilder();

        registerListeners();
        registerCommands();
        registerRunnables();
    }

    private void registerRunnables() {
        Task.Builder taskBuilder = Sponge.getScheduler().createTaskBuilder();

        taskBuilder.execute(new CoreTimer()).intervalTicks(20L).submit(this);
    }

    private void registerCommands() {

    }

    private void registerListeners() {
        EventManager eventManager = Sponge.getEventManager();

        eventManager.registerListeners(this, new PlayerConnection());
        eventManager.registerListeners(this, new InitializationEvents());
    }

    public static DialogueAPI getInstance() {
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }

    public DialogueManager getDialogueManager() {
        return dialogueManager;
    }

    public Messager getMessager() {
        return messager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public DialogueBuilder getDialogueBuilder() {
        return dialogueBuilder;
    }
}
