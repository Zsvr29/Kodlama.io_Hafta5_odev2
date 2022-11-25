package Kodlama.io.Devs2.kodlama.io.business.abstracts;

import java.util.List;

import Kodlama.io.Devs2.kodlama.io.business.request.language.CreateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.DeleteLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.UpdateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllLanguageResponses;

public interface LanguageService {
	
    List<GetAllLanguageResponses> getAll();
  
   void add(CreateLanguageRequest createLanguageRequest);
   void update(UpdateLanguageRequest updateLanguageRequest,int id) throws Exception;
   void delete(DeleteLanguageRequest deleteLanguageRequest,int id);
   GetAllLanguageResponses getOne(int id);
   

    
    
   
}


