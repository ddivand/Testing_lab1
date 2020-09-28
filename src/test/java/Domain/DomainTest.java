package test.java.Domain;

import main.java.Domain.*;
import main.java.Domain.Character;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DomainTest {

    public Planet planet;

    @Before
    public void prepare() {
        planet = new Planet("Magrateia");
    }

    @Test
    public void initState() {
        planet.initSetting();
        assertEquals("incorrect sky",LandscapeState.light, planet.getSky().getLandscapeState());
        assertEquals("incorrect sea",LandscapeState.light, planet.getSea().getLandscapeState());
        assertEquals("incorrect beach",LandscapeState.light, planet.getBeach().getLandscapeState());
    }

    @Test
    public void changedState(){
        planet.initSetting();
        planet.changeLandscape();
        assertEquals("incorrect sky",LandscapeState.visible, planet.getSky().getLandscapeState());
        assertEquals("incorrect sea",LandscapeState.visible, planet.getSea().getLandscapeState());
        assertEquals("incorrect beach",LandscapeState.visible, planet.getBeach().getLandscapeState());

        assertEquals("incorrect sky",Color.mauve, planet.getSky().getColor());
        assertEquals("incorrect sea",Color.purple, planet.getSea().getColor());
        assertEquals("incorrect beach",Color.yellow, planet.getBeach().getColor());
    }

    @Test
    public void skyTextChanged(){
        planet.initSetting();
        planet.changeLandscape();
        assertEquals("incorrect text","Smth written",planet.getSky().getSkyText());
    }

    @Test
    public void humansSpeak(){
        planet.initSetting();

        planet.addCharacter(new Character("Zafod"));

        String action = planet.getCharacters().get(0).action(CharacterState.speak);
        assertEquals("human not speaking", "say smth", action);
    }

    @Test
    public void humansSit(){
        planet.initSetting();
        planet.addCharacter(new Character("Zafod"));

        String action = planet.getCharacters().get(0).action(CharacterState.sit);
    }

    @Test
    public void expensiveStones(){
        planet.initSetting();
        assertTrue("not expensive :(",planet.getBeach().isExpensive());

    }
// камушки

    @Test
    public void lookAtSky(){
        planet.initSetting();
        planet.addCharacter(new Character("Zafod"));

        String sky = planet.getCharacters().get(0).lookAtSky(planet.getSky());
        assertEquals("incorrect sky","nothing",sky);
    }
}
