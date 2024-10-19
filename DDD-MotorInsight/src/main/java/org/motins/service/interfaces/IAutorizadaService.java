package org.motins.service.interfaces;

import org.motins.entity.autorizada.Autorizada;
import org.motins.exception.dao.AutorizadaDaoException;
import org.motins.exception.service.AutorizadaServiceException;

import java.sql.SQLException;
import java.util.List;

public interface IAutorizadaService {

    void create(Autorizada autorizada) throws AutorizadaServiceException;
    List<Autorizada> listAll() throws AutorizadaDaoException, SQLException;
    void update(Autorizada autorizada) throws AutorizadaServiceException;
    void delete(int id) throws AutorizadaServiceException;


}
