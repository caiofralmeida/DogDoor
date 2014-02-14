package model;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

    private boolean open;

    private Bark allowedBark;

    public DogDoor() {
        this.open = false;
    }

    public void open() {
        this.open = true;
        startAutoClose();
    }

    protected void startAutoClose() {
        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel();
            }
        }, 5000);
    }

    public void close() {
        this.open = false;
    }

    public boolean isOpen() {
        return this.open;
    }

    public Bark getAllowedBark() {
        return allowedBark;
    }

    public void setAllowedBark(Bark bark) {
        allowedBark = bark;
    }
}
