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
import javafx.scene.image.ImageView;

public class Controller {

    private Tinsteram model;
    private int defaultValue = 0;
    private IntegerProperty sliderValuePriority = new SimpleIntegerProperty(defaultValue);
    private IntegerProperty sliderValueImportant = new SimpleIntegerProperty(defaultValue);

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
    public void clickAdd(ActionEvent event) {
        model.addUser(tfUsername.getText(), tfName.getText(), tfDescription.getText(), taNotes1.getText(), (int)slidePriority.getValue(), (int)slideImportant.getValue());
        updateView();
    }

    @FXML
    void clickAddPic(ActionEvent event) {

    }

    @FXML
    void clickNext(ActionEvent event) {

    }

    @FXML
    void clickPrevious(ActionEvent event) {

    }

    @FXML
    public void init(Tinsteram model) {
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
}
