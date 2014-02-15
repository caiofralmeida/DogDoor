package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {

    private boolean open;

    private List<Bark> allowedBarks;

    public DogDoor() {
        allowedBarks = new ArrayList<Bark>();
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

    public List<Bark> getAllowedBarks() {
        return allowedBarks;
    }

    public void addAllowedBark(Bark bark) {
        allowedBarks.add(bark);
    }

    public void setAllowedBark(List<Bark> list) {
        allowedBarks = list;
    }
}
