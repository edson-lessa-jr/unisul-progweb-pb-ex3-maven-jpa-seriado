package br.unisul.aula.servlets;

import br.unisul.aula.banco.Banco;
import br.unisul.aula.banco.EpisodioImpl;
import br.unisul.aula.banco.TemporadaImpl;
import br.unisul.aula.dto.EpisodioDTO;
import br.unisul.aula.model.Episodio;
import br.unisul.aula.model.Temporada;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EpisodioServlet", value = "/EpisodioServlet")
public class EpisodioServlet extends HttpServlet {

    private final Gson gson = new Gson();
    private final Banco<Episodio> banco = new EpisodioImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Episodio> episodioList = banco.findAll();
        List<EpisodioDTO> dtos = new ArrayList<>();
        for (int i = 0; i < episodioList.size(); i++) {
            EpisodioDTO dto = new EpisodioDTO(episodioList.get(i));
            dtos.add(dto);
        }
        String episodioJson = gson.toJson(dtos);
        response.getWriter().println(episodioJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        EpisodioDTO episodioDTO= gson.fromJson(reader, EpisodioDTO.class);
        Banco<Temporada> temporadaBanco = new TemporadaImpl();
        Temporada temporada = ((TemporadaImpl) temporadaBanco).buscaPorNumeroESeriado(episodioDTO.getNumeroTemporada(), episodioDTO.getSeriadoId());
        Episodio episodio = episodioDTO.converterParaEpisodio(temporada);
        banco.insert(episodio);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        EpisodioDTO episodioDTO= gson.fromJson(reader, EpisodioDTO.class);
        Banco<Temporada> temporadaBanco = new TemporadaImpl();
        Temporada temporada = ((TemporadaImpl) temporadaBanco).buscaPorNumeroESeriado(episodioDTO.getNumeroTemporada(), episodioDTO.getSeriadoId());
        Episodio episodio = episodioDTO.converterParaEpisodio(temporada);
        banco.update(episodio);

    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        EpisodioDTO episodioDTO = gson.fromJson(reader, EpisodioDTO.class);
        banco.remove(episodioDTO.getIdEpisodio());
    }
}
