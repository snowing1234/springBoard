package com.tstory.joalog.page;

public class DefaultPage {

	private int page;
	private int listNum;
	private int boardId;
	
	public DefaultPage(){
		
	}
	
	public DefaultPage(int page, int listNum){
		setPage(page);
		setListNum(listNum);
	}
	public DefaultPage(int boardId, int page, int listNum){
		setBoardId(boardId);
		setPage(page);
		setListNum(listNum);
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getListNum() {
		return listNum;
	}
	public void setListNum(int listNum) {
		this.listNum = listNum;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	@Override
	public String toString(){
		return "<DefaultPage [ page : "+page+"], [ listNum :"+listNum+"], [ boardId : "+boardId+"]>";
	}
}
