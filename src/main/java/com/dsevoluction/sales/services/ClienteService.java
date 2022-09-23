package com.dsevoluction.sales.services;

import com.dsevoluction.sales.entities.Cliente;
import com.dsevoluction.sales.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(RuntimeException::new);
    }

    public Cliente insert(Cliente cliente){
        return repository.save(cliente);
    }

    public void delete(Integer id){
        Cliente obj = repository.getReferenceById(id);
        repository.delete(obj);
    }

    public Cliente upDate(Integer id, Cliente cliente) {
        Cliente obj = repository.getReferenceById(id);
        upDateData(obj, cliente);
        repository.save(obj);
        return obj;
    }
    public void upDateData(Cliente obj, Cliente cliente){
        obj.setName(cliente.getName());
    }

}
