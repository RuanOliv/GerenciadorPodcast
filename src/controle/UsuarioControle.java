package controle;

import dao.DaoFactory;
import modelo.Usuario;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UsuarioControle {

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

}