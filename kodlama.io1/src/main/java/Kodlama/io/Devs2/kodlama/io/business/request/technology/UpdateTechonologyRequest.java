package Kodlama.io.Devs2.kodlama.io.business.request.technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechonologyRequest {
	private String name;
	private int id;
}
