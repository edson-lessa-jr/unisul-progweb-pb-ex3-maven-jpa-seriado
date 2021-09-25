package br.unisul.aula.servlets;

import br.unisul.aula.banco.Banco;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.dto.EpisodioDTO;
import br.unisul.aula.dto.SeriadoDTO;
import br.unisul.aula.model.Seriado;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SeriadoServlet", value = "/SeriadoServlet")
public class SeriadoServlet extends HttpServlet {

    private final Gson gson = new Gson();
    private final Banco<Seriado> banco = new SeriadoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Seriado> seriadoList = banco.findAll();
        List<SeriadoDTO> dtos = new ArrayList<>();
        for (int i = 0; i < seriadoList.size(); i++) {
            SeriadoDTO dto = new SeriadoDTO(seriadoList.get(i));
            dtos.add(dto);
        }
        String seriadoJson = gson.toJson(dtos);
        response.getWriter().println(seriadoJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        SeriadoDTO seriadoDTO = gson.fromJson(reader, SeriadoDTO.class);
        Seriado seriado = seriadoDTO.converterParaSeriado();
        banco.insert(seriado);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        SeriadoDTO seriadoDTO = gson.fromJson(reader, SeriadoDTO.class);
        System.out.println(seriadoDTO);
        Seriado seriado = seriadoDTO.converterParaSeriado();
        System.out.println(seriado);
        banco.update(seriado);

    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        SeriadoDTO seriadoDTO = gson.fromJson(reader, SeriadoDTO.class);
        banco.remove(seriadoDTO.getId());
    }

}
