package controle;

import dao.DaoFactory;
import modelo.Usuario;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UsuarioControle  implements Initializable {
	private App application;

	public void setApp(App application) {
		this.application = application;
	}

	@FXML
    private AnchorPane AnchorPane;

    @FXML
    private Button btNewUser;

    @FXML
    private PasswordField txtConSenha;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void cadastrarUsuario(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}