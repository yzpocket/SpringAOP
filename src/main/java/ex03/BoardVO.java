package ex03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본생성자
@AllArgsConstructor
public class BoardVO {
	private int num;
	private String title;
	private String name;
	
}
