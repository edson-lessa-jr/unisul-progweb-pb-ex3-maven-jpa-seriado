package br.unisul.aula;

import br.unisul.aula.banco.Banco;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.model.Seriado;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Seriado seriado = new Seriado();
        seriado.setNome("Teste");
        seriado.setDescricao("tesate");
        seriado.setDataInicio(LocalDate.now());

        Banco<Seriado> banco = new SeriadoImpl();
        banco.insert(seriado);

        System.out.println(banco.findAll());
    }
}
