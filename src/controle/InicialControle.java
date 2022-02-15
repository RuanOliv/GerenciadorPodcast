package controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import app.App;

public class InicialControle implements Initializable{
	private App application;

	public void setApp(App application) {
		this.application = application;
	}
    @FXML
    private TextField txtPesquisar;

    @FXML
    void Pesquisar(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
