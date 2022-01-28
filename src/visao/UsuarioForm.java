/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import static app.App.menu;
import controle.UsuarioControle;
import dao.DaoFactory;
import modelo.Usuario;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Linkdesign
 */
public class UsuarioForm {

    private static Scanner teclado = new Scanner(System.in);

    public static void salvar() {

        System.out.println("Digite o nome: ");
        String nome = teclado.nextLine();
        System.out.println("Digite a email: ");
        String email = teclado.nextLine();
        System.out.println("Digite a senha: ");
        String senha = teclado.nextLine();
        System.out.println("É adminsitrador (true) - sim/(false) - não: ");
        Boolean administrador = teclado.nextBoolean();        
        UsuarioControle.cadastrarUsuario(nome, email, senha, administrador);
    }
    
    public static void listar(){
        
        List<Usuario> usuarios = UsuarioControle.listar();
        System.out.println("----- USUÁRIOS CADASTRADOS -------");
        System.out.println("ID                 | NOME                 | EMAIL                 |SENHA                 |ADMINISTRADOR");
        for (Usuario Usuario : usuarios) {
            System.out.println(Usuario.getId() + "                 "
                    + "| " +
                    Usuario.getNome() + "                 "
                    + "| " + Usuario.getEmail() + "                 "
                            + "| " + Usuario.getSenha() + "                 "
                                    + "| " + Usuario.getAdministrador());            
        }
        
    }
    
    public static Boolean delete(){
        System.out.println("----- DELETAR USUÁRIO -------");
        System.out.println("Digite o id do usuário: ");
        Integer id = Integer.parseInt(teclado.nextLine());
   
        return UsuarioControle.delete(id);
        
    }
    
    
    public static void atualizar(){
        System.out.println("----- ATUALIZAR USUÁRIO -------");
        System.out.println("Digite o id do usuario: ");
        Integer id = Integer.parseInt(teclado.nextLine());

        if(buscarPorId(id)!=null){
            System.out.println("Digite o nome: ");
            String nome = teclado.nextLine();
            System.out.println("Digite a email: ");
            String email = teclado.nextLine();
            System.out.println("Digite a senha: ");
            String senha = teclado.nextLine();
            UsuarioControle.atualizar(id, nome, email,senha);
        }else{
            System.out.println("Aluno não encontrado.");
        }
        
        
    }
    
    public static Usuario buscarPorId(Integer id){
        
        return DaoFactory.getUsuarioDao().buscarPorId(id);
        
    }

}