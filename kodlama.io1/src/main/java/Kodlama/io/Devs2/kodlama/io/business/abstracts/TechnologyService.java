package Kodlama.io.Devs2.kodlama.io.business.abstracts;

import java.util.List;

import Kodlama.io.Devs2.kodlama.io.business.request.technology.CreateTechnologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.UpdateTechonologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllTechnologyResponses;
import Kodlama.io.Devs2.kodlama.io.business.responses.TechnologyListResponses;
import Kodlama.io.Devs2.kodlama.io.entities.concretes.Technology;

public interface TechnologyService {

	List<GetAllTechnologyResponses> getAll();
	
	void add(CreateTechnologyRequest createTechnologyRequest);
	void update(UpdateTechonologyRequest updateTechonologyRequest,int id) throws Exception;
	void delete(DeleteTechnologyRequest deleteTechnologyRequest,int id);
	GetAllTechnologyResponses getOne(int id);
	
	
	Technology getTechnologyById(int id); // language managerdan teknolojı servıse erısıp id ye gore teknolojı almak için.
	
	   List<TechnologyListResponses> getTecnologyAll();
	
	
	}
