package test;

import junit.framework.TestCase;
import model.DogDoor;
import model.Remote;
import org.junit.Before;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

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
}