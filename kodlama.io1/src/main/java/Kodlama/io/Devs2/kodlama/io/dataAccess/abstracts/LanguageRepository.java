package Kodlama.io.Devs2.kodlama.io.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs2.kodlama.io.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
	

	
}
