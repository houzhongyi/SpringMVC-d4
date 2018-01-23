package icss.ys.user.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import icss.ys.user.controller.UserController;
import icss.ys.user.pojo.Users;

public class TestUser {
	@Test
	public void login(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController c = (UserController)ac.getBean("userController");
//		System.out.println(c.getService().updateUser(new Users("a888888","888888")));
//		System.out.println(c.getService().register(new Users("JACK", "888888")));
		List<Users> list = c.getService().showUsers();
		for (Users users : list) {
			System.out.println(users);
		}
		
		System.out.println(c.getService().login(new Users("TOM", "666666")));
	}
}
