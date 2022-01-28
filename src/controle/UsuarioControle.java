package controle;

import dao.DaoFactory;
import modelo.Usuario;
import java.util.List;


public class UsuarioControle {
    
    public static Usuario cadastrarUsuario(String nome, String email, String senha, Boolean administrador){
        
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);
        u.setAdministrador(administrador);

        
        u.setId(DaoFactory.getUsuarioDao().salvar(u));
        
        return u;
        
    }
    
    public static List<Usuario> listar(){
        
        return DaoFactory.getUsuarioDao().getUsuario();
        
    }
    
    public static Boolean delete(Integer id){
        
        return DaoFactory.getUsuarioDao().delete(id);
        
    }
    
    
    public static Boolean atualizar(Integer id, String nome, String email, String senha){
        Usuario u = new Usuario();
        u.setId(id);
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);
        
        return DaoFactory.getUsuarioDao().atualizar(u);
        
    }
    
    public static Usuario buscarPorId(Integer id){
        
        return DaoFactory.getUsuarioDao().buscarPorId(id);
        
    }
    
}