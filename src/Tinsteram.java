import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Tinsteram {

    private Image pic1;
    private String username;
    private String name;
    private String description;
    private String notes;
    private List<User> list;
    private PriorityQueue<User> pqList;
    private String DATA_FILE = ".userdata";

    public Tinsteram() {
        list = new ArrayList<>();
    }


    public void addUser(String username, String name, String description, String notes, int priority, int important) {
        list.add(new User(username, name, description, notes, priority, important));
        saveData();
    }

    public List<User> getData() {
        return list;
    }


    public void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            out.writeObject(list);
        } catch (IOException e) {
            System.out.println("Problem: " + e);
        }

    }

    public void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            list = (List<User>)in.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

    }


}