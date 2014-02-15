package test;

import junit.framework.TestCase;
import model.Bark;
import model.BarkRecognizer;
import model.DogDoor;
import model.Remote;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void testDetectorDeLatidosPassandoLatidoNaoPermitido() {
        dogDoor.addAllowedBark(
                new Bark("Houf")
        );

        BarkRecognizer recognizer = new BarkRecognizer(dogDoor);

        recognizer.recognizer(new Bark("Au"));

        assertFalse(dogDoor.isOpen());
    }

    @Test
    public void testDetectorDeLatidosPassandoLatidoPermitido() {
        dogDoor.addAllowedBark(
                new Bark("Houf")
        );

        BarkRecognizer recognizer = new BarkRecognizer(dogDoor);

        recognizer.recognizer(new Bark("Houf"));

        assertTrue(dogDoor.isOpen());
    }

    @Test
    public void testeDetectorDeLatidosPassandoVariosLatidosDetectandoValidosEInvalidos() {
        List<Bark> list = new ArrayList<Bark>();

        list.add(new Bark("AuAu"));
        list.add(new Bark("Houf"));
        list.add(new Bark("Hip"));

        dogDoor.setAllowedBark(list);

        BarkRecognizer recognizer = new BarkRecognizer(dogDoor);

        recognizer.recognizer(new Bark("Houf"));

        assertTrue(
            dogDoor.isOpen()
        );

        dogDoor.close();

        recognizer.recognizer(new Bark("AuAu"));

        assertTrue(
                dogDoor.isOpen()
        );

        dogDoor.close();

        recognizer.recognizer(new Bark("Hip"));

        assertTrue(
                dogDoor.isOpen()
        );

        dogDoor.close();

        recognizer.recognizer(new Bark("Miau"));

        assertFalse(
                dogDoor.isOpen()
        );
    }
}