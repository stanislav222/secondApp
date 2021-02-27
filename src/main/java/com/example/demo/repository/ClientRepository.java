package com.example.demo.repository;


import com.example.demo.model.Client;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CouchbaseRepository<Client, Long> {
}
