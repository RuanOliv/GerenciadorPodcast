package app;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import controle.CadastroEpPodcastControle;
import controle.CadastroUsuarioControle;
import controle.EpisodiosOuvidosControle;
import controle.InicialAdmControle;
import controle.InicialControle;
import controle.ListarEpisodiosControle;
import controle.ListarUsuariosControle;
import controle.LoginControle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Usuario;

public class App extends Application {
	private Stage stage;
	public Usuario usuario;
	
    public static void main(String[] args) {
       	Application.launch(App.class, (java.lang.String[]) null);
    }

    @Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stage = primaryStage;
			stage.setTitle("Gerenciador de Podcast");
			goToLogin();
			
			primaryStage.show();
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    public void goToLogin() {
		try {
			usuario = new Usuario();
			LoginControle lController = (LoginControle) replaceSceneContent("../visao/telaLogin.fxml");
			lController.setApp(this);
			
			
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    public void goToInicial(){
		try {
			usuario = new Usuario();
			InicialControle iController = (InicialControle) replaceSceneContent("../visao/telaInicial.fxml");
			iController.setApp(this);
			
			
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    
    public void goToCadastrarUsuario() {
		try {
			CadastroUsuarioControle cController = (CadastroUsuarioControle) replaceSceneContent("../visao/telaCadastroUsuario.fxml");
			cController.setApp(this);

		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    public void goToCadastrarEpisodio() {
		try {
			CadastroEpPodcastControle cController = (CadastroEpPodcastControle) replaceSceneContent("../visao/telaCadastroEpisodio.fxml");
			cController.setApp(this);

		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    public void goToListEpisodio() {
		try {
			ListarEpisodiosControle cController = (ListarEpisodiosControle) replaceSceneContent("../visao/telaListarEpisodios.fxml");
			cController.setApp(this);

		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    public void goToListUsuario() {
		try {
			ListarUsuariosControle cController = (ListarUsuariosControle) replaceSceneContent("../visao/telaListarUsuarios.fxml");
			cController.setApp(this);

		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    public void goToInicialAdm() {
		try {
			InicialAdmControle cController = (InicialAdmControle) replaceSceneContent("../visao/telaInicialAdm.fxml");
			cController.setApp(this);

		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    public void goToEpisodiosOuvidos() {
		try {
			usuario = new Usuario();
			EpisodiosOuvidosControle cController = (EpisodiosOuvidosControle) replaceSceneContent("../visao/telaEpisodiosOuvidos.fxml");
			cController.setApp(this);

		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


    
    private Initializable replaceSceneContent(String fxml) throws Exception {
    	
    	
    	   
		FXMLLoader loader = new FXMLLoader();
		InputStream in = App.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(App.class.getResource(fxml));
		
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page, 690, 421);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setResizable(false);
		return (Initializable) loader.getController();
		
	}


}