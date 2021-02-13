package com.devsuperior.dsclient.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dsclient.dto.ClientDTO;
import com.devsuperior.dsclient.entities.Client;
import com.devsuperior.dsclient.repositories.ClientRepository;
import com.devsuperior.dsclient.services.exceptions.DataBaseException;
import com.devsuperior.dsclient.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPage(PageRequest pageRequest) {

		Page<Client> list = this.clientRepository.findAll(pageRequest);

		return list.map(entity -> new ClientDTO(entity));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {

		Optional<Client> obj = this.clientRepository.findById(id);

		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {

		Client entity = new Client();
		this.copyDtoToEntity(dto, entity);

		this.clientRepository.save(entity);

		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {

		try {

			Client entity = this.clientRepository.getOne(id);
			this.copyDtoToEntity(dto, entity);
			entity = this.clientRepository.save(entity);

			return new ClientDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {

		try {

			this.clientRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}catch  (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}

	private void copyDtoToEntity(ClientDTO dto, Client entity) {

		entity.setBirthDate(dto.getBirthDate());
		entity.setCpf(dto.getCpf());
		entity.setChildren(dto.getChildren());
		entity.setIncome(dto.getIncome());
		entity.setName(dto.getName());
	}
}