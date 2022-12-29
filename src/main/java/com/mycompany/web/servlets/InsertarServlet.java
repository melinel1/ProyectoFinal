package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.AccionesPaciente;
import com.mycompany.web.models.Paciente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nuevopaciente")
public class InsertarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n, a, o, p, m, c;
        int t;

        n = req.getParameter("nombre");
        a = req.getParameter("apellido");
        o = req.getParameter("obraSocial");
        p = req.getParameter("padecimiento");
        t = Integer.parseInt(req.getParameter("telefono"));
        m = req.getParameter("mail");
        c = req.getParameter("comentario");

        Paciente nuevoPaciente = new Paciente();

        nuevoPaciente.setNombre(n);
        nuevoPaciente.setApellido(a);
        nuevoPaciente.setObraSocial(o);
        nuevoPaciente.setPadecimiento(p);
        nuevoPaciente.setTelefono(t);
        nuevoPaciente.setMail(m);
        nuevoPaciente.setComentario(c);


        int estado = AccionesPaciente.registrarPaciente(nuevoPaciente);

        if(estado == 1){
            resp.sendRedirect("exito.jsp");
        }else {
            resp.sendRedirect("error.jsp");
        }
    }
}
