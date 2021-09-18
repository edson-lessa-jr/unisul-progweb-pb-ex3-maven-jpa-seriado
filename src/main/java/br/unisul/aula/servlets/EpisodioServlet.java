package br.unisul.aula.servlets;

import br.unisul.aula.banco.Banco;
import br.unisul.aula.banco.EpisodioImpl;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.dto.EpisodioDTO;
import br.unisul.aula.model.Episodio;
import br.unisul.aula.model.Seriado;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EpisodioServlet", value = "/EpisodioServlet")
public class EpisodioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        Banco<Episodio> banco = new EpisodioImpl();
        List<Episodio> episodioList = banco.findAll();
        List<EpisodioDTO> dtos = new ArrayList<>();
        for (int i = 0; i < episodioList.size(); i++) {
            EpisodioDTO dto = new EpisodioDTO(episodioList.get(i));
            dtos.add(dto);
        }
        Gson gson = new Gson();
        String episodioJson = gson.toJson(dtos);
        response.getWriter().println(episodioJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
