package egovframework.test.board.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface TestBoardService {

	/* ------------------------------------------------ 게시판 ------------------------------------------------ */
	// 
	List<TestBoardVO> selectTestBoardList();
	
	//
	int selectTestBoardCnt();
	
	//
	EgovMap selectTestBoardDetail(TestBoardVO vo);
	
	//
	void insertTestBoard(TestBoardVO vo);
	
	//
	void updateTestBoard(TestBoardVO vo);
	
	//
	void deleteTestBoard(TestBoardVO vo);

	/* ------------------------------------------------ 댓글 ------------------------------------------------ */
	//
	List<TestCommentVO> selectTestCommentList(TestCommentVO testCommentVo);

	//
	void insertTestComment(TestCommentVO testCommentVo);

	//
	void updateTestComment(TestCommentVO testCommentVo);

	//
	void deleteTestComment(TestCommentVO testCommentVo);
	
	//
	int selectTestCommentCnt(TestCommentVO testCommentVo);

	void updateTestBoardViews(TestBoardVO vo);

	List<TestBoardCommendVO> selectCheckTestBoardCommend(TestBoardCommendVO testBoardCommendVO);

	void insertTestBoardCommend(TestBoardCommendVO testBoardCommendVO);
}