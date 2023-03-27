package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage; //����������
	private int pageBlock; //[����][1][2][3][����]
	private int pageSize; //1�������� 5����
	private int totalA; //�ѱۼ�
	private StringBuffer pagingHTML;
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer(); //����
		
		int totalP = (totalA+(pageSize-1))/pageSize;//�� ��������
		
		int startPage = (currentPage-1)/pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if(endPage > totalP) endPage = totalP;
		
		if(startPage != 1)
			pagingHTML.append("<span id='paging' onclick='boardPaging(" + (startPage-1) + ")'>����</span>");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage)
				pagingHTML.append("<span id='currentPaging' onclick='boardPaging(" + i + ")'>" + i + "</span>");
			else
				pagingHTML.append("<span id='paging' onclick='boardPaging(" + i + ")'>" + i + "</span>");
		}
		
		if(endPage < totalP)
			pagingHTML.append("<span id='paging' onclick='boardPaging(" + (endPage+1) + ")'>����</span>");
	}
}
