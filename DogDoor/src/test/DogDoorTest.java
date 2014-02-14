package test;

import junit.framework.TestCase;
import model.BarkRecognizer;
import model.DogDoor;
import model.Remote;
import org.junit.Before;
import org.junit.Test;

public class DogDoorTest extends TestCase {

    protected DogDoor dogDoor;
    protected Remote remote;

    @Before
    public void setUp() {
        dogDoor = new DogDoor();
        remote = new Remote(dogDoor);
    }

    @Test
    public void testPorta() {
        assertFalse(
                remote.getDogDoor().isOpen()
        );

        remote.pressButton();

        assertTrue(
                remote.getDogDoor().isOpen()
        );

        remote.pressButton();

        assertFalse(
                remote.getDogDoor().isOpen()
        );
    }

    @Test
    public void testPortaFechaAutomaticamente() {

        remote.pressButton();

        assertTrue(
                remote.getDogDoor().isOpen()
        );

        try {
            Thread.sleep(5001);
        } catch (Exception e) {

        }

        assertFalse(
                remote.getDogDoor().isOpen()
        );
    }

    @Test
    public void testDetectorDeLatidosAuAuAbrindoAPorta() {
        BarkRecognizer recognizer = new BarkRecognizer(dogDoor);

        recognizer.recognizer("Au Au");

        assertTrue(dogDoor.isOpen());
    }
}