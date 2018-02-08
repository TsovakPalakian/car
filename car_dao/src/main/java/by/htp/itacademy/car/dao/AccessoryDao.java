package by.htp.itacademy.car.dao;

import java.util.List;

import by.htp.itacademy.car.dao.exception.DaoException;
import by.htp.itacademy.car.domain.entity.Accessory;

public interface AccessoryDao extends IDao<Accessory> {
	
	List<Accessory> getAll() throws DaoException;
}
