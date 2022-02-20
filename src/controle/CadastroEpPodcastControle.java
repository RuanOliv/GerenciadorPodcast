package controle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import app.App;
import dao.DaoFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.EpPodcast;

public class CadastroEpPodcastControle implements Initializable{
	
	private App application;

	public void setApp(App application) {
		this.application = application;
	}
    @FXML
    private Button btNewEpisodio;

    @FXML
    private ComboBox<String> cbFaixaEtaria;

    @FXML
    private ComboBox<String> cbGenero;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtTema;

    @FXML
    private TextField txtTitulo;

    @FXML
    EpPodcast cadastrarEpisodio(ActionEvent event) {
    	if (application == null) {
    	} else {
    		application.goToInicial();
    	}
    	EpPodcast e = new EpPodcast();
        e.setTitulo(txtTitulo.getText());
        e.setGenero(cbGenero.getSelectionModel().getSelectedItem().toString());
        e.setAutor(txtAutor.getText());
        e.setTema(txtTema.getText());
        e.setFaixaEtaria(cbFaixaEtaria.getSelectionModel().getSelectedItem().toString());

        
        e.setId(DaoFactory.getEpPodcastDao().salvar(e));
        
        return e;
    }
    private List<String> generos = new ArrayList<String>();
    private ObservableList<String> obsGeneros;
    private List<String> faixasEtarias = new ArrayList<String>();
    private ObservableList<String> obsFaixaEtaria;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarGeneros();
		carregarFaixasEtarias();
				
	}
	
	public void carregarGeneros() {
		generos.add("Games");
		generos.add("Política");
		
		obsGeneros = FXCollections.observableArrayList(generos);
		cbGenero.setItems(obsGeneros);

	}
	public void carregarFaixasEtarias() {
		faixasEtarias.add("Livre");
		faixasEtarias.add("+16");
		
		obsFaixaEtaria = FXCollections.observableArrayList(faixasEtarias);
		cbFaixaEtaria.setItems(obsFaixaEtaria);

	}

}

