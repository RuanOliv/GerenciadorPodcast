package controle;

import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import dao.DaoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import modelo.Usuario;

public class CadastroUsuarioControle implements Initializable {

	private App application;

	public void setApp(App application) {
		this.application = application;
	}

	@FXML
	private Label lbAlert;

	@FXML
	private Label lbAlertData;

	@FXML
	private AnchorPane AnchorPane;

	@FXML
	private Button btNewUser;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtNome;

	@FXML
	private PasswordField txtSenha;

	@FXML
	Usuario cadastrarUsuario(ActionEvent event) {
		lbAlert.setVisible(false);
		lbAlertData.setVisible(false);
		Usuario u = new Usuario();

		if (application == null) {
		} else {
			if (txtNome.getText() == "" || txtEmail.getText() == "" || txtSenha.getText() == "") {
				lbAlertData.setVisible(true);
			} else if (buscarPorEmail(txtEmail.getText()).getId() != null) {
				lbAlert.setVisible(true);

			} else {

				u.setNome(txtNome.getText());
				u.setEmail(txtEmail.getText());
				u.setSenha(txtSenha.getText());
				u.setAdministrador(false);
				u.setId(DaoFactory.getUsuarioDao().salvar(u));
				application.goToLogin();

			}
		}

		return u;

	}

	public static Usuario buscarPorEmail(String email) {

		return DaoFactory.getUsuarioDao().buscarPorEmail(email);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
