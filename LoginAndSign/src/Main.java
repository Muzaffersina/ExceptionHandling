import business.abstracts.UserService;
import business.concretes.UserManager;
import core.exceptions.BusinessException;
import dataAccess.concretes.UserHibernateDao;
import entities.concrete.User;

public class Main {

	public static void main(String[] args) {
		UserService userService1 = new UserManager(new UserHibernateDao());
		User user1 = new User("SSQ", "SSE", "123@gmail.com", "123456");
		User user2 = new User("SS", "SS", "1232@gmail.com", "123456");
		try {
			userService1.add(user1);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		finally {
			System.out.println("...");
		}
		try {
			userService1.add(user2);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		finally {
			System.out.println("...");
		}
	}

}