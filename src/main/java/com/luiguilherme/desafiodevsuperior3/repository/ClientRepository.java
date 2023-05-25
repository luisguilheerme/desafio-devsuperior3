package com.luiguilherme.desafiodevsuperior3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luiguilherme.desafiodevsuperior3.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
