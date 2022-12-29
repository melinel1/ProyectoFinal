package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.AccionesPaciente;
import com.mycompany.web.models.Paciente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verpaciente")
public class VerCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id  = Integer.parseInt(req.getParameter("idpaciente"));

        Paciente registro = AccionesPaciente.verPaciente(id);

        req.setAttribute("c", registro);

        RequestDispatcher respuesta = req.getRequestDispatcher("infopaciente.jsp");
        respuesta.forward(req, resp);
    }
}
