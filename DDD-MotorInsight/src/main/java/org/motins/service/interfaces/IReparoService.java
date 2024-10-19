package org.motins.service.interfaces;

import org.motins.entity.reparo.Reparo;
import org.motins.exception.service.ReparoServiceException;

import java.util.List;

public interface IReparoService {
    void create(Reparo reparo) throws ReparoServiceException;
    List<Reparo> listAll() throws ReparoServiceException;
    void update(Reparo reparo) throws ReparoServiceException;
    void delete(int id) throws ReparoServiceException;

}
