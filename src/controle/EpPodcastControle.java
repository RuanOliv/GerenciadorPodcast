package controle;

import dao.DaoFactory;
import modelo.EpPodcast;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class EpPodcastControle {

    @FXML
    private Button btNewEpisodio;

    @FXML
    private ComboBox<?> cbFaixaEtaria;

    @FXML
    private ComboBox<?> cbGenero;

    @FXML
    private PasswordField txtAutor;

    @FXML
    private PasswordField txtTema;

    @FXML
    private TextField txtTitulo;

    @FXML
    void cadastrarEpisodio(ActionEvent event) {

    }

}
