package controle;



import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginControle {
	private App application;

	public void setApp(App application) {
		this.application = application;
	}
    @FXML
    private Button btEntrar;

    @FXML
    private Label btTelaCadastro;

    @FXML
    private TextField txtEmail;

    @FXML
    void Entrar(ActionEvent event) {
    	
    }

    @FXML
    void TelaCadastro(MouseEvent event) {
    	
    }
    

}
