package com.example.testeSantander.repository;

import com.example.testeSantander.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer>, CrudRepository<Cliente, Integer> {
}
