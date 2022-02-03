package business.abstracts;

import java.util.ArrayList;

import core.exceptions.BusinessException;
import entities.concrete.User;

public interface UserService {

	void add(User users) throws BusinessException;
	void update(User users) throws BusinessException;
	void delete(User users)throws BusinessException;
	ArrayList<User> getAll();
}