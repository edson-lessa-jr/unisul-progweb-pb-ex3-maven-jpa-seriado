package br.unisul.aula.dto;

import br.unisul.aula.model.Seriado;
import br.unisul.aula.model.Temporada;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TemporadaDTO {
    private Long id;
    private Integer numero;
    private String descricao;
    private String dataLacamento;
    private Long seriadoId;
    private String nomeSeriado;

    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TemporadaDTO(Temporada temporada) {
        this.id = temporada.getId();
        this.numero = temporada.getNumero();
        this.descricao = temporada.getDescricao();
        this.dataLacamento = temporada.getDataLacamento().format(FORMATO_DATA);
        this.seriadoId = temporada.getSeriado().getId();
        this.nomeSeriado = temporada.getSeriado().getNome();
    }

    public TemporadaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataLacamento() {
        return dataLacamento;
    }

    public void setDataLacamento(String dataLacamento) {
        this.dataLacamento = dataLacamento;
    }

    public Long getSeriadoId() {
        return seriadoId;
    }

    public void setSeriadoId(Long seriadoId) {
        this.seriadoId = seriadoId;
    }

    public String getNomeSeriado() {
        return nomeSeriado;
    }

    public void setNomeSeriado(String nomeSeriado) {
        this.nomeSeriado = nomeSeriado;
    }

    public Temporada converterParaTemporada(Seriado seriado) {
        Temporada temporada = new Temporada();
        temporada.setId(this.id);
        temporada.setNumero(this.numero);
        temporada.setDescricao(this.descricao);
        temporada.setDataLacamento(LocalDate.parse(this.dataLacamento, FORMATO_DATA));
        temporada.setSeriado(seriado);
        return temporada;
    }
}
