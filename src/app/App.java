package app;

import controle.UsuarioControle;
import modelo.Usuario;
import modelo.EpPodcast;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {
	private Stage stage;

    public static void main(String[] args) {
       	Application.launch(App.class, (java.lang.String[]) null);
    }

    @Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stage = primaryStage;
			stage.setTitle("Tela principal");
			goToInicial();
			primaryStage.show();
		} catch (Exception ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    
    public void goToInicial() {
		try {
			UsuarioControle pController = (UsuarioControle) replaceSceneContent("Inicial.fxml");
			pController.setApp(this);

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
		Scene scene = new Scene(page, 800, 600);
		stage.setScene(scene);
		stage.sizeToScene();
		return (Initializable) loader.getController();
	}


}