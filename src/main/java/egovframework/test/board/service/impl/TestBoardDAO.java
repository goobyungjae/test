package egovframework.test.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.test.board.service.TestBoardVO;
import egovframework.test.board.service.TestCommentVO;

@Repository("TestBoardDAO")
public class TestBoardDAO extends EgovComAbstractDAO {

	public List<TestBoardVO> selectTestBoardList(TestBoardVO vo) {
		return (List<TestBoardVO>) list("TestBoard.selectTestBoardList", vo);
	}

	public EgovMap selectTestBoardDetail(TestBoardVO vo) {
		return (EgovMap)selectOne("TestBoard.selectTestBoardDetail", vo);
	}

	public void insertTestBoard(TestBoardVO vo) {
		insert("TestBoard.insertTestBoard", vo);	
	}

	public void updateTestBoard(TestBoardVO vo) {		
		update("TestBoard.updateTestBoard", vo);
	}

	public void deleteTestCommentAll(TestBoardVO vo) {
		delete("TestBoard.deleteTestCommentAll", vo);
	}
	
	public void deleteTestBoard(TestBoardVO vo) {
		delete("TestBoard.deleteTestBoard", vo);
	}

//	public List<TestCommentVO> selectTestCommentList(TestCommentVO testCommentVo) {
//		return (List<TestCommentVO>) list("TestBoard.selectTestCommentList", testCommentVo);
//	}

	public void insertTestComment(TestCommentVO testCommentVo) {
		insert("TestBoard.insertTestComment", testCommentVo);		
	}

	public void updateTestComment(TestCommentVO testCommentVo) {
		update("TestBoard.updateTestComment", testCommentVo);
	}

	public void deleteTestComment(TestCommentVO testCommentVo) {
		delete("TestBoard.deleteTestComment", testCommentVo);
	}
}