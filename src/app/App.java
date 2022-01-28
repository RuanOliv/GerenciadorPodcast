package app;

import modelo.Usuario;
import modelo.EpPodcast;
import visao.UsuarioForm;
import visao.EpPodcastForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

       

        int opcao = 0;
        Scanner teclado = new Scanner(System.in);
        
        try {
            do {

            menu();
            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {
                case 1:
                    UsuarioForm.salvar();
                    break;
                case 2:
                    UsuarioForm.atualizar();
                    break;    
                case 3:
                    UsuarioForm.delete();
                    break;
                case 4:
                    UsuarioForm.listar();
                    break;    
                case 5:
                    EpPodcastForm.salvar();
                    break;
                case 6:
                    EpPodcastForm.atualizar();
                    break;    
                case 7:
                    EpPodcastForm.delete();
                    break;
                case 8:
                    EpPodcastForm.listar();
                    break;
                

            }

        } while (opcao != 0);

        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }
        
    }

    public static void menu() {
        System.out.println("Menu\n"
                + "---------------------------------\n"
                + "1 – Cadastrar Usuário\n"
                + "2 - Atualizar Usuário\n"                                
                + "3 - Deletar Usuário\n"
                + "4 - Listar Usuário\n"
                + "5 – Cadastrar Episódio\n"
                + "6 - Atualizar Episódio\n"
                + "7 - Deletar Episódio\n"
                + "8 – Listar Episódios\n"
                + "0 – Sair\n"
                + "---------------------------------\n"
                + "\n"
                + "Digite a opção: ");
    }


}