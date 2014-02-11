package model;

import java.util.Timer;
import java.util.TimerTask;

public class Remote {

    private DogDoor door;

    public Remote(DogDoor door) {
        this.door = door;
    }

    public void pressButton() {
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();
            startAutoClose();
        }
    }

    protected void startAutoClose() {
        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                door.close();
                timer.cancel();
            }
        }, 5000);
    }

    public DogDoor getDogDoor() {
        return door;
    }
}
