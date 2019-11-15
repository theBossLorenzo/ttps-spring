package model;


import java.util.Date;

import clasesDAO.EventDAO;
import clasesDAO.PetDAO;
import clasesDAO.UserDAO;

public class Main {

	public static void main(String[] args) {
		Date today = new Date();
		Vet vet1 = new Vet("Carlos", "1234", "Carlos", "4273795", "carlos@yahoo.com", "el perro feliz", "calle falsa");
		Pet pet1 = new Pet("Olaf",today , "Perro", "Mezcla", "Masculino", "Negro", "Ninguna", vet1 );
		Visit visita = new Visit(vet1, today, 45, "Caca", "Tenia mucha caca", "Cantar una cancion");
		UserDAO v = new UserDAO();
		PetDAO p = new PetDAO();
		EventDAO e = new EventDAO();
		v.persist(vet1);
		p.persist(pet1);
		e.persist(visita);

	}

}
