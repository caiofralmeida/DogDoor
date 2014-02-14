package model;

public class BarkRecognizer {

    protected DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognizer(Bark bark) {
        if (door.getAllowedBark().equals(bark)) {
            System.out.println("Detecting bark: " + bark);
            door.open();
        }
    }
}
