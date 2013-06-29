package org.strongme.walter.pojo;


import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Film entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film", catalog = "sakila")
@NamedQueries({
	@NamedQuery(name="filmsByCategory",query="SELECT f.filmId,f.languageId,f.title,f.description,f.releaseYear,f.rentalDuration,f.rentalRate,f.length,f.replacementCost,f.rating,f.specialFeatures,f.lastUpdate FROM Film f,org.strongme.walter.pojo.FilmCategory fc WHERE f.filmId=fc.id.filmId AND fc.id.categoryId=:categoryId ")
})
public class Film implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short filmId;
	private Short languageId;
	private String title;
	private String description;
	private Date releaseYear;
	private Short rentalDuration;
	private Double rentalRate;
	private Short length;
	private Double replacementCost;
	private String rating;
	private String specialFeatures;
	private Timestamp lastUpdate;
	private String language;
	
	// Constructors

	
	/** default constructor */
	public Film() {
	}
	
	public Film(Short filmId, Short languageId, String title,
			String description, Date releaseYear, Short rentalDuration,
			Double rentalRate, Short length, Double replacementCost,
			String rating, String specialFeatures, Timestamp lastUpdate) {
		super();
		this.filmId = filmId;
		this.languageId = languageId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.lastUpdate = lastUpdate;
	}



	public Film(Short filmId, String title, String description,
			Date releaseYear, Short rentalDuration, Double rentalRate,
			Short length, Double replacementCost, String rating,
			String specialFeatures, Timestamp lastUpdate, String language) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.lastUpdate = lastUpdate;
		this.language = language;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "film_id", unique = true, nullable = false)
	public Short getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Short filmId) {
		this.filmId = filmId;
	}

	@Column(name="language_id")
	public Short getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Short languageId) {
		this.languageId = languageId;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "release_year", length = 0)
	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Column(name = "rental_duration", nullable = false)
	public Short getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(Short rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	@Column(name = "rental_rate", nullable = false, precision = 4)
	public Double getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}

	@Column(name = "length")
	public Short getLength() {
		return this.length;
	}

	public void setLength(Short length) {
		this.length = length;
	}

	@Column(name = "replacement_cost", nullable = false, precision = 5)
	public Double getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	@Column(name = "rating", length = 5)
	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Column(name = "special_features", length = 54)
	public String getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Column(name = "last_update", nullable = false, length = 19)
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	


}