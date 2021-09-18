package br.unisul.aula.dto;

import br.unisul.aula.model.Episodio;

import javax.persistence.Column;

public class EpisodioDTO {
    private Long idEpisodio;
    private String nomeEpisodio;
    private int numeroEpisodio;
    private int numeroTemporada;
    private String descricaoTemporada;
    private String nomeSeriado;


    public EpisodioDTO(Episodio episodio) {
        this.idEpisodio = episodio.getId();
        this.nomeEpisodio = episodio.getNome();
        this.numeroEpisodio = episodio.getNumero();
        this.numeroTemporada = episodio.getTemporada().getNumero();
        this.descricaoTemporada = episodio.getTemporada().getDescricao();
        this.nomeSeriado = episodio.getTemporada().getSeriado().getNome();
    }
    public EpisodioDTO() {
    }

    public Long getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(Long idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public String getDescricaoTemporada() {
        return descricaoTemporada;
    }

    public void setDescricaoTemporada(String descricaoTemporada) {
        this.descricaoTemporada = descricaoTemporada;
    }

    public String getNomeSeriado() {
        return nomeSeriado;
    }

    public void setNomeSeriado(String nomeSeriado) {
        this.nomeSeriado = nomeSeriado;
    }
}
