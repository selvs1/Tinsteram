import javafx.scene.image.Image;

import java.io.*;
import java.util.*;

public class Tinsteram implements Observer{

    private Image pic1;
    private String dbPath;
    private String username;
    private String name;
    private String description;
    private String notes;
    public ArrayList<User> list;
    private PriorityQueue<User> pqList;
    private String DATA_FILE = ".userdata";

    public Tinsteram() {
        list = new ArrayList<>();
    }


    public void addUser(String username, String name, String description, String notes, int priority, int important, Image userPic) {
        list.add(new User(username, name, description, notes, priority, important, userPic));
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
            list = (ArrayList<User>)in.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void newDataBase() {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
