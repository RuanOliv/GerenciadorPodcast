package modelo;

import java.util.List;

import dao.DaoFactory;
import dao.EpisodioOuvidoDao;

public class EpisodioOuvido {

	private Integer idUsuario;
	private Integer idEpisodio;
	
	public static EpisodioOuvido salvar(EpisodioOuvido episodioOuvido) {
		
		return DaoFactory.getEpisodioOuvidoDao().salvar(episodioOuvido);
	
	}
	
	public static List<EpPodcast> episodios(Integer id){
		return DaoFactory.getEpisodioOuvidoDao().getEpisodiosOuvidos(id);
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdEpisodio() {
		return idEpisodio;
	}
	public void setIdEpisodio(Integer idEpisodio) {
		this.idEpisodio = idEpisodio;
	}
	
	
}
