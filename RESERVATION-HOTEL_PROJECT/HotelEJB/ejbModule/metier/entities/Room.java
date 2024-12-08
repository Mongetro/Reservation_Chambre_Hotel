package metier.entities;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Room implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id //Annot for ID as primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Annot for auto-generating ID
	@Column(name="ID_ROOM") //Annot of fields déclaration .
	private int idRoom; //déclaration of id
	@Column(name="NBOFBEDS")
	private int nbOfBeds;
	public Room(int idRoom, int nbOfBeds, double pricePerNight, String etat) {
		super();
		this.idRoom = idRoom;
		this.nbOfBeds = nbOfBeds;
		this.pricePerNight = pricePerNight;
		this.etat = etat;
	}

	@Column(name="PRICEPERNIGHT")
	private double pricePerNight;
	
	@OneToOne(mappedBy="room")
	private Booking booking;
	
	private String etat;
	// Constructors
	public Room() {
		super();
	}
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}


	// Getters and Setters
	
	public Room(int nbOfBeds, double pricePerNight, String etat) {
		super();
		this.nbOfBeds = nbOfBeds;
		this.pricePerNight = pricePerNight;
		this.etat = etat;
	}

	public Room(int idRoom) {
		super();
		this.idRoom = idRoom;
	}

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getNbOfBeds() {
		return nbOfBeds;
	}

	public void setNbOfBeds(int nbOfBeds) {
		this.nbOfBeds = nbOfBeds;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
}