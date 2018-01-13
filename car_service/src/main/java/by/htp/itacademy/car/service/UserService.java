package by.htp.itacademy.car.service;

import java.util.List;

import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.exception.ServiceException;
import by.htp.itacademy.car.service.exception.ServiceNoSuchUserException;

public interface UserService {
	
	List<User> logIn(User user) throws ServiceNoSuchUserException;
	
	boolean signUp(User user) throws ServiceException;

	boolean removeUser(User user) throws ServiceException;
	
	boolean updateUserData(User user) throws ServiceException;
	
	List<User> getUser(List<String> conditions) throws ServiceNoSuchUserException;
	
}
