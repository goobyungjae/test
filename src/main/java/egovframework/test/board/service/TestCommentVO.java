package egovframework.test.board.service;

import java.util.Date;

public class TestCommentVO {

	private int commentId;
	private String commentWriterId;
	private String commentWriterName;
	private String commentContents;
	private Date commentReg;
	private int boardId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentWriterId() {
		return commentWriterId;
	}

	public void setCommentWriterId(String commentWriterId) {
		this.commentWriterId = commentWriterId;
	}

	public String getCommentWriterName() {
		return commentWriterName;
	}

	public void setCommentWriterName(String commentWriterName) {
		this.commentWriterName = commentWriterName;
	}

	public String getCommentContents() {
		return commentContents;
	}

	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}

	public Date getCommentReg() {
		return commentReg;
	}

	public void setCommentReg(Date commentReg) {
		this.commentReg = commentReg;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
}