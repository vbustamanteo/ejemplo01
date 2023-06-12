package pe.edu.unmsm.ejemplo01.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.ejemplo01.entidades.Alumno;
import pe.edu.unmsm.ejemplo01.repositorios.AlumnoRepositorio;

@Service
public class AlumnoServicioImpl implements IAlumnoServicio {
	@Autowired
	AlumnoRepositorio alumnoRepositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		return (List<Alumno>) alumnoRepositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(Integer id) {
		return alumnoRepositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findByAluvccodigo(String aluvccodigo) {
		return alumnoRepositorio.findByAluvccodigo(aluvccodigo);
	}
	
}
