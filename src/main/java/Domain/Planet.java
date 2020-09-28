package main.java.Domain;

import java.util.ArrayList;

public class Planet {

    private String name;
    private Sea sea;
    private LandscapeState state;
    private ArrayList<Character> chars;
    private Beach beach;
    private Sky sky;

    public Planet(String name){
        this.name = name;
        this.state = LandscapeState.light;
        this.chars = new ArrayList<>();
    }

    public void addCharacter(Character charo){
        chars.add(charo);
    }

    public ArrayList<Character> getCharacters(){
        return this.chars;
    }

    public void initSetting() {
        beach = new Beach();
        beach.setLandscapeState(LandscapeState.light);

        sea = new Sea();
        sea.setLandscapeState(LandscapeState.light);

        sky = new Sky("nothing");
        sky.setLandscapeState(LandscapeState.light);
    }

    public void changeLandscape() {
        beach.changeLandscape(Color.yellow);
        beach.setLandscapeState(LandscapeState.visible);
        sea.changeLandscape(Color.purple);
        sea.setLandscapeState(LandscapeState.visible);
        sky.changeLandscape(Color.mauve);
        sky.setLandscapeState(LandscapeState.visible);
        sky.setSkyText("Smth written");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Sea getSea(){return this.sea;}
    public Beach getBeach(){return this.beach;}
    public Sky getSky(){return this.sky;}
}
