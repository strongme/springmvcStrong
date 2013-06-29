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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Inventory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inventory", catalog = "sakila")
public class Inventory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer inventoryId;
	private Store store;
	private Film film;
	private Timestamp lastUpdate;
	private Set<Rental> rentals = new HashSet<Rental>(0);

	// Constructors

	/** default constructor */
	public Inventory() {
	}

	/** minimal constructor */
	public Inventory(Store store, Film film, Timestamp lastUpdate) {
		this.store = store;
		this.film = film;
		this.lastUpdate = lastUpdate;
	}

	/** full constructor */
	public Inventory(Store store, Film film, Timestamp lastUpdate,
			Set<Rental> rentals) {
		this.store = store;
		this.film = film;
		this.lastUpdate = lastUpdate;
		this.rentals = rentals;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "inventory_id", unique = true, nullable = false)
	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id", nullable = false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id", nullable = false)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "inventory")
	public Set<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(Set<Rental> rentals) {
		this.rentals = rentals;
	}

}