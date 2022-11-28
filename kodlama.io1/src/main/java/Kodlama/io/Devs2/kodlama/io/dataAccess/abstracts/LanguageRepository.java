package Kodlama.io.Devs2.kodlama.io.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Kodlama.io.Devs2.kodlama.io.entities.concretes.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
	
    boolean existsByName(String name);
	
}
