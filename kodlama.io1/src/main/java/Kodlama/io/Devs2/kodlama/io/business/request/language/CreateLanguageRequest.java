package Kodlama.io.Devs2.kodlama.io.business.request.language;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageRequest {
	private String name;
	private List<Integer> technologyIds; //dıle eklenmek ısteyen   teknolojılerın ıd lerını aldık.

}
