package by.htp.itacademy.car.service;

import java.util.Map;

import by.htp.itacademy.car.domain.entity.Entity;

/**
 * This is the service interface. The user of the interface has control over the database.
 * It has four methods.
 * 
 * @author Tsovak Palakian
*/

public interface EntityService {
	
	void insert(Entity entity);
	
	Map<Long, Entity> select(String query);
	
	void update(Entity entity);
	
	void delete(Entity entity);
}
