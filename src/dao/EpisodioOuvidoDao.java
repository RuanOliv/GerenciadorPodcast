package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.App;
import modelo.EpPodcast;
import modelo.EpisodioOuvido;
import util.ConnectionFactory;

public class EpisodioOuvidoDao extends Dao {
	public EpisodioOuvido salvar(EpisodioOuvido e) {
		
        try {
            
            
            PreparedStatement stmt = this.con.prepareStatement("insert into episodiosouvidos (idUsuario, idEpisodio) values (?,?)");
            stmt.setInt(1, e.getIdUsuario());
            stmt.setInt(2, e.getIdEpisodio());

           
            stmt.executeUpdate();
            //ResultSet rs = stmt.getGeneratedKeys();
                

            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }  
	public List<EpPodcast> getEpisodiosOuvidos(){
        try {
                   List<EpPodcast> eppodcast = new ArrayList<>();
                    PreparedStatement stmt = this.con.prepareStatement("select eppodcast.id, eppodcast.titulo, eppodcast.genero, eppodcast.autor, eppodcast.tema, eppodcast.faixaetaria from episodiosouvidos inner join eppodcast on idEpisodio = eppodcast.id inner join usuario on idUsuario = usuario.id");
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        EpPodcast e = new EpPodcast();
                        
                        e.setId(rs.getInt("id"));
                        e.setTitulo(rs.getString("titulo"));
                        e.setGenero(rs.getString("genero"));
                        e.setAutor(rs.getString("autor"));
                        e.setTema(rs.getString("tema"));
                        e.setFaixaEtaria(rs.getString("faixaetaria"));



                        eppodcast.add(e);
                    }
                    rs.close();
                    stmt.close();
                    ConnectionFactory.closeConexao(this.con);
                    return eppodcast;

                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }

    }
}
