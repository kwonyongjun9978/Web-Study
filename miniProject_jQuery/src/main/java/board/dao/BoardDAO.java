package board.dao;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	private SqlSessionFactory sqlSessionFactory;
	
	private static BoardDAO boardDAO = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	public BoardDAO() {
		//byte����
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	public void boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("boardSQL.boardWrite", map);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<BoardDTO> boardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		return list;
	}
	
	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}
	
	public BoardDTO getBoard(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", seq);
		sqlSession.close();
		return boardDTO;
	}
	
	public void boardReply(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//����
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.getBoard", Integer.parseInt(map.get("pseq")));
		
		//step update
		//update board set step=step+1 where ref = ����ref and step>����step
		sqlSession.update("boardSQL.boardReply1", boardDTO);
		
		//insert
		//���ref = ����ref
		//���lev = ����lev + 1
		//���step = ����step + 1
		//Map���� id, name, email, subject, content, pseq�� ��ƿԴ�, �߰��� ref, lev, step �־���
		map.put("ref", boardDTO.getRef()+"");
		map.put("lev", boardDTO.getLev()+1+"");
		map.put("step", boardDTO.getStep()+1+"");
		sqlSession.insert("boardSQL.boardReply2", map);
		
		//reply update
		//update board set reply=reply+1 where seq=���۹�ȣ
		sqlSession.update("boardSQL.boardReply3", boardDTO.getSeq());
		
		sqlSession.commit();
		sqlSession.close();
	}	
}
