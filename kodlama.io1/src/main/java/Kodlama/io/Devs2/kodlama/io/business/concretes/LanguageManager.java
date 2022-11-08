package Kodlama.io.Devs2.kodlama.io.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Kodlama.io.Devs2.kodlama.io.business.abstracts.LanguageService;
import Kodlama.io.Devs2.kodlama.io.business.request.language.CreateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.DeleteLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.UpdateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllLanguageResponses;
import Kodlama.io.Devs2.kodlama.io.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs2.kodlama.io.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguageResponses> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponses> languageResponses = new ArrayList<GetAllLanguageResponses>();

		for (Language language : languages) {
			GetAllLanguageResponses responsesItem = new GetAllLanguageResponses();
			responsesItem.setId(language.getId());
			responsesItem.setName(language.getName());

		}
		return languageResponses;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {

		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		this.languageRepository.save(language);

	}

	@Override
	public Language getById(int id) {

		return languageRepository.getById(id);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {

		Language language = languageRepository.getById(updateLanguageRequest.getId());
		language.setName(updateLanguageRequest.getName());
		languageRepository.save(language);

	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageRepository.deleteById(deleteLanguageRequest.getId());
	}

}
