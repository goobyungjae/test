package egovframework.test.board.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.test.board.service.TestBoardCommendVO;
import egovframework.test.board.service.TestBoardService;
import egovframework.test.board.service.TestBoardVO;
import egovframework.test.board.service.TestCommentVO;

@Controller
public class TestBoardController {

	@Resource(name = "TestBoardService")
	private TestBoardService testBoardService;
	
	
	/* 게시판 */
	// 게시판 불러오기
	@RequestMapping(value="/test/board/selectTestBoardList.do", method=RequestMethod.GET)
	public String selectTestBoardList(HttpServletRequest request, @ModelAttribute("testBoardVO") TestBoardVO vo, ModelMap model) throws Exception {
		// 게시글 총 개수
		int testBoardCnt = testBoardService.selectTestBoardCnt();
		List<TestBoardVO> testBoardList = testBoardService.selectTestBoardList();
		model.addAttribute("testBoardList", testBoardList);
		model.addAttribute("testBoardCnt", testBoardCnt);
		return "egovframework/test/board/testBoardList";
	}

	// 상세 게시글 불러오기
	@RequestMapping(value="/test/board/selectTestBoardDetail.do", method=RequestMethod.GET)
	public String selectTestBoardDetail(HttpServletRequest request, @ModelAttribute("testBoardVO") TestBoardVO vo, @ModelAttribute("testCommentVO") TestCommentVO testCommentVo, ModelMap model) throws Exception {
		EgovMap testBoardDetail = testBoardService.selectTestBoardDetail(vo);
		// 조회수 + 1 증가 ==> 1만 증가되도록 설정해보기
		testBoardService.updateTestBoardViews(vo);
		model.addAttribute("testBoardDetail", testBoardDetail);		
		// 댓글
		int commentCnt = testBoardService.selectTestCommentCnt(testCommentVo);
		model.addAttribute("commentCnt", commentCnt);
		List<TestCommentVO> testCommentList = testBoardService.selectTestCommentList(testCommentVo);
		model.addAttribute("testCommentList", testCommentList);
		return "egovframework/test/board/testBoardDetail";
	}

	// 게시글 등록 페이지 불러오기
	@RequestMapping(value="/test/board/insertTestBoardView.do")
	public String insertTestBoardView(HttpServletRequest request) throws Exception {
		return "egovframework/test/board/insertTestBoardView";
	}

	// 게시글 등록
	@RequestMapping(value="/test/board/insertTestBoard.do", method=RequestMethod.POST)
	public String insertTestBoard(MultipartHttpServletRequest mrequest, HttpServletRequest request, @ModelAttribute("testBoardVO") TestBoardVO vo) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setBoardWriterId(user.getId());
		vo.setBoardWriterName(user.getName());
		testBoardService.insertTestBoard(vo);
		return "redirect:/test/board/selectBoardList.do";
	}

	// 게시글 수정 페이지 불러오기
	@RequestMapping(value="/test/board/updateTestBoardView.do", method=RequestMethod.GET)
	public String updateTestView(HttpServletRequest request, @ModelAttribute("testBoardVO") TestBoardVO vo, ModelMap model) throws Exception {
		EgovMap testBoardDetail = testBoardService.selectTestBoardDetail(vo);
		model.addAttribute("testBoardDetail", testBoardDetail);
		return "egovframework/test/board/updateTestBoardView";
	}

	// 게시글 수정
	@RequestMapping(value="/test/board/updateTestBoard.do", method=RequestMethod.POST)
	public String updateTestBoard(HttpServletRequest request, @ModelAttribute("testBoardVO") TestBoardVO vo) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setBoardWriterId(user.getId());
		vo.setBoardWriterName(user.getName());
		testBoardService.updateTestBoard(vo);
		return "redirect:/test/board/testBoardDetail.do";
	}
	
	// 게시글 삭제 ( 게시글 삭제 이전에 해당 게시글에 대한 댓글 목록 삭제)
	@RequestMapping(value="/test/board/deleteTestBoard.do", method=RequestMethod.POST)
	public String deleteTestBoard(HttpServletRequest request, @ModelAttribute("testBoardVO") TestBoardVO vo) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setBoardWriterId(user.getId());
		vo.setBoardWriterName(user.getName());
		testBoardService.deleteTestBoard(vo);
		return "redirect:/test/board/selectBoardList.do";
	}
	
	// 게시물 추천
	@RequestMapping(value="/test/board/inserTestBoardCommend.do", method=RequestMethod.POST)
	public String inserTestBoardCommend(HttpServletRequest request, @ModelAttribute("testBoardCommendVO") TestBoardCommendVO testBoardCommendVO, TestBoardVO vo, ModelMap Model) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		// 추천 여부 확인하기
		testBoardCommendVO.setEmplyrId(user.getId());
		testBoardCommendVO.setBoardId(vo.getBoardId());
		List<TestBoardCommendVO> checkTestBoardCommend = testBoardService.selectCheckTestBoardCommend(testBoardCommendVO);
		if(checkTestBoardCommend == null) {
			testBoardService.insertTestBoardCommend(testBoardCommendVO);
		}
		
		return "jsonView";
	}
	
	/* 댓글 ajax */
	// 댓글 등록
	@RequestMapping(value="/test/board/insertTestComment.do", method=RequestMethod.POST)
	public String inserTestComment(HttpServletRequest request, @ModelAttribute("testCommentVO") TestCommentVO testCommentVo, ModelMap Model) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		testCommentVo.setCommentWriterId(user.getId());		
		testCommentVo.setCommentWriterName(user.getName());	
		testBoardService.insertTestComment(testCommentVo);
		return "jsonView";
	}
	
	// 댓글 수정
	@RequestMapping(value="/test/board/updateTestComment.do", method=RequestMethod.POST)
	public String updateTestComment(HttpServletRequest request, @ModelAttribute("testCommentVO") TestCommentVO testCommentVo) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		testCommentVo.setCommentWriterId(user.getId());
		testCommentVo.setCommentWriterName(user.getName());
		testBoardService.updateTestComment(testCommentVo);
		return "jsonView";
	}
	
	// 댓글 삭제
	@RequestMapping(value="/test/board/deleteTestComment.do", method=RequestMethod.POST)
	public String deleteTestComment(HttpServletRequest request, @ModelAttribute("testCommentVO") TestCommentVO testCommentVo) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		testCommentVo.setCommentWriterId(user.getId());
		testCommentVo.setCommentWriterName(user.getName());
		testBoardService.deleteTestComment(testCommentVo);
		return "jsonView";
	}
}