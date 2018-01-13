package by.htp.itacademy.car.service;

import by.htp.itacademy.car.domain.entity.User;
import by.htp.itacademy.car.service.exception.ServiceNoSuchUserException;

public interface UserService {
	
	void logIn(User user) throws ServiceNoSuchUserException;
}
