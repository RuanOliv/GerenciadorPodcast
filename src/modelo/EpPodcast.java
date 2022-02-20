
package modelo;

import java.util.List;

import dao.DaoFactory;

public class EpPodcast {
    private Integer id;
    private String titulo;
    private String genero; 
    private String autor;
    private String tema;
    private String faixaEtaria;

    public static List<EpPodcast> episodios(){
		return DaoFactory.getEpPodcastDao().getEpPodcast();
	}
	
	public static Boolean delete(Integer id){
        
        return DaoFactory.getEpPodcastDao().delete(id);
        
    }
	
	public static List<EpPodcast> buscarPorPesquisa(String pesquisa){
        
        return DaoFactory.getEpPodcastDao().buscarPorPesquisa(pesquisa);
        
    }
	
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitulo (String titulo){
        this.titulo = titulo;
    }
     public void setGenero (String genero){
        this.genero = genero;
    }
      public void setAutor (String autor){
        this.autor = autor;
    }
       public void setTema (String tema){
        this.tema = tema;
    }
        public void setFaixaEtaria (String faixaEtaria){
        this.faixaEtaria = faixaEtaria;
    }
       public String getTitulo (){
        return this.titulo;
    }
     public String getGenero (){
        return this.genero;
    }
      public String getAutor (){
        return this.autor;
    }
       public String getTema (){
        return this.tema;
    }
        public String getFaixaEtaria (){
        return this.faixaEtaria;
    }
    
}


