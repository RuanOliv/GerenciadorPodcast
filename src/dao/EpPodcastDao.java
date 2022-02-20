
package dao;

import app.App;
import modelo.EpPodcast;
import util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EpPodcastDao extends Dao {
    
    
    public Boolean atualizar(EpPodcast e) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("update eppodcast set titulo=?,genero=?,autor=?,tema=?,faixaetaria=? where id=?");
            stmt.setString(1, e.getTitulo());
            stmt.setString(2, e.getGenero());
            stmt.setString(3, e.getAutor());
            stmt.setString(4, e.getTema());
            stmt.setString(5, e.getFaixaEtaria());
            stmt.setInt(6, e.getId());
            stmt.executeUpdate();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Integer salvar(EpPodcast e) {
        Integer last_inserted_id = null;
        try {
            
            
            PreparedStatement stmt = this.con.prepareStatement("insert into eppodcast(titulo,genero,autor,tema,faixaetaria) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, e.getTitulo());
            stmt.setString(2, e.getGenero());
            stmt.setString(3, e.getAutor());
            stmt.setString(4, e.getTema());
            stmt.setString(5, e.getFaixaEtaria());


           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                {
                    last_inserted_id = rs.getInt(1);
                }

            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_inserted_id;
    }  
     public Boolean delete(Integer id) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("delete from eppodcast where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public List<EpPodcast> getEpPodcast(){
        try {
                   List<EpPodcast> eppodcast = new ArrayList<>();
                    PreparedStatement stmt = this.con.prepareStatement("select id, titulo, genero, autor, tema, faixaetaria from eppodcast");
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
    public EpPodcast buscarPorId(Integer id) {
        try {
            EpPodcast e = new EpPodcast();
            

            PreparedStatement stmt = this.con.prepareStatement("select id, titulo, genero, autor, tema, faixaetaria from eppodcast where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {               
                  e.setId(rs.getInt("id"));
                  e.setTitulo(rs.getString("titulo"));
                  e.setGenero(rs.getString("genero"));
                  e.setAutor(rs.getString("autor"));
                  e.setTema(rs.getString("tema"));
                  e.setFaixaEtaria(rs.getString("faixaetaria"));
            }
            rs.close();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            
            return e;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<EpPodcast> buscarPorPesquisa(String pesquisa) {
        try {
            
            
            List<EpPodcast> eppodcast = new ArrayList<>();
            PreparedStatement stmt = this.con.prepareStatement("select id, titulo, genero, autor, tema, faixaetaria from eppodcast where titulo=? OR genero=? OR tema=? OR faixaetaria=?");
            stmt.setString(1, pesquisa);
            stmt.setString(2, pesquisa);
            stmt.setString(3, pesquisa);
            stmt.setString(4, pesquisa);
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
