package clasesDAO;
import model.Event;

public class EventDAO extends GenericDao<Event> {

	public EventDAO() {
		GenericDAOHibernateJPA(Event.class);
	}

}
