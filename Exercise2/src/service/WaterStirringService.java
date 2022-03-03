package service;

import model.WaterStirring;

public class WaterStirringService {

    public WaterStirring fillWaterStirring(){
        int aux2 =  (int) (Math.random() * 6)+ 1;
        int aux1 =  (int) (Math.random() * 6)+ 1;
        return new WaterStirring(aux1, aux2);
    }

    public boolean wet(WaterStirring w){
        return w.getPosA() == w.getPosW();
    }

    public void nextWaterJet(WaterStirring waterS){
        int cont = waterS.getPosA();
        if(cont == 6){
            waterS.setPosA(1);
        }else{
            cont++;
            waterS.setPosA(cont);
        }
    }

    public void showWaterStirring(){
        WaterStirring w = fillWaterStirring();
        System.out.println(w);
    }

}
