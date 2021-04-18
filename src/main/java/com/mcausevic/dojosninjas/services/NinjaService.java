package com.mcausevic.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mcausevic.dojosninjas.models.Ninja;
import com.mcausevic.dojosninjas.repos.NinjaRepo;



@Service
public class NinjaService {
private final NinjaRepo ninjaRepo;
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	public List<Ninja>allNinjas(){
		return ninjaRepo.findAll();
	}
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	public Ninja findNinja(Long id) {
		Optional<Ninja>optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
	}
}
	
