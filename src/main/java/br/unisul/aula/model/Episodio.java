package br.unisul.aula.model;

import javax.persistence.*;

@Entity
@TableGenerator(name = "seq_episodio", initialValue = 0, allocationSize = 1)
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seq_episodio")
    private Long id;

    private String nome;
    @Column(nullable = false)
    private int numero;
    @ManyToOne
    @JoinColumn(name = "temporada_id")
    private Temporada temporada;

    public Episodio() {
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numero=" + numero +
                ", temporada=" + temporada +
                '}';
    }
}
