package org.strongme.walter.pojo;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Language entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "language", catalog = "sakila")
public class Language implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short languageId;
	private String name;
	private Timestamp lastUpdate;

	// Constructors

	/** default constructor */
	public Language() {
	}

	/** minimal constructor */
	public Language(String name, Timestamp lastUpdate) {
		this.name = name;
		this.lastUpdate = lastUpdate;
	}
	
	

	public Language(Short languageId, String name, Timestamp lastUpdate) {
		super();
		this.languageId = languageId;
		this.name = name;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor *//*
	public Language(String name, Timestamp lastUpdate,
			Set<Film> filmsForOriginalLanguageId, Set<Film> filmsForLanguageId) {
		this.name = name;
		this.lastUpdate = lastUpdate;
		this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
		this.filmsForLanguageId = filmsForLanguageId;
	}*/

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "language_id", unique = true, nullable = false)
	public Short getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Short languageId) {
		this.languageId = languageId;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "last_update", nullable = false, length = 19)
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

/*	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "languageByOriginalLanguageId")
	public Set<Film> getFilmsForOriginalLanguageId() {
		return this.filmsForOriginalLanguageId;
	}

	public void setFilmsForOriginalLanguageId(
			Set<Film> filmsForOriginalLanguageId) {
		this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "languageByLanguageId")
	public Set<Film> getFilmsForLanguageId() {
		return this.filmsForLanguageId;
	}

	public void setFilmsForLanguageId(Set<Film> filmsForLanguageId) {
		this.filmsForLanguageId = filmsForLanguageId;
	}*/

}