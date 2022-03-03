package service;

import model.Player;
import model.WaterStirring;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Game {
    ArrayList<Player> players = null;
    WaterStirring w = null;
    WaterStirringService wS = new WaterStirringService();
    PlayerService pS = new PlayerService();

    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);


    public void fillGame(int cont){
        w = wS.fillWaterStirring();
        players = pS.loadPlayers(cont);
    }

    public void requestPlayers(){
        System.out.println("Enter a number of players: ");
        int count = input.nextInt();

        if(count < 1 || count > 6 ){
            fillGame(6);
        }else {
            fillGame(count);
        }
    }

    public void round(int r){
        boolean band = false;
        do{
            System.out.printf("Round n° %d:\n",r);
            pS.showPlayers();
            for (Player p : players){
                if(pS.shot(wS,w,p)){
                    System.out.println("LOSER:");
                    System.out.println("---------------------------");
                    System.out.println(p);
                    System.out.println("---------------------------");
                    band = true;
                    break;
                }
            }
        }while(!band);
        System.out.println("Game over");
    }

    public void startGame(){
        int r = 1;
        int op;
        do{
            requestPlayers();
            round(r++);
            System.out.println("Would you like to start another game: 1)YES, 2)NO");
            op = input.nextInt();
        }while(op != 2);
    }
}
