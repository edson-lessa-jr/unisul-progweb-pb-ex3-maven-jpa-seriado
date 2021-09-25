package br.unisul.aula.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@TableGenerator(name = "seq_seriado", initialValue = 0, allocationSize = 1)
public class Seriado {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_seriado")
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    public Seriado() {
    }

    @Override
    public String toString() {
        return "Seriado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                '}';
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

}
