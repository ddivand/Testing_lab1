package main.java.Domain;

public class Sea {
    private Color color;
    private LandscapeState state;

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
