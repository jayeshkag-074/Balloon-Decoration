package com.amstech.decoration.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the colour database table.
 * 
 */
@Entity
@NamedQuery(name="Colour.findAll", query="SELECT c FROM Colour c")
public class Colour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Decoration
	@OneToMany(mappedBy="colour")
	private List<Decoration> decorations;

	public Colour() {
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
		decoration.setColour(this);

		return decoration;
	}

	public Decoration removeDecoration(Decoration decoration) {
		getDecorations().remove(decoration);
		decoration.setColour(null);

		return decoration;
	}

}