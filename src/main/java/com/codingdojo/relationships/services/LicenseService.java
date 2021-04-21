package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalL = licenseRepository.findById(id);
		if(optionalL.isPresent()) {
			return optionalL.get();
		}
		else {
			return null;
		}
	}
	
	public License createLicense(License license) {
        License newLicense = licenseRepository.save(license);
        String licenseNumber = "" + (license.getId() / 100000);
        licenseNumber += "" + (license.getId() / 10000);
        licenseNumber += "" + (license.getId() / 1000);
        licenseNumber += "" + (license.getId() / 100);
        licenseNumber += "" + (license.getId() / 10);
        licenseNumber += "" + (license.getId() % 10);
        newLicense.setNumber(licenseNumber);
        licenseRepository.save(newLicense);
        return newLicense;
    }
	
	public void deleteLicense(Long id) {
		License l = findLicense(id);
		licenseRepository.delete(l);
	}
	
	public License updateLicense(License l) {
		return licenseRepository.save(l);
	}
}
