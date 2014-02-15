package model;

public class BarkRecognizer {

    protected DogDoor door;

    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }

    public void recognizer(Bark bark) {

        for(Bark barkAllowed : door.getAllowedBarks()) {
            if(barkAllowed.equals(bark)) {
                System.out.println("Detecting bark: " + bark.getAudio());
                door.open();
                return;
            }
        }

    }
}
