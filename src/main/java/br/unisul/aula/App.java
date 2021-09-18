package br.unisul.aula;

import br.unisul.aula.banco.Banco;
import br.unisul.aula.banco.EpisodioImpl;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.banco.TemporadaImpl;
import br.unisul.aula.model.Episodio;
import br.unisul.aula.model.Seriado;
import br.unisul.aula.model.Temporada;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Seriado seriado = new Seriado();
        seriado.setNome("Teste");
        seriado.setDescricao("tesate");
        seriado.setDataInicio(LocalDate.now());
        Banco<Seriado> bdSeriado = new SeriadoImpl();
        bdSeriado.insert(seriado);

        Temporada temporada = new Temporada();
        temporada.setNumero(1);
        temporada.setDescricao("teste");
        temporada.setDataLacamento(LocalDate.now());
        temporada.setSeriado(seriado);
        Banco<Temporada> bdTemporada = new TemporadaImpl();
        bdTemporada.insert(temporada);

        Episodio episodio = new Episodio();
        episodio.setNome("Tese");
        episodio.setNumero(1);
        episodio.setTemporada(temporada);
        Banco<Episodio> bdEpisodio = new EpisodioImpl();
        bdEpisodio.insert(episodio);


        System.out.println(bdSeriado.findAll());
        System.out.println(bdTemporada.findAll());
        System.out.println(bdEpisodio.findAll());
    }
}
