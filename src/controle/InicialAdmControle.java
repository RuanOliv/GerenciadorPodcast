package controle;


import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

	public class InicialAdmControle implements Initializable {
		
		private App application;

		public void setApp(App application) {
			this.application = application;
		}
		
	    @FXML
	    private Button btCadEpisodios;

	    @FXML
	    private Button btVoltar;

	    @FXML
	    private Button btListEpisodios;

	    @FXML
	    private Button btListUsuarios;

	    @FXML
	    void cadEpisodios(ActionEvent event) {
	    	if (application == null) {
			} else {
				application.goToCadastrarEpisodio();
			}
	    }

	    @FXML
	    void listEpisodios(ActionEvent event) {
	    	if (application == null) {
			} else {
				application.goToListEpisodio();
			}
	    }

	    @FXML
	    void listUsuarios(ActionEvent event) {
	    	if (application == null) {
			} else {
				application.goToListUsuario();
			}
	    }
	    
	    @FXML
	    void voltarTela(ActionEvent event) {
	    	if(application == null) {
	    		
	    	}else {
	    		application.goToInicial();
	    	}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}

	}
