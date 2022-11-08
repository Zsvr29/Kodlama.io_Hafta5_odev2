package Kodlama.io.Devs2.kodlama.io.business.concretes;

import java.util.ArrayList;
import java.util.List;

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
	public Technology getById(int id) {

		return technologyRepository.getById(id);
	}

	@Override
	public void update(UpdateTechonologyRequest updateTechonologyRequest) {
		Technology technology = technologyRepository.getById(updateTechonologyRequest.getId());
		technology.setName(updateTechonologyRequest.getName());
		technologyRepository.save(technology);

	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyRepository.deleteById(deleteTechnologyRequest.getId());

	}

}
