package Kodlama.io.Devs2.kodlama.io.business.abstracts;

import java.util.List;

import Kodlama.io.Devs2.kodlama.io.business.request.language.CreateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.DeleteLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.UpdateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllLanguageResponses;
import Kodlama.io.Devs2.kodlama.io.entities.concretes.Language;

public interface LanguageService {
	
    List<GetAllLanguageResponses> getAll();
    Language getById(int id);
    void add(CreateLanguageRequest createLanguageRequest);
   
   
	void update(UpdateLanguageRequest updateLanguageRequest);
	void delete(DeleteLanguageRequest deleteLanguageRequest);
    
    
    
   
}


