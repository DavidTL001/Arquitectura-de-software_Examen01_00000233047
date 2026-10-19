/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;



/**
 *
 * @author David Alejandro Triado Luna 00000233047
 */
public class Alumno {

    private String idAlumno;
    private String nombreCompleto;
    private String campus;

    public Alumno(String idAlumno, String nombreCompleto, String campus) {
        this.idAlumno = idAlumno;
        this.nombreCompleto = nombreCompleto;
        this.campus = campus;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCampus() {
        return campus;
    }
}
