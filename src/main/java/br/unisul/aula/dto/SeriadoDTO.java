package br.unisul.aula.dto;

import br.unisul.aula.model.Seriado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SeriadoDTO {
    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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

    public Seriado converterParaSeriado() {
        Seriado seriado = new Seriado();
        seriado.setId(this.getId());
        seriado.setNome(this.nome);
        seriado.setDescricao(this.descricao);
        LocalDate objetoData = LocalDate.parse(this.dataInicio, FORMATO);
        seriado.setDataInicio(objetoData);
        return seriado;
    }

    private String converterLocalDate(LocalDate date){
        return date.format(FORMATO);
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

    @Override
    public String toString() {
        return "SeriadoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                '}';
    }
}
