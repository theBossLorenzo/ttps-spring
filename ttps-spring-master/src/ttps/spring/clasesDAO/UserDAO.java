package clasesDAO;

import interfacesDAO.UserDAOInterface;
import model.User;

public class UserDAO extends GenericDao<User> implements UserDAOInterface {
	
	public UserDAO() {
		GenericDAOHibernateJPA(User.class);
	}

}
