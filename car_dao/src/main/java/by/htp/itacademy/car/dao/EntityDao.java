package by.htp.itacademy.car.dao;

/**
 * The user of the interface has control over the database.
 * 
 * @author Tsovak Palakian
*/

import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.domain.entity.Entity;

public interface EntityDao {
	
	Entity select(String query) throws DaoException;
	
	void insert(Entity entity) throws DaoException;
	
	void update(Entity entity) throws DaoException;
	
	void delete(Entity entity) throws DaoException;
	
}
