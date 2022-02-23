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
    Usuario cadastrarUsuario(ActionEvent event) {
    	Usuario u = new Usuario();
    	if(buscarPorEmail(txtEmail.getText()).getId() != null) {
    		lbAlert.setVisible(true);
    		return u;
    	
    	}else {
    		
    		if(txtSenha.getText() != txtConSenha.getText()) {
    		}
    		if (application == null) {
    		} else {
    			application.goToLogin();
    		}
    		
    		u.setNome(txtNome.getText());
    		u.setEmail(txtEmail.getText());
    		u.setSenha(txtSenha.getText());
    		u.setAdministrador(false);
    		u.setId(DaoFactory.getUsuarioDao().salvar(u));
    		return u;
    	}
    	
        
    }
    
    public static Usuario buscarPorEmail(String email){
        
        return DaoFactory.getUsuarioDao().buscarPorEmail(email);
        
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
