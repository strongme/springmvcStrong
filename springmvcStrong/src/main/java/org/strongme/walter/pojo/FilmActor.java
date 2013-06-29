package org.strongme.walter.pojo;


import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FilmActor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_actor", catalog = "sakila")
public class FilmActor implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FilmActorId id;
	private Actor actor;
	private Film film;
	private Timestamp lastUpdate;
	// Constructors

	/** default constructor */
	public FilmActor() {
	}

	/** full constructor */
	public FilmActor(FilmActorId id, Actor actor, Film film,
			Timestamp lastUpdate) {
		this.id = id;
		this.actor = actor;
		this.film = film;
		this.lastUpdate = lastUpdate;
	}
	

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "actorId", column = @Column(name = "actor_id", nullable = false)),
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)) })
	public FilmActorId getId() {
		return this.id;
	}

	public void setId(FilmActorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "actor_id", nullable = false, insertable = false, updatable = false)
	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Column(name = "last_update", nullable = false, length = 19)
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}