package clasesDAO;
import clasesDAO.GenericDao;
import model.Pet;

public class PetDAO extends GenericDao<Pet> {
	
	public PetDAO() {
		GenericDAOHibernateJPA(Pet.class);
	}


}
