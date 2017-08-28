package com.gms.web.command;

import com.gms.web.constant.*;

import lombok.Getter;
import lombok.Setter;

public class Command implements Commandable{
	@Getter
	protected String action,pageNumber,view;
	@Setter @Getter
	protected String dir, page, column, search,startRow, endRow;
	public void setPageNumber(String pageNumber) {
		this.pageNumber=(pageNumber==null)?
				"1": pageNumber;
		System.out.println("페이지번호 ::" + pageNumber);
	}
	public void setAction(String action) {
		this.action=(action==null)?
				"move": action;
		System.out.println("액션 ::" + action);
	}
	@Override
	public void process() {
		this.view=
				(dir.equals("home"))?
						"/WEB-INF/view/common/home.jsp":
				Path.VIEW+dir+Path.SEPARATOR+page+Extension.JSP;
	}
	@Override
	public String toString() {
		return "Command [DEST=" + dir +"/"+page+ ".jsp" +",ACTION=" +action+ ", page="+ "]";
	}
}
