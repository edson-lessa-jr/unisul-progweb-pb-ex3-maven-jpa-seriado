package br.unisul.aula.dto;

import br.unisul.aula.model.Seriado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class SeriadoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String dataInicio;


    public SeriadoDTO(Seriado seriado) {
        this.id = seriado.getId();
        this.nome = seriado.getNome();
        this.descricao = seriado.getDescricao();
        this.dataInicio = converterLocalDate(seriado.getDataInicio());
    }

    private String converterLocalDate(LocalDate date){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formato);
    }

    public SeriadoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
}
