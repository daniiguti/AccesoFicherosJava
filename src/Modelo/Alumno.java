package Modelo;

import java.io.Serializable;
import java.util.Date;

public class Alumno implements Serializable{ //Hay que implementar esto para convertirlo en un flujo de 8 bits
    //Atributos de la clase
    private int numMatricula;
    private double notaMedia;
    private String nombreAlumno;
    private Date fechaNac;
    private int edad;
    
    //Constructores
    public Alumno(){
        this.numMatricula = 0;
        this.notaMedia = 0;
        this.nombreAlumno = "";
        this.fechaNac = new Date(0);
        this.edad = 0;
    }
    
    public Alumno(int numMatricula, String nombre, Date fechaNacimiento, double notaMedia, int edad){
        this.numMatricula = numMatricula;
        this.notaMedia = notaMedia;
        this.nombreAlumno = nombre;
        this.fechaNac = fechaNacimiento;
        this.edad = edad;
    }

    public int getNumMatricula() {
        return numMatricula;
    }
    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public double getNotaMedia() {
        return notaMedia;
    }
    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public Date getFechaNac() {
        return fechaNac;    
    }
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }   
    
}
