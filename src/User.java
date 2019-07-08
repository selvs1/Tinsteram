import javafx.scene.image.Image;

import java.io.Serializable;


public class User implements Serializable {
    private Image userPic;
    private String username;
    private String name;
    private String description;
    private String notes;
    private int priority;
    private int important;
    private Stopwatch timer;

    // Ich erstelle ein User. Immer wenn ich den User wechsle dann drücke ich vorher noch auf
    // startTimer (neuen User) und stopTimer (beim alten User)


    public User(String username, String name, String description, String notes, int priority, int important) {
        this.username = username;
        this.name = name;
        this.description = description;
        this.notes = description;
        this.priority = priority;
        this.important = important;
        System.out.println("done");
    }


    @Override
    public String toString() {
        String output = String.format("[username: %20s , name: %20s , description: %20s ]", username, name, description);
        return output;
    }
}
