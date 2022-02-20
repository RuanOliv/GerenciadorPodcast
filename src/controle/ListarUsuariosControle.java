package controle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.App;
import dao.DaoFactory;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import modelo.Usuario;

public class ListarUsuariosControle implements Initializable {
	private App application;

	public void setApp(App application) {
		this.application = application;
	}
	
	@FXML
    private Button btDeletarUsuario;
	
	@FXML
    private TableView<Usuario> tableView;

    @FXML
    private TableColumn<Usuario, Boolean> tbcAdministrador;

    @FXML
    private TableColumn<Usuario, String> tbcEmail;

    @FXML
    private TableColumn<Usuario, Integer> tbcId;

    @FXML
    private TableColumn<Usuario, String> tbcNome;

    @FXML
    private TableColumn<Usuario, String> tbcSenha;
    
    @FXML
    void deletarUsuario(ActionEvent event) {
    	Usuario.delete(tableView.getItems().remove(tableView.getSelectionModel().getSelectedIndex()).getId());
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tbcId.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("id"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
		tbcEmail.setCellValueFactory(new PropertyValueFactory<Usuario, String>("email"));
		tbcSenha.setCellValueFactory(new PropertyValueFactory<Usuario, String>("senha"));
		tbcAdministrador.setCellValueFactory(new PropertyValueFactory<Usuario, Boolean>("administrador"));
		tableView.setItems(FXCollections.observableArrayList(Usuario.usuarios()));
		
	}
	
}
