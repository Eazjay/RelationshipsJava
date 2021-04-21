package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalP = personRepository.findById(id);
		if(optionalP.isPresent()) {
			return optionalP.get();
		}
		else {
			return null;
		}
	}
	
	
	public Person createPerson(Person p) {
		return personRepository.save(p);
	}
	
	
	public void deletePerson(Long id) {
		Person p = findPerson(id);
		personRepository.delete(p);
	}
	
	public Person updatePerson(Person p) {
		return personRepository.save(p);
	}
}
