package metier;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.HashPassword;
import metier.entities.UserRole;
import metier.entities.UtilisateurEntity;

import metier.entities.Booking;
import metier.entities.Room;

@Stateless(name="HT")
public class HotelEJBImpl implements HotelRemote, HotelLocal {
	@PersistenceContext
	private EntityManager em;



	// Methodes for Room class
	@Override
	public void addRoom(Room rm) {
		em.persist(rm);
	}

	@Override
	public Room getRoom(int idRoom) {
		Room rm=em.find(Room.class, idRoom);
		//if(rm==null) throw new RuntimeException("Chambre introuvable");
		return rm;
	}
	
	@Override
	public void updateRoom(Room rm) {
		em.merge(rm);
	}

	@Override
	public List<Room> listRooms() {
		Query req=em.createQuery("select rm FROM Room rm");
		 List<Room> listRooms=req.getResultList();
		 return listRooms;
	}

	@Override
	public List<Room> listRooms(String etat) {
		Query req=em.createQuery("select rm FROM Room rm WHERE rm.etat=:x");
		req.setParameter("x", etat);
		 List<Room> listRooms=req.getResultList();
		 return listRooms;
	}
	
	@Override
	public void deleteRoom(int idRoom) {
		// TODO Auto-generated method stub
		em.remove(getRoom(idRoom));
	}

	@Override
	public void addBook(Booking bk) {
		em.persist(bk);
        Room r=getRoom(bk.getRoom().getIdRoom());
		r.setEtat("NonDisponible");				
		em.merge(r);
	}

	@Override
	public Booking getBook(Long idBook) {
		Booking bk=em.find(Booking.class, idBook);
		if(bk==null) throw new RuntimeException("Réservation introuvable");
		return bk;
	}

	@Override
	public void updateBook(Booking bk) {
		em.merge(bk);
	}

	@Override
	public List<Booking> listBooks() {
		Query req=em.createQuery("select bk FROM Booking bk");
		 List<Booking> listBooks=req.getResultList();
		 return listBooks;
	}
	
	
	@Override
	public List<Booking> listBooks(String guestName) {
		Query req=em.createQuery("SELECT bk FROM Booking bk WHERE bk.guestName=:x");
		req.setParameter("x", guestName);
		List<Booking> listBooks=req.getResultList();
		return listBooks;
	}
	//UtilisateurEJBImpl*****************************************************************************
	@Override
	public void AddUtilisateur(UtilisateurEntity u, UserRole ur) {
		u.setUtilisateurMotdepasse(HashPassword.hashPassword(u.getUtilisateurMotdepasse()));
		//u.setiDuserRole(ur);
		em.persist(u);
		em.persist(ur);
	}

	@Override
	public void UpdateUtilisateur(UtilisateurEntity u) {
		em.merge(u);
	}

	@Override
	public UtilisateurEntity FindOneUtilisateur(String id) {
		// TODO Auto-generated method stub
		UtilisateurEntity u = em.find(UtilisateurEntity.class, id);
		return u;
	}

	@Override
	public UtilisateurEntity FindOneUtilisateurBy(String MC) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<UtilisateurEntity> GetAllUtilisateur() {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select u from UtilisateurEntity u");
		return q.getResultList();
	}

	@Override
	public void DeleteUtilisateur(String id) {
		// TODO Auto-generated method stub
		UtilisateurEntity u =em.find(UtilisateurEntity.class, id);
		if(u==null) throw new RuntimeException("Utilisateur Not Found");
		em.remove(u);
	}



}
