package com.luiguilherme.desafiodevsuperior3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luiguilherme.desafiodevsuperior3.dto.ClientDTO;
import com.luiguilherme.desafiodevsuperior3.entities.Client;
import com.luiguilherme.desafiodevsuperior3.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).get();
		return new ClientDTO(client);		
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {		
		Page<Client> result = repository.findAll(pageable);
		return result.map(x -> new ClientDTO(x));
	}	
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {	
		Client entity = new Client();		
		copyDtoToEntity(dto,entity);		
		entity = repository.save(entity);		
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {	
			Client entity = repository.getReferenceById(id);		
			copyDtoToEntity(dto,entity);		
			entity = repository.save(entity);		
			return new ClientDTO(entity);
	}
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		// TODO Auto-generated method stub
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
}