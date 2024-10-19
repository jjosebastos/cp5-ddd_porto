package org.motins.service.interfaces;

import org.motins.entity.seguradora.Seguradora;
import org.motins.exception.service.SeguradoraServiceException;

import java.util.List;

public interface ISeguradoraService {
    void create(Seguradora seguradora) throws SeguradoraServiceException;
    List<Seguradora> listAll() throws SeguradoraServiceException;
    void update(Seguradora seguradora) throws SeguradoraServiceException;
    void delete(int id) throws SeguradoraServiceException;
}
