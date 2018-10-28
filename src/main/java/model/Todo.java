package model;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "usuario")
public class Todo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "id")
	private Integer id;

	@XmlElement(name = "titulo")
	private String titulo;
	
	@XmlElement(name = "descricao")
	private String descricao;
	
	@XmlElement(name = "status")
	private Integer status;
	
	public Todo(String titulo, String descricao, Integer status) {
		setTitulo(titulo);
		setDescricao(descricao);
		setStatus(status);
	}

	public Todo(){
		this("","",0);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
	
		
}
