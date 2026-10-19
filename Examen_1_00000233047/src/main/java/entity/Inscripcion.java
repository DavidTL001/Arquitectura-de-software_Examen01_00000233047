package entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 *
 * @author David Alejandro Triado Luna 00000233047
 */
public class Inscripcion {

    private Alumno alumno;
    private String carrera;
    private String programaEducativo;
    private int semestreInscrito;
    private int cantidadMaterias;
    private String cicloLectivo;
    private String claveProfesiones;
    private String fechaInicioPeriodo;
    private String fechaFinPeriodo;

    //patrón Observer
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public Inscripcion(Alumno alumno, String carrera, String programaEducativo, int semestreInscrito,
            int cantidadMaterias, String cicloLectivo, String claveProfesiones,
            String fechaInicioPeriodo, String fechaFinPeriodo) {
        this.alumno = alumno;
        this.carrera = carrera;
        this.programaEducativo = programaEducativo;
        this.semestreInscrito = semestreInscrito;
        this.cantidadMaterias = cantidadMaterias;
        this.cicloLectivo = cicloLectivo;
        this.claveProfesiones = claveProfesiones;
        this.fechaInicioPeriodo = fechaInicioPeriodo;
        this.fechaFinPeriodo = fechaFinPeriodo;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void notificarSeleccion() {
        support.firePropertyChange("inscripcionSeleccionada", null, this);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public int getSemestreInscrito() {
        return semestreInscrito;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public String getCicloLectivo() {
        return cicloLectivo;
    }

    public String getClaveProfesiones() {
        return claveProfesiones;
    }

    public String getFechaInicioPeriodo() {
        return fechaInicioPeriodo;
    }

    public String getFechaFinPeriodo() {
        return fechaFinPeriodo;
    }
}
