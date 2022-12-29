package com.mycompany.web.models;
import com.mycompany.web.models.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class AccionesPaciente {
//insertar registro
public static int registrarPaciente(Paciente c){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/optica","root","");

        String query = "INSERT INTO pacientes(nombres,apellidos,obra_social,padecimiento,telefono,mail,comentario) VALUES (?,?,?,?,?,?,?)";

        
        String nombre = c.getNombre();
        String apellido = c.getApellido();
        String obraSocial = c.getObraSocial();
        String padecimiento = c.getPadecimiento();
        int telefono = c.getTelefono();
        String mail = c.getMail();
        String comentario = c.getComentario();


        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, obraSocial);
        pst.setString(4, padecimiento);
        pst.setInt(5, telefono);
        pst.setString(6, mail);
        pst.setString(7, comentario);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salió mal");
    }

    return estado;
}

//actualizar registro
public static int actualizarPaciente(Paciente c){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/optica","root","");

        String query = "UPDATE pacientes SET nombres=?,apellidos=?,obra_social=?,padecimiento=?,telefono=?,mail=?,comentario=? WHERE id_paciente=?";

        int id = c.getId();
        String nombre = c.getNombre();
        String apellido = c.getApellido();
        String obraSocial = c.getObraSocial();
        String padecimiento = c.getPadecimiento();
        int telefono = c.getTelefono();
        String mail = c.getMail();
        String comentario = c.getComentario();

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, obraSocial);
        pst.setString(4, padecimiento);
        pst.setInt(5, telefono);
        pst.setString(6, mail);
        pst.setString(7, comentario);
        pst.setInt(8, id);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println("uppsss algo salió mal");
    }

    return estado;
}

//consultar registro por id
public static Paciente verPaciente(int idAConsultar){
    Paciente pacienteADevolver = new Paciente();

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/optica","root","");

        String query = "SELECT * FROM pacientes WHERE id_paciente=?";

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setInt(1, idAConsultar);

        ResultSet consultaPaciente = pst.executeQuery();

        if (consultaPaciente.next()){
            pacienteADevolver.setId( consultaPaciente.getInt(1));
            pacienteADevolver.setNombre( consultaPaciente.getString(2));
            pacienteADevolver.setApellido( consultaPaciente.getString(3));
            pacienteADevolver.setObraSocial( consultaPaciente.getString(4));
            pacienteADevolver.setPadecimiento( consultaPaciente.getString(5));
            pacienteADevolver.setTelefono( consultaPaciente.getInt(6));
            pacienteADevolver.setMail( consultaPaciente.getString(7));
            pacienteADevolver.setComentario( consultaPaciente.getString(8));
            conexion.close();
        }
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salió mal");
    }

    return pacienteADevolver;
}    

//consultar todos los registros de una tabla
public static List<Paciente> verTodosPacientes(){
    List<Paciente> listaPacientesADevolver = new ArrayList<Paciente>();
    

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/optica","root","");

        String query = "SELECT * FROM pacientes";

        PreparedStatement pst = conexion.prepareStatement(query);

        ResultSet consultaPaciente = pst.executeQuery();

        while (consultaPaciente.next()){
            Paciente pacienteADevolver = new Paciente(); //EN CADA VUELTA NECESITAREMOS INSTANCIAR UN NUEVO OBJETO
            pacienteADevolver.setId( consultaPaciente.getInt(1));
            pacienteADevolver.setNombre( consultaPaciente.getString(2));
            pacienteADevolver.setApellido( consultaPaciente.getString(3));
            pacienteADevolver.setObraSocial( consultaPaciente.getString(4));
            pacienteADevolver.setPadecimiento( consultaPaciente.getString(5));
            pacienteADevolver.setTelefono( consultaPaciente.getInt(6));
            pacienteADevolver.setMail( consultaPaciente.getString(7));
            pacienteADevolver.setComentario( consultaPaciente.getString(8));
            listaPacientesADevolver.add(pacienteADevolver);
        }
        conexion.close();
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salió mal");
    }

    return listaPacientesADevolver;
} 
    
}
