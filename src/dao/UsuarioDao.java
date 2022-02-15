package dao;
import app.App;
import modelo.Usuario;
import util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao extends Dao {

    public Boolean atualizar(Usuario a) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("update usuario set nome=?,email=?,senha=? where id=?");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getSenha());
            stmt.setInt(4, a.getId());
            stmt.executeUpdate();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Integer salvar(Usuario u) {
        Integer last_inserted_id = null;
        try {

            PreparedStatement stmt = this.con.prepareStatement("insert into usuario(nome,email,senha,administrador)values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setBoolean(4, u.getAdministrador());


            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
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

            PreparedStatement stmt = this.con.prepareStatement("delete from usuario where id=?");
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

    public List<Usuario> getUsuario() {
        try {
            
            List<Usuario> usuario = new ArrayList<>();

            PreparedStatement stmt = this.con.prepareStatement("select id, nome, email, senha, administrador from usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setAdministrador(rs.getBoolean("administrador"));
                usuario.add(u);
            }
            rs.close();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            
            return usuario;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
        public Usuario buscarPorId(Integer id) {
        try {
            Usuario u = new Usuario();
            

            PreparedStatement stmt = this.con.prepareStatement("select id, nome, email, senha, administrador from usuario where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {               
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setAdministrador(rs.getBoolean("administrador"));
            }
            rs.close();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            
            return u;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
        public Usuario buscarPorEmail(String email) {
            try {
                Usuario u = new Usuario();
                

                PreparedStatement stmt = this.con.prepareStatement("select id, nome, email, senha, administrador from usuario where email=?");
                stmt.setInt(1, email);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {               
                    u.setId(rs.getInt("id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setSenha(rs.getString("senha"));
                    u.setAdministrador(rs.getBoolean("administrador"));
                }
                rs.close();
                stmt.close();
                ConnectionFactory.closeConexao(this.con);
                
                return u;

            } catch (SQLException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }

        }        

}