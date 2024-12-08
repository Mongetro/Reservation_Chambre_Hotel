package metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Booking implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id //Annot for ID as primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Annot for auto-generating ID
	@Column(name="ID_BOOK") //Annot of fields déclaration .
	private Long idBook; //déclaration of id
	@Column(name="firstname")
	private String firstname;
	@Column(name="Lastname")
	private String lastname;
	@Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
	public Booking(Long idBook, String firstname, String lastname, Date startDate, Date endDate, double price,
			Room room) {
		super();
		this.idBook = idBook;
		this.firstname = firstname;
		this.lastname = lastname;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.room = room;
	}

	@Column(name="PRICE")
	private double price;
	
	@OneToOne
	@JoinColumn(name="Room")
	private Room room;
	
	
	



	public Booking(String firstname, String lastname, Date startDate, Date endDate, double price,
			Room room) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.room = room;
	}



	public Room getRoom() {
		return room;
	}



	public void setRoom(Room room) {
		this.room = room;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	
	// Constructors
	public Booking() {
		super();
	}
	


	// Getters and Setters
	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
