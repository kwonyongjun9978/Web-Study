package board.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private int seq;
	private String logtime;
	
	private String name;
	private String email;
	private String id;
	private String subject;
	private String content;
}
