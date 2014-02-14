package model;

public class Bark {

    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getAudio() {
        return sound;
    }

    public boolean equals(Bark bark) {

        if (bark.getAudio().equalsIgnoreCase(sound)) {
            return true;
        }

        return false;
    }
}
