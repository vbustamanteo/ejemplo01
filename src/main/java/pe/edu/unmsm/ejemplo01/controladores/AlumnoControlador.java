package pe.edu.unmsm.ejemplo01.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.unmsm.ejemplo01.entidades.Alumno;
import pe.edu.unmsm.ejemplo01.servicios.IAlumnoServicio;

@RestController
public class AlumnoControlador {
	@Autowired
	private Environment env;
	
	@Autowired
	private IAlumnoServicio alumnoServicio;
	
	@GetMapping("/todos")
	public List<Alumno> findAll() {
		return alumnoServicio.findAll();
	}

	@GetMapping("/ver/{id}")
	public Alumno codigo(@PathVariable Integer id) {
		Alumno alumno = alumnoServicio.findById(id);
		alumno.setPuerto(Integer.parseInt(env.getProperty("local.server.port")));
		return alumno;
	}
	
	@GetMapping("/codigo/{aluvccodigo}")
	public Alumno codigo(@PathVariable String aluvccodigo) {
		return alumnoServicio.findByAluvccodigo(aluvccodigo);
	}

	/*
	@PostMapping("/nuevo")
	public @ResponseBody Integer add(
			@RequestParam String aluvccodigo,
			@RequestParam String aluvcpaterno,
			@RequestParam String aluvcmaterno,
			@RequestParam String aluvcnombre
	) {
		Alumno alu = new Alumno();
		alu.setAluvccodigo(aluvccodigo);
		alu.setAluvcpaterno(aluvcpaterno);
		alu.setAluvcmaterno(aluvcmaterno);
		alu.setAluvcnombre(aluvcnombre);
		alumnoRepositorio.save(alu);
		return alu.getAluicodigo();
	}
	
	@PutMapping("/cambiar")
	public @ResponseBody Integer editar(
			@RequestParam Integer aluicodigo,
			@RequestParam String aluvccodigo,
			@RequestParam String aluvcpaterno,
			@RequestParam String aluvcmaterno,
			@RequestParam String aluvcnombre
	) {
		Optional<Alumno> opt = alumnoRepositorio.findById(aluicodigo);
		if ( opt.isPresent() ) {
			Alumno alu = opt.get();
			alu.setAluvccodigo(aluvccodigo);
			alu.setAluvcpaterno(aluvcpaterno);
			alu.setAluvcmaterno(aluvcmaterno);
			alu.setAluvcnombre(aluvcnombre);
			try {
				alumnoRepositorio.save(alu);
				return 1;
			} catch ( Exception e ) {
				return -1;
			}
		}
		return 0;
	}
	
	@DeleteMapping("/borrar") 
	public @ResponseBody Integer borrar(@RequestParam Integer id) {
		Optional<Alumno> opt = alumnoRepositorio.findById(id);
		if ( opt.isPresent() ) {
			try {
				alumnoRepositorio.delete(opt.get());
				return 1;
			} catch ( Exception e ) {
				return -1;
			}
		}
		return 0;
	}
	*/
}
