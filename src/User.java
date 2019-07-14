import javafx.scene.image.Image;
import javafx.scene.paint.Stop;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;


public class User implements Serializable, Observer {
    private Image userPic;
    private String username;
    private String name;
    private String description;
    private String notes;
    private int priority;
    private int important;
    private final Stopwatch ownTimer;


    // Ich erstelle ein User. Immer wenn ich den User wechsle dann drücke ich vorher noch auf
    // startTimer (neuen User) und stopTimer (beim alten User)


    public User(String username, String name, String description, String notes, int priority, int important, Image userPic) {
        this.username = username;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.priority = priority;
        this.important = important;
        this.userPic = userPic;
        System.out.println("done");
        ownTimer = new Stopwatch(10);
        ownTimer.addObserver(this);
    }

    public Image getUserPic() {
        return userPic;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    public int getPriority() {
        return priority;
    }

    public int getImportant() {
        return important;
    }

    public Stopwatch getOwnTimer() {
        return ownTimer;
    }

    @Override
    public String toString() {
        String output = String.format("[username: %20s , name: %20s , description: %20s ]", username, name, description);
        return output;
    }

    @Override
    public void update(Observable o, Object arg) {


    }
}