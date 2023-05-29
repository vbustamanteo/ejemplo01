package pe.edu.unmsm.ejemplo01.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.unmsm.ejemplo01.entidades.Alumno;
import pe.edu.unmsm.ejemplo01.repositorios.AlumnoRepositorio;

@Controller
@RequestMapping(path = "/alumno")
public class AlumnoControlador {
	@Autowired
	private AlumnoRepositorio alumnoRepositorio;
	
	@GetMapping("/todos")
	public @ResponseBody Iterable<Alumno> findAll() {
		return alumnoRepositorio.findAll();
	}
	
	@GetMapping("/por-codigo")
	public @ResponseBody Alumno codigo(@RequestParam String aluvccodigo) {
		Alumno alu = alumnoRepositorio.findByAluvccodigo(aluvccodigo);
		if ( alu != null ) {
			return alu;
		}
		return null;
	}
	
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
	
}
