package by.htp.itacademy.car.service;

import java.util.Map;

import by.htp.itacademy.car.domain.entity.Entity;
import by.htp.itacademy.car.service.exception.ServiceException;

/**
 * This is the service interface. The user of the interface has control over the database.
 * It has four methods.
 * 
 * @author Tsovak Palakian
*/

public interface EntityService {
	
	void insert(Entity entity) throws ServiceException;
	
	Map<Long, Entity> select(String query) throws ServiceException;
	
	void update(Entity entity) throws ServiceException;
	
	void delete(Entity entity) throws ServiceException;
}
