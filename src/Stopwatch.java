import java.util.Observable;
import java.util.Timer;

public class Stopwatch extends Observable implements Runnable{
    private int ticks;
    private int interval;

    private Thread thread;


    public Stopwatch(int interval) {
        this.interval = interval;
    }

    public final double getTime() {
        return ticks * interval / 1000.0;
    }

    public int getSeconds() {
        return (int) this.getTime() % 60;
    }

    public final boolean isRunning() {
        return thread != null;
    }

    public final void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.setDaemon(true);
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
            this.setChanged();
            this.notifyObservers();
        }
    }

    public final void stop() {
        if (thread != null) {
            thread = null;
        }

        this.setChanged();
        this.notifyObservers();
    }

    public final void reset() {
        ticks = 0;
        this.setChanged();
        this.notifyObservers();
    }

    public final void run() {
        while (thread != null) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                //mach nichts
            }
            if (thread != null) {
                ticks++;
                this.setChanged();
                this.notifyObservers();
            }
        }
    }

}
