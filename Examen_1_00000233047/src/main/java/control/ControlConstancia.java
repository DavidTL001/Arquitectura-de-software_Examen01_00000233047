package control;

import entity.Alumno;
import entity.Inscripcion;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Alejandro Triado Luna 00000233047
 */
public class ControlConstancia {

    private List<Inscripcion> listaInscripciones;

    public ControlConstancia() {
        this.listaInscripciones = new ArrayList<>();
        cargarDatosPrueba();
    }

    /**
     * Carga los datos de prueba
     */
    private void cargarDatosPrueba() {
        Alumno a1 = new Alumno("00000233047", "David Alejandro Tirado Luna", "ITSON Nainari");
        Inscripcion i1 = new Inscripcion(a1, "ISW-2023", "Ingeniero en Software", 5, 8,
                "10 ciclo Enero-Mayo de 2026", "520307", "19 de enero", "23 de mayo de 2026");

        Alumno a2 = new Alumno("00000233367", "María Fernanda López Torres", "ITSON Centro");
        Inscripcion i2 = new Inscripcion(a2, "ISW-2023", "Ingeniero en Software", 4, 6,
                "10 ciclo Enero-Mayo de 2026", "520307", "19 de enero", "23 de mayo de 2026");

        Alumno a3 = new Alumno("00000233123", "Carlos Eduardo Gómez Ruiz", "ITSON Nainari");
        Inscripcion i3 = new Inscripcion(a3, "LIC-2021", "Licenciado en Administración", 6, 7,
                "10 ciclo Enero-Mayo de 2026", "410201", "19 de enero", "23 de mayo de 2026");

        Alumno a4 = new Alumno("00000233995", "Ana Sofía Hernández Castro", "ITSON Nainari");
        Inscripcion i4 = new Inscripcion(a4, "ISW-2023", "Ingeniero en Software", 3, 5,
                "10 ciclo Enero-Mayo de 2026", "520307", "19 de enero", "23 de mayo de 2026");

        Alumno a5 = new Alumno("00000233897", "Jorge Luis Martínez Silva", "ITSON Centro");
        Inscripcion i5 = new Inscripcion(a5, "IND-2022", "Ingeniero Industrial", 7, 6,
                "10 ciclo Enero-Mayo de 2026", "510100", "19 de enero", "23 de mayo de 2026");

        listaInscripciones.add(i1);
        listaInscripciones.add(i2);
        listaInscripciones.add(i3);
        listaInscripciones.add(i4);
        listaInscripciones.add(i5);
    }

    /**
     * Filtra los alumnos cuyo ID contenga la cadena ingresada en el buscador.
     */
    public List<Alumno> buscarAlumnosPorID(String criterio) {
        List<Alumno> resultado = new ArrayList<>();
        if (criterio == null || criterio.trim().isEmpty() || criterio.equalsIgnoreCase("buscar...")) {
            return resultado;
        }

        String idLimpio = criterio.trim();
        for (Inscripcion ins : listaInscripciones) {
            if (ins.getAlumno().getIdAlumno().contains(idLimpio)) {
                resultado.add(ins.getAlumno());
            }
        }
        return resultado;
    }

    /**
     * Obtiene la inscripción vigente correspondiente al ID de un alumno.
     */
    public Inscripcion obtenerInscripcionVigente(String idAlumno) {
        if (idAlumno == null) {
            return null;
        }

        for (Inscripcion ins : listaInscripciones) {
            if (ins.getAlumno().getIdAlumno().equalsIgnoreCase(idAlumno.trim())) {
                return ins;
            }
        }
        return null;
    }

    public void seleccionarInscripcion(String idAlumno, PropertyChangeListener observador) {
        Inscripcion ins = obtenerInscripcionVigente(idAlumno);
        if (ins != null) {

            ins.addPropertyChangeListener(observador);

            ins.notificarSeleccion();
        }
    }

    /**
     * Construye el texto de previsualización con los datos académicos.
     */
    public String construirTextoPrevisualizacion(Alumno alumno, Inscripcion inscripcion) {
        if (alumno == null || inscripcion == null) {
            return "";
        }

        return "Nombre: " + alumno.getNombreCompleto() + "\n\n"
                + "carrera: " + inscripcion.getCarrera() + "\n\n"
                + "Campus: " + alumno.getCampus() + "\n\n"
                + "Semestre inscrito: " + inscripcion.getSemestreInscrito() + "\n\n"
                + "Cantidad de materias que está cursando: " + inscripcion.getCantidadMaterias();
    }

    /**
     * Ensambla la plantilla en el cuadro de visualización.
     */
    public String construirPlantillaConstancia(Alumno alumno, Inscripcion inscripcion) {
        if (alumno == null || inscripcion == null) {
            return "";
        }

        return "             Instituto Tecnológico de Sonora\n"
                + "               Departamento de Registro Escolar\n\n\n"
                + "El suscrito Administrador de Servicios Escolares del Instituto\n"
                + "Tecnológico de Sonora, según la información que\n"
                + "existe en las bases de datos escolares, hace constar que:\n\n"
                + "               " + alumno.getNombreCompleto() + "\n\n"
                + "Con ID: " + alumno.getIdAlumno() + " está inscrito en el " + inscripcion.getCicloLectivo() + ",\n"
                + "en el programa de " + inscripcion.getProgramaEducativo() + ",\n"
                + "con clave ante la Dirección General de Profesiones " + inscripcion.getClaveProfesiones() + " "
                + "durante el periodo\ncomprendido entre " + inscripcion.getFechaInicioPeriodo() + " al "
                + inscripcion.getFechaFinPeriodo() + " cursando las\nsiguientes asignaturas: "
                + inscripcion.getCantidadMaterias();
    }
}
