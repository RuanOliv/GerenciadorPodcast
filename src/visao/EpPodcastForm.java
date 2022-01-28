/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import static app.App.menu;
import controle.EpPodcastControle;
import dao.DaoFactory;
import modelo.EpPodcast;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Linkdesign
 */
public class EpPodcastForm {

    private static Scanner teclado = new Scanner(System.in);

    public static void salvar() {

        System.out.println("Digite o titulo: ");
        String titulo = teclado.nextLine();
        System.out.println("Digite o genero: ");
        String genero = teclado.nextLine();
        System.out.println("Digite a autor: ");
        String autor = teclado.nextLine();
        System.out.println("Digite a tema: ");
        String tema = teclado.nextLine();
        System.out.println("Digite a faixa etaria: ");
        String faixaEtaria = teclado.nextLine();


        EpPodcastControle.cadastrarEpPodcast(titulo,genero,autor,tema,faixaEtaria);
    }
    
    public static void listar(){
        
        List<EpPodcast> eppodcast = EpPodcastControle.listar();
        System.out.println("----- EPISÓDIOS CADASTRADOS -------");
        System.out.println("ID              | TITULO              | GENERO             | AUTOR             | TEMA             | FAIXA ETÁRIA");
        for (EpPodcast EpPodcast : eppodcast) {
            System.out.println(EpPodcast.getId()+ "              | " 
                    + EpPodcast.getTitulo() + "              | " 
                    + EpPodcast.getGenero() + "              | " 
                    + EpPodcast.getAutor() + "              | " 
                    + EpPodcast.getTema() + "              | " 
                    + EpPodcast.getFaixaEtaria());            
        }
        
    }
    
    public static Boolean delete(){
        System.out.println("----- DELETAR EPISÓDIO -------");
        System.out.println("Digite o id da episódio: ");
        Integer id = Integer.parseInt(teclado.nextLine());
   
        return EpPodcastControle.delete(id);
        
    }
    
    
    public static void atualizar(){
        System.out.println("----- ATUALIZAR EPISÓDIO -------");
        System.out.println("Digite o id do episódio: ");
        Integer id = Integer.parseInt(teclado.nextLine());
        

        if(buscarPorId(id)!=null){
            System.out.println("Digite o titulo: ");
            String titulo = teclado.nextLine();
            System.out.println("Digite o genero: ");
            String genero = teclado.nextLine();
            System.out.println("Digite o autor: ");
            String autor = teclado.nextLine();
            System.out.println("Digite o tema: ");
            String tema = teclado.nextLine();
            System.out.println("Digite o faixa etária: ");
            String faixaEtaria = teclado.nextLine();
            EpPodcastControle.atualizar(id, titulo, genero, autor, tema, faixaEtaria);
        }else{
            System.out.println("Matricula não encontrado.");
        }
        
        
    }
    
    public static EpPodcast buscarPorId(Integer id){
        
        return DaoFactory.getEpPodcastDao().buscarPorId(id);
        
    }

}