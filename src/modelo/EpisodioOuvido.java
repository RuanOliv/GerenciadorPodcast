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
	
	public static EpisodioOuvido buscarPorId(Integer idEpisodio, Integer idUsuario) {
		return DaoFactory.getEpisodioOuvidoDao().buscarPorId(idEpisodio, idUsuario);
	}
	
	public static EpisodioOuvido buscarEpisodiosPorId(Integer idEpisodio) {
		return DaoFactory.getEpisodioOuvidoDao().buscarEpisodiosPorId(idEpisodio);
	}
	
	public static Boolean deletar(Integer idEpisodio, Integer idUsuario) {
		return DaoFactory.getEpisodioOuvidoDao().delete(idEpisodio, idUsuario);
	}
	
	public static Boolean deletarEpisodios(Integer idEpisodio) {
		return DaoFactory.getEpisodioOuvidoDao().deleteEpisodios(idEpisodio);
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
