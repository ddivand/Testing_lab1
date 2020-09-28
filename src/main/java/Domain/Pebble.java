package main.java.Domain;

public class Pebble {
    private Color color;
    private boolean isExpansive;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isExpansive() {
        return isExpansive;
    }

    public void setExpansive(boolean expansive) {
        isExpansive = expansive;
    }
}
