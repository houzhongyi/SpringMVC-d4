package icss.ys.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icss.ys.user.dao.UsersDao;
import icss.ys.user.pojo.Users;
@Service
public class UsersService {
	@Autowired
	private UsersDao dao;
	
	public UsersDao getDao() {
		return dao;
	}
	public void setDao(UsersDao dao) {
		this.dao = dao;
	}
	/**
	 * 
	 * @param u
	 * @return 0 没有该用户 1 可以成功  2 密码错误
	 */
	
	public int login(Users u){
		//System.out.println("事务开始，日志信息： 登录数据" + new Date());
		//user数据库的数据
		Users user = dao.queryByUsername(u.getUsername());
		if(user != null){
			if(user.getPassword().equals(u.getPassword())){
				return 1;
			}else{
				return 2;
			}
		}else{
			return 0;
		}			
	}

	/**
	 * 注册
	 */
	public  boolean register(Users user){
		if(dao.insertUser(user) > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public int updateUser(Users user){
		return dao.updateUser(user);
	}

	/**
	 * 查询所有用户
	 */
	public List<Users> showUsers(){
		return dao.queryAllUsers();
	}
}
