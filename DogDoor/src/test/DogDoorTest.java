package test;

import junit.framework.TestCase;
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
}
