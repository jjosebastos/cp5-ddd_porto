package org.motins.service.interfaces;

import org.motins.entity.cliente.PessoaJuridica;
import org.motins.exception.service.PessoaJuridicaServiceException;

import java.util.List;

public interface IPessoaJuridicaService {
    void create(PessoaJuridica pessoaJuridica) throws PessoaJuridicaServiceException;
    List<PessoaJuridica> listAll() throws PessoaJuridicaServiceException;
    void update(PessoaJuridica pessoaJuridica) throws PessoaJuridicaServiceException;
    void delete(int id) throws PessoaJuridicaServiceException;

}
