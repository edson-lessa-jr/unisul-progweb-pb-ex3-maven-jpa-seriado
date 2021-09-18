package br.unisul.aula.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@TableGenerator(name = "seq_temporada", initialValue = 0, allocationSize = 1)
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_temporada")
    private Long id;
    @Column(nullable = false)
    private int numero;
    private String descricao;
    @Column(name = "data_lancamento")
    private LocalDate dataLacamento;
    @ManyToOne
    @JoinColumn(name = "seriado_id")
    private Seriado seriado;

    public Temporada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataLacamento() {
        return dataLacamento;
    }

    public void setDataLacamento(LocalDate dataLacamento) {
        this.dataLacamento = dataLacamento;
    }

    public Seriado getSeriado() {
        return seriado;
    }

    public void setSeriado(Seriado seriado) {
        this.seriado = seriado;
    }

    @Override
    public String toString() {
        return "Temporada{" +
                "id=" + id +
                ", numero=" + numero +
                ", descricao='" + descricao + '\'' +
                ", dataLacamento=" + dataLacamento +
                ", seriado=" + seriado +
                '}';
    }
}
