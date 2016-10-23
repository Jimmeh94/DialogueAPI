package com.github.dialogueapi.managers;

import com.github.dialogueapi.core.player.PlayerInfo;
import org.spongepowered.api.entity.living.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerManager {

    private List<PlayerInfo> players = new ArrayList<>();

    public void registerPlayer(Player player){
        if(!isRegistered(player)){
            players.add(new PlayerInfo(player.getUniqueId()));
        }
    }

    public boolean isRegistered(Player player){
        for(PlayerInfo playerInfo: players){
            if(playerInfo.getUuid().equals(player.getUniqueId()))
                return true;
        }
        return false;
    }

    public Optional<PlayerInfo> findPlayerInfo(Player player){
        Optional<PlayerInfo> give = Optional.empty();
        for(PlayerInfo playerInfo: players){
            if(playerInfo.getUuid().equals(player.getUniqueId()))
                give = give.of(playerInfo);
        }
        return give;
    }

    public List<PlayerInfo> getPlayers() {
        return players;
    }
}
