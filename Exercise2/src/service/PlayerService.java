package service;

import model.Player;
import model.WaterStirring;

import java.util.ArrayList;

public class PlayerService {

    ArrayList<Player> players = new ArrayList<>();


    public void addPlayer(int id){
        Player p = new Player(id,("Player " + id), false);
        players.add(p);
    }

    public ArrayList<Player> loadPlayers(int cont){
        players.clear();
        for (int i = 0; i < cont; i++) {
            addPlayer(i+1);
        }
        return players;
    }

    public void showPlayers(){
        if(!players.isEmpty()){
            for (Player p : players) {
                System.out.println(p);
            }
        }else{
            System.out.println("No players registered");
        }
    }


    public boolean shot(WaterStirringService wS, WaterStirring r, Player p){
        if(wS.wet(r)){
            p.setbWet(true);
            return true;
        }else{
            wS.nextWaterJet(r);
        }
        return false;
    }

}
