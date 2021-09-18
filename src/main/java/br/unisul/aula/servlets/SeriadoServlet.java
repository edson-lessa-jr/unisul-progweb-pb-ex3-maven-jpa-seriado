package br.unisul.aula.servlets;

import br.unisul.aula.banco.Banco;
import br.unisul.aula.banco.SeriadoImpl;
import br.unisul.aula.dto.SeriadoDTO;
import br.unisul.aula.model.Seriado;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SeriadoServlet", value = "/SeriadoServlet")
public class SeriadoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        Banco<Seriado> banco = new SeriadoImpl();
        List<Seriado> seriadoList = banco.findAll();
        List<SeriadoDTO> dtos = new ArrayList<>();
        for (int i = 0; i < seriadoList.size(); i++) {
            SeriadoDTO dto = new SeriadoDTO(seriadoList.get(i));
            dtos.add(dto);
        }
        Gson gson = new Gson();
        String seriadoJson = gson.toJson(dtos);
        response.getWriter().println(seriadoJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

    }
}
