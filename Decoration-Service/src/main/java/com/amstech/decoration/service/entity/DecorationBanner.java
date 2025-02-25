package com.amstech.decoration.service.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the decoration_banner database table.
 * 
 */
@Entity
@Table(name="decoration_banner")
@NamedQuery(name="DecorationBanner.findAll", query="SELECT d FROM DecorationBanner d")
public class DecorationBanner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String url;

	//bi-directional many-to-one association to Decoration
	@OneToMany(mappedBy="decorationBanner")
	private List<Decoration> decorations;

	public DecorationBanner() {
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Decoration> getDecorations() {
		return this.decorations;
	}

	public void setDecorations(List<Decoration> decorations) {
		this.decorations = decorations;
	}

	public Decoration addDecoration(Decoration decoration) {
		getDecorations().add(decoration);
		decoration.setDecorationBanner(this);

		return decoration;
	}

	public Decoration removeDecoration(Decoration decoration) {
		getDecorations().remove(decoration);
		decoration.setDecorationBanner(null);

		return decoration;
	}

}