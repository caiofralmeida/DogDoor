package model;

public class BarkRecognizer {

    protected DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognizer(String bark) {
        System.out.println("Detecting back: " + bark);
        door.open();
    }
}
