package com.mycompany.web.models;
import java.io.Serializable;

public class Paciente implements Serializable {
        private int id,telefono;
        private String nombre,apellido,obraSocial,padecimiento,mail,comentario;

        public Paciente(){
    
        }
    
        public int getId(){
            return id;
        }
        public void setId(int nuevoId){
            this.id = nuevoId;
        }
    
        public String getNombre(){
            return nombre;
        }
        public void setNombre(String nuevoNombre){
            this.nombre = nuevoNombre;
        }
    
        public String getApellido(){
            return apellido;
        }
        public void setApellido(String nuevoApellido){
            this.apellido = nuevoApellido;
        }
    
        public String getObraSocial(){
            return obraSocial;
        }
        public void setObraSocial(String nuevaObrasocial){
            this.obraSocial = nuevaObrasocial;
        }

        public String getPadecimiento(){
            return padecimiento;
        }
        public void setPadecimiento(String nuevoPadecimiento){
            this.padecimiento = nuevoPadecimiento;
        }

        public int getTelefono(){
            return telefono;
        }
        public void setTelefono(int i){
            this.telefono = i;
        }

        public String getMail(){
            return mail;
        }
        public void setMail(String nuevoMail){
            this.mail = nuevoMail;
        }

        public String getComentario(){
            return comentario;
        }
        public void setComentario(String nuevoComentario){
            this.comentario = nuevoComentario;
        }

    }

