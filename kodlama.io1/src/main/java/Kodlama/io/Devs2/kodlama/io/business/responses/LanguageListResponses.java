package Kodlama.io.Devs2.kodlama.io.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageListResponses {
	
	private int id;
	private String name;
	List<TechnologyListResponses> technologyListResponses;
	

}
