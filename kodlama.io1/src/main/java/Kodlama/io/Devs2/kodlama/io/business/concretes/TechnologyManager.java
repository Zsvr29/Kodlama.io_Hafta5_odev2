package Kodlama.io.Devs2.kodlama.io.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs2.kodlama.io.business.abstracts.TechnologyService;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.CreateTechnologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.UpdateTechonologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllTechnologyResponses;
import Kodlama.io.Devs2.kodlama.io.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs2.kodlama.io.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;

	public TechnologyManager(TechnologyRepository technologyRepository) {
		this.technologyRepository = technologyRepository;
	}

	@Override
	public List<GetAllTechnologyResponses> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponses> technologyResponses = new ArrayList<GetAllTechnologyResponses>();
		for (Technology technology : technologies) {
			GetAllTechnologyResponses reponsesItem = new GetAllTechnologyResponses();
			reponsesItem.setId(technology.getId());
			reponsesItem.setName(technology.getName());

		}
		return technologyResponses;

	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		this.technologyRepository.save(technology);

	}

	

	@Override
	public void update(UpdateTechonologyRequest updateTechonologyRequest, int id) throws Exception {
		Optional<Technology> optional=technologyRepository.findById(id);
		if(optional.isEmpty()) {
			throw new Exception("hata");
			
		}
		if(optional.isPresent()) {
			
			Technology technology= optional.get();
			technology.setName(updateTechonologyRequest.getName());
			this.technologyRepository.save(technology);
					
		}
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest, int id) {
		this.technologyRepository.deleteById(id);
		
	}

	@Override
	public GetAllTechnologyResponses getOne(int id) {
		
		Optional<Technology> optional=technologyRepository.findById(id);
		if(optional.isPresent()) {
			GetAllTechnologyResponses getAllTechnologyResponses= new GetAllTechnologyResponses();
			Technology technology=optional.get();
			getAllTechnologyResponses.setName(technology.getName());
			getAllTechnologyResponses.setId(technology.getId());
			return  getAllTechnologyResponses;
			
		}
		return null;
	}

	

}
