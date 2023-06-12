package pe.edu.unmsm.ejemplo01.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "alumno")
public class Alumno {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alu_iCodigo")
	private Integer aluicodigo;

	@Column(name = "alu_vcCodigo")
	private String aluvccodigo;
	
	@Column(name = "alu_vcPaterno")
	private String aluvcpaterno;
	
	@Column(name = "alu_vcMaterno")
	private String aluvcmaterno;
	
	@Column(name = "alu_vcNombre")
	private String aluvcnombre;

	@Transient
	private Integer puerto;
	
	
	public Integer getAluicodigo() {
		return aluicodigo;
	}

	public void setAluicodigo(Integer aluicodigo) {
		this.aluicodigo = aluicodigo;
	}

	public String getAluvccodigo() {
		return aluvccodigo;
	}

	public void setAluvccodigo(String aluvccodigo) {
		this.aluvccodigo = aluvccodigo;
	}

	public String getAluvcpaterno() {
		return aluvcpaterno;
	}

	public void setAluvcpaterno(String aluvcpaterno) {
		this.aluvcpaterno = aluvcpaterno;
	}

	public String getAluvcmaterno() {
		return aluvcmaterno;
	}

	public void setAluvcmaterno(String aluvcmaterno) {
		this.aluvcmaterno = aluvcmaterno;
	}

	public String getAluvcnombre() {
		return aluvcnombre;
	}

	public void setAluvcnombre(String aluvcnombre) {
		this.aluvcnombre = aluvcnombre;
	}

	public Integer getPuerto() {
		return puerto;
	}

	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}

	
}
