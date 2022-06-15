package egovframework.test.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.test.board.service.TestBoardService;
import egovframework.test.board.service.TestBoardVO;
import egovframework.test.board.service.TestCommentVO;

@Service("TestBoardService")
public class TestBoardServiceImpl implements TestBoardService {

	@Resource(name = "TestBoardDAO")
    private TestBoardDAO testBoardDao;
	
	@Override
	public List<TestBoardVO> selectTestBoardList(TestBoardVO vo) {
		return testBoardDao.selectTestBoardList(vo);
	}

	@Override
	public EgovMap selectTestBoardDetail(TestBoardVO vo) {
		return testBoardDao.selectTestBoardDetail(vo);
	}

	@Override
	public void insertTestBoard(TestBoardVO vo) {
		testBoardDao.insertTestBoard(vo);
	}
	
	@Override
	public void updateTestBoard(TestBoardVO vo) {
		testBoardDao.updateTestBoard(vo);
	}

	@Override
	public void deleteTestBoard(TestBoardVO vo) {
		testBoardDao.deleteTestCommentAll(vo);
		testBoardDao.deleteTestBoard(vo);
	}

//	@Override
//	public List<TestCommentVO> selectTestCommentList(TestCommentVO testCommentVo) {
//		return testBoardDao.selectTestCommentList(testCommentVo);
//	}

	@Override
	public void insertTestComment(TestCommentVO testCommentVo) {
		testBoardDao.insertTestComment(testCommentVo);
	}

	@Override
	public void updateTestComment(TestCommentVO testCommentVo) {
		testBoardDao.updateTestComment(testCommentVo);
	}

	@Override
	public void deleteTestComment(TestCommentVO testCommentVo) {
		testBoardDao.deleteTestComment(testCommentVo);
	}
}