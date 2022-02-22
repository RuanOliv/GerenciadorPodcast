package controle;

import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import modelo.EpPodcast;


public class InicialControle implements Initializable{
	private App application;

	public void setApp(App application) {
		this.application = application;
	}

	@FXML
    private Button btAdicionarOuvidos;

    @FXML
    private Button btOuvidos;

    @FXML
    private TableView<EpPodcast> tableView;

    @FXML
    private TableColumn<EpPodcast, String> tbcAutor;

    @FXML
    private TableColumn<EpPodcast, String> tbcFaixaEtaria;

    @FXML
    private TableColumn<EpPodcast, String> tbcGenero;

    @FXML
    private TableColumn<EpPodcast, String> tbcTema;

    @FXML
    private TableColumn<EpPodcast, String> tbcTitulo;
    
    @FXML
    private TextField txtPesquisar;

    @FXML
    void Pesquisar(KeyEvent event) {
    	if(txtPesquisar.getText() == "") {
    		tableView.setItems(FXCollections.observableArrayList(EpPodcast.episodios()));
    	}else {
    		tableView.setItems(FXCollections.observableArrayList(EpPodcast.buscarPorPesquisa(txtPesquisar.getText())));	   		
    	}
    	
    }

    @FXML
    void adicionarOuvidos(ActionEvent event) {
    	
    }

    @FXML
    void irOuvidos(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
		tbcTitulo.setCellValueFactory(new PropertyValueFactory<EpPodcast, String>("titulo"));
		tbcGenero.setCellValueFactory(new PropertyValueFactory<EpPodcast, String>("genero"));
		tbcAutor.setCellValueFactory(new PropertyValueFactory<EpPodcast, String>("autor"));
		tbcTema.setCellValueFactory(new PropertyValueFactory<EpPodcast, String>("tema"));
		tbcFaixaEtaria.setCellValueFactory(new PropertyValueFactory<EpPodcast, String>("faixaEtaria"));
		tableView.setItems(FXCollections.observableArrayList(EpPodcast.episodios()));		
		
	}

}
