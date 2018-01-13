package by.htp.itacademy.car.service;

import java.util.List;

import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.exception.ServiceException;
import by.htp.itacademy.car.service.exception.ServiceNoSuchUserException;

public interface UserService {
	
	User logIn(User user) throws ServiceNoSuchUserException;
	
	void signUp(User user) throws ServiceException;

	void removeUser(User user) throws ServiceException;
	
	void updateUser(User user) throws ServiceException;
	
	<V> List<User> getUser(V value) throws ServiceNoSuchUserException;
}
