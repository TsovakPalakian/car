package by.htp.itacademy.car.dao;

import java.util.Map;

/**
 * The user of the interface has control over the database.
 * 
 * @author Tsovak Palakian
*/

import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.domain.entity.Entity;

public interface EntityDao {
	
	Map<Long, Entity> select(Entity entity) throws DaoException;
	
	boolean insert(Entity entity) throws DaoException;
	
	boolean update(Entity entity) throws DaoException;
	
	boolean delete(Entity entity) throws DaoException;
	
}
