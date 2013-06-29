package org.strongme.walter.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FilmText entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_text", catalog = "sakila")
public class FilmText implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short filmId;
	private String title;
	private String description;

	// Constructors

	/** default constructor */
	public FilmText() {
	}

	/** minimal constructor */
	public FilmText(Short filmId, String title) {
		this.filmId = filmId;
		this.title = title;
	}

	/** full constructor */
	public FilmText(Short filmId, String title, String description) {
		this.filmId = filmId;
		this.title = title;
		this.description = description;
	}

	// Property accessors
	@Id
	@Column(name = "film_id", unique = true, nullable = false)
	public Short getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}