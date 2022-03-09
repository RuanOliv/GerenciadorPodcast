package controle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.App;
import dao.DaoFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import modelo.EpPodcast;
import modelo.EpisodioOuvido;
import modelo.Usuario;

public class InicialControle implements Initializable {
	private App application;

	public void setApp(App application) {
		this.application = application;
	}

	@FXML
	private AnchorPane AnchorPane;
	
	@FXML
    private Label lbAlert;
	
	@FXML
	private Button btAdicionarOuvidos;

	@FXML
	private Button btAdministrador;

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
		if (txtPesquisar.getText() == "") {
			tableView.setItems(FXCollections.observableArrayList(EpPodcast.episodios()));
		} else {
			tableView.setItems(FXCollections.observableArrayList(EpPodcast.buscarPorPesquisa(txtPesquisar.getText())));
		}

	}

	@FXML
	void irAdministrador(ActionEvent event) {
		if (application == null) {

		} else {
			application.goToInicialAdm();
		}
	}

	@FXML
	void adicionarOuvidos(ActionEvent event) {
		System.out.println();
		
		if (EpisodioOuvido.buscarPorId(tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex()).getId(), application.usuario.getId()).getIdEpisodio() != null ) {

			lbAlert.setVisible(true);
			
			
		} else {
			lbAlert.setVisible(false);
			EpisodioOuvido e = new EpisodioOuvido();
			e.setIdEpisodio(tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex()).getId());
			e.setIdUsuario(application.usuario.getId());
			EpisodioOuvido.salvar(e);
		}
	}



	@FXML
	void irOuvidos(ActionEvent event) {
		if (application == null) {

		} else {
			application.goToEpisodiosOuvidos();
		}
	}

	@FXML
	void test(MouseEvent event) {

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

	public static Usuario buscarPorEmail(String email) {

		return DaoFactory.getUsuarioDao().buscarPorEmail(email);

	}

	public void isAdm() {
		if (application == null) {

		} else {
			if (application.usuario.getAdministrador() != true) {

			} else {
				btAdministrador.setVisible(true);
			}
		}
	}

}
