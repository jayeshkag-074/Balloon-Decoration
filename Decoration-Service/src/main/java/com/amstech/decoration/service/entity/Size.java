package com.amstech.decoration.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the size database table.
 * 
 */
@Entity
@NamedQuery(name="Size.findAll", query="SELECT s FROM Size s")
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Decoration
	@OneToMany(mappedBy="size")
	private List<Decoration> decorations;

	public Size() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Decoration> getDecorations() {
		return this.decorations;
	}

	public void setDecorations(List<Decoration> decorations) {
		this.decorations = decorations;
	}

	public Decoration addDecoration(Decoration decoration) {
		getDecorations().add(decoration);
		decoration.setSize(this);

		return decoration;
	}

	public Decoration removeDecoration(Decoration decoration) {
		getDecorations().remove(decoration);
		decoration.setSize(null);

		return decoration;
	}

}