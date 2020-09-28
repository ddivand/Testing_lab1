package main.java.Domain;

import java.util.ArrayList;
import java.util.Random;

public class Beach {
    private Color color;
    private LandscapeState state;
    private ArrayList<Pebble> pebbles;

    public Beach() {
        this.pebbles = new ArrayList<Pebble>();

        double rand = Math.random() * 100;
        for (int i = 0;i < rand; i++) {
            Pebble peb = new Pebble();
            peb.setExpansive(Math.random()>0.5);
            this.pebbles.add(peb);
        }
    }

    public boolean isExpensive(){
        for (int i = 0; i < pebbles.size(); i++){
            if (pebbles.get(i).isExpansive())
                return true;
        }
        return false;
    }

    public void setLandscapeState(LandscapeState state){
        this.state = state;
    }

    public void changeLandscape(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public LandscapeState getLandscapeState() {
        return state;
    }
}
