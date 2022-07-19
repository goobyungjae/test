package egovframework.test.board.service;

import java.util.Date;

public class TestBoardVO {

	private int boardId;
	private String boardTitle;
	private String boardContents;
	private String boardWriterId;
	private String boardWriterName;
	private Date boardReg;
	private int boardViews;
	
	private int commentInBoardCount;

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContents() {
		return boardContents;
	}

	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}

	public String getBoardWriterId() {
		return boardWriterId;
	}

	public void setBoardWriterId(String boardWriterId) {
		this.boardWriterId = boardWriterId;
	}
	
	public String getBoardWriterName() {
		return boardWriterName;
	}

	public void setBoardWriterName(String boardWriterName) {
		this.boardWriterName = boardWriterName;
	}

	public Date getBoardReg() {
		return boardReg;
	}

	public void setBoardReg(Date boardReg) {
		this.boardReg = boardReg;
	}
	public int getCommentInBoardCount() {
		return commentInBoardCount;
	}

	public void setCommentInBoardCount(int commentInBoardCount) {
		this.commentInBoardCount = commentInBoardCount;
	}

	public int getBoardViews() {
		return boardViews;
	}

	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}

}