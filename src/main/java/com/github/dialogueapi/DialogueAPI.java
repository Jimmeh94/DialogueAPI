package com.github.dialogueapi;

import com.github.dialogueapi.runnables.CoreTimer;
import com.google.inject.Inject;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.scheduler.Task;

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
        Task.Builder taskBuilder = Sponge.getScheduler().createTaskBuilder();

        taskBuilder.execute(new CoreTimer()).intervalTicks(20L).submit(this);
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
