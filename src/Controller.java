import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Stop;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {


    private Tinsteram model;
    private int defaultValue = 0;
    private Image img;
    private IntegerProperty sliderValuePriority = new SimpleIntegerProperty(defaultValue);
    private IntegerProperty sliderValueImportant = new SimpleIntegerProperty(defaultValue);
    private Stopwatch mainTimer;

    @FXML
    private ImageView img1;

    @FXML
    private Button btnAddPic;

    @FXML
    private TextArea taNotes1;

    @FXML
    private TextField tfPath;

    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfDescription;

    @FXML
    private Button btnAdd;

    @FXML
    private Slider slidePriority;

    @FXML
    private Slider slideImportant;

    @FXML
    private TextField tfPriority;

    @FXML
    private TextField tfImportant;

    @FXML
    private ImageView img2;

    @FXML
    private TextArea taNotes2;

    @FXML
    private Button btnPrevious;

    @FXML
    private Button btnNext;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblName;

    @FXML
    private Label lblStatus;

    @FXML
    private Label lblCurrentPic;

    @FXML
    private RadioButton rdDE;

    @FXML
    private RadioButton rdEN;

    @FXML
    private RadioButton rdFR;

    @FXML
    private ListView<User> listView;

    @FXML
    private Label lblRunningTime;



    @FXML
    public void clickAdd(ActionEvent event) {
        model.addUser(tfUsername.getText(), tfName.getText(), tfDescription.getText(), taNotes1.getText(), (int) slidePriority.getValue(), (int) slideImportant.getValue(), img);
        updateView();
    }

    @FXML
    void clickAddPic(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Bild auswählen");
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            System.out.println(file);
            img = new Image(file.toURI().toString());
            img1.setImage(img);
        }
    }

    @FXML
    void clickNext(ActionEvent event) {

    }

    @FXML
    void clickPrevious(ActionEvent event) {

    }

    @FXML
    public void init(Tinsteram model) {
        mainTimer = new Stopwatch(10);
        mainTimer.addObserver(this);
        mainTimer.start();
        this.model = model;
        this.model.loadData();
        updateView();
    }

    @FXML
    protected void initialize() {
        slidePriority.valueProperty().bindBidirectional(sliderValuePriority);
        tfPriority.textProperty().bind(sliderValuePriority.asString());

        slideImportant.valueProperty().bindBidirectional(sliderValueImportant);
        tfImportant.textProperty().bind(sliderValueImportant.asString());
    }

    private void updateView() {
        listView.getItems().clear();
        listView.getItems().addAll(this.model.getData());
        resetView();
    }

    private void resetView() {
        tfUsername.clear();
        tfName.clear();
        tfDescription.clear();
        taNotes1.clear();
        slidePriority.setValue(0);
        slideImportant.setValue(0);
    }

    private void updateView_View() {
        User chosenUser = (User)model.list.get(0);
        lblDate.setText("####");
        lblUsername.setText(chosenUser.getUsername());
        lblName.setText(chosenUser.getName());
        lblStatus.setText(String.format("%f%", chosenUser.getOwnTimer().getTime()));
    }



    @Override
    public void update(Observable o, Object arg) {
//        this.model.mainTimer.getSeconds();
        Platform.runLater(() -> {
            lblRunningTime.setText(String.format("%02d:%02d:%02d", (mainTimer.getSeconds()/3600)%60, mainTimer.getSeconds()%60, (int)(mainTimer.getTime()*100)%100));
        });

    }
}
