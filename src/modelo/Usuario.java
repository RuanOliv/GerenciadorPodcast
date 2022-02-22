
package modelo;


import java.util.List;

import dao.DaoFactory;

public class Usuario {
    
    
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Boolean administrador;
    
	public static List<Usuario> usuarios(){
		return DaoFactory.getUsuarioDao().getUsuario();
	}
	
	public static Boolean delete(Integer id){
        
        return DaoFactory.getUsuarioDao().delete(id);
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

}