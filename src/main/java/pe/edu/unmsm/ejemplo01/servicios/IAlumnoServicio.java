package pe.edu.unmsm.ejemplo01.servicios;

import java.util.List;
import pe.edu.unmsm.ejemplo01.entidades.Alumno;

public interface IAlumnoServicio {
	public List<Alumno> findAll();
	public Alumno findById(Integer id);
	public Alumno findByAluvccodigo(String aluvccodigo);
}
