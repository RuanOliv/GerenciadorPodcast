package app;

import modelo.Usuario;
import modelo.EpPodcast;
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
                    
                    break;
                case 2:
                    
                    break;    
                case 3:
                    
                    break;
                case 4:
                    
                    break;    
                case 5:
                    
                    break;
                case 6:
                    
                    break;    
                case 7:
                    
                    break;
                case 8:
                    
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