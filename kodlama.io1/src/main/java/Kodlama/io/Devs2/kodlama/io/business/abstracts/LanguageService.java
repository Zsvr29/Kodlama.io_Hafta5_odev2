package Kodlama.io.Devs2.kodlama.io.business.abstracts;

import java.util.List;

import Kodlama.io.Devs2.kodlama.io.business.request.language.CreateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.DeleteLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.UpdateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllLanguageResponses;
import Kodlama.io.Devs2.kodlama.io.business.responses.LanguageListResponses;

public interface LanguageService {
	
    List<GetAllLanguageResponses> getAll();
  
   void add(CreateLanguageRequest createLanguageRequest) throws Exception;
   void update(UpdateLanguageRequest updateLanguageRequest,int id) throws Exception;
   void delete(DeleteLanguageRequest deleteLanguageRequest,int id);
   GetAllLanguageResponses getOne(int id);
   
   List<LanguageListResponses> getLanguageAll();
   

    
    
   
}


