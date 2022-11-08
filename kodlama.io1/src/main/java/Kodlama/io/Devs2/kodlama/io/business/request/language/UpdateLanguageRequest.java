package Kodlama.io.Devs2.kodlama.io.business.request.language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageRequest {

	private int id;
	private String  name;
}
