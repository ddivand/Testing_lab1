package main.java.Domain;

public class Sky {
    private Color color;
    private LandscapeState state;
    private String skyText;

    public Sky(String text){
        this.skyText = text;
    }

    public void setLandscapeState(LandscapeState state){
        this.state = state;
    }

    public void changeLandscape(Color color){
        this.color = color;
    }

    public LandscapeState getLandscapeState(){
        return this.state;
    }

    public Color getColor(){
        return this.color;
    }

    public String getSkyText() {
        return skyText;
    }

    public void setSkyText(String skyText) {
        this.skyText = skyText;
    }
}
