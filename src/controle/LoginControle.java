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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import modelo.Usuario;

public class LoginControle implements Initializable {
	private App application;

	public void setApp(App application) {
		this.application = application;
	}
	@FXML
    private AnchorPane AnchorPane;
	
    @FXML
    private Button btEntrar;

    @FXML
    private Label btTelaCadastro;

    @FXML
    private TextField txtEmail;
       
    @FXML
    void Entrar(ActionEvent event) {
    	String email = txtEmail.getText();
		buscarPorEmail(email);
    }

    @FXML
    void TelaCadastro(MouseEvent event) {
    	if (application == null) {
		} else {
			application.goToCadastrarUsuario();
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
