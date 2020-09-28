package main.java.Domain;

public class Character {
    private String name;
    private CharacterState currentState;

    public Character(String name){
        this.name = name;
    }
    public String action(CharacterState state){
        this.currentState = state;

        if (state == CharacterState.speak)
            return "say smth";

        if (state == CharacterState.sit)
            this.currentState = CharacterState.thinking;

        return "";
    }

    public String lookAtSky(Sky sky){
        return sky.getSkyText();
    }

    public CharacterState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(CharacterState currentState) {
        this.currentState = currentState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
