package Kodlama.io.Devs2.kodlama.io.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs2.kodlama.io.business.abstracts.LanguageService;
import Kodlama.io.Devs2.kodlama.io.business.abstracts.TechnologyService;
import Kodlama.io.Devs2.kodlama.io.business.request.language.CreateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.DeleteLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.UpdateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllLanguageResponses;
import Kodlama.io.Devs2.kodlama.io.business.responses.LanguageListResponses;
import Kodlama.io.Devs2.kodlama.io.business.responses.TechnologyListResponses;
import Kodlama.io.Devs2.kodlama.io.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs2.kodlama.io.entities.concretes.Language;
import Kodlama.io.Devs2.kodlama.io.entities.concretes.Technology;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	private TechnologyService technologyService; 
	

	public LanguageManager(LanguageRepository languageRepository,TechnologyService technologyService) {
		this.languageRepository = languageRepository;
		this.technologyService=technologyService;
		
	}

	@Override
	public List<GetAllLanguageResponses> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponses> languageResponses = new ArrayList<>();

		for (Language language : languages) {
			GetAllLanguageResponses responsesItem = new GetAllLanguageResponses();
			responsesItem.setId(language.getId());
			responsesItem.setName(language.getName());

		}
		return languageResponses;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {

		nameControl(createLanguageRequest.getName()); 
		
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		List<Technology> technologies= new ArrayList<>();
		for (Integer techologyId : createLanguageRequest.getTechnologyIds()) {// teknolojıye ıd ye goreservısten teknolojı  isteyecez
			Technology technology= this.technologyService.getTechnologyById(techologyId);// teknoljı servısten ıde gore  teknolojı getırdık.suan artık elımızde teknolojı var .
			technologies.add(technology);
		}
		
		language.setTechnology(technologies);//dile teknolojı ekledık.
		this.languageRepository.save(language);

	}
	private  void nameControl(String name) throws Exception {
		if(this.languageRepository.existsByName(name)) {
		throw new Exception("hata");
		
	}
	}
	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest,int id) throws Exception {
		
		Optional<Language> optional=languageRepository.findById(id);
		if(optional.isEmpty()) {
			throw new Exception("Hata");
			
		}
		
			Language language= optional.get();
			language.setName(updateLanguageRequest.getName());
			languageRepository.save(language);
			
			
		
		
	}

	@Override
	public GetAllLanguageResponses getOne(int id) {
		
		Optional<Language> optional=languageRepository.findById(id);
		if(!optional.isPresent()) {
			throw new RuntimeException("hata");
		}
		GetAllLanguageResponses getAllLanguageResponses=new GetAllLanguageResponses();
		Language language= optional.get();
		getAllLanguageResponses.setName(language.getName());
		getAllLanguageResponses.setId(language.getId());
		return getAllLanguageResponses;
		
	}

	
	
	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest,int id) {
	
	this.languageRepository.deleteById(id);
		
	}

	@Override
	public List<LanguageListResponses> getLanguageAll() {
		
		List<Language> languageList= this.languageRepository.findAll();
		List<LanguageListResponses> languageListResponses= new ArrayList<>();
		List<TechnologyListResponses> technologyListResponses= new ArrayList<>();
		for (Language language: languageList) {
			LanguageListResponses languageListResponse = new LanguageListResponses();
			languageListResponse.setId(language.getId());
			languageListResponse.setName(language.getName());
			for(Technology technology: language.getTechnology()) {
				TechnologyListResponses technologyListResponse= new TechnologyListResponses();
				Technology technologyById = this.technologyService.getTechnologyById(technology.getId());
				technologyListResponse.setId(technology.getId());
				technologyListResponse.setName(technology.getName());
				technologyListResponses.add(technologyListResponse);
				
				
			}
			languageListResponse.setTechnologyListResponses(technologyListResponses);
			languageListResponses.add(languageListResponse);
			
			
		}
		
		
		
		return languageListResponses;
	}



}
