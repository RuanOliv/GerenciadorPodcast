package controle;

import dao.DaoFactory;
import modelo.EpPodcast;
import java.util.List;


public class EpPodcastControle {
    
    public static EpPodcast cadastrarEpPodcast(String titulo, String genero, String autor, String tema, String faixaEtaria){
        
        EpPodcast e = new EpPodcast();
        e.setTitulo(titulo);
        e.setGenero(genero);
        e.setAutor(autor);
        e.setTema(tema);
        e.setFaixaEtaria(faixaEtaria);

        
        e.setId(DaoFactory.getEpPodcastDao().salvar(e));
        
        return e;
        
    }
    public static List<EpPodcast> listar(){
        
        return DaoFactory.getEpPodcastDao().getEpPodcast();
        
    }
    
    public static Boolean delete(Integer id){
        
        return DaoFactory.getEpPodcastDao().delete(id);
        
    }
    
    
    public static Boolean atualizar(Integer id, String titulo, String genero, String autor, String tema, String faixaEtaria){
        EpPodcast e = new EpPodcast();
        e.setId(id); 
        e.setTitulo(titulo);
        e.setGenero(genero);
        e.setAutor(autor);
        e.setTema(tema);
        e.setFaixaEtaria(faixaEtaria);

        
        return DaoFactory.getEpPodcastDao().atualizar(e);
        
    }
    
    public static EpPodcast buscarPorId(Integer id){
        
        return DaoFactory.getEpPodcastDao().buscarPorId(id);
        
    }
    
    
}