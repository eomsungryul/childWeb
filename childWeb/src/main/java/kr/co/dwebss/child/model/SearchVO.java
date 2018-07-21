package kr.co.dwebss.child.model;

import java.io.Serializable;

import javax.persistence.Transient;

public class SearchVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2762108379321194700L;

	/** 검색조건 */
    @Transient
	private String searchCondition = "";

	/** 검색Keyword */
    @Transient
	private String searchKeyword = "";

	/** 검색사용여부 */
    @Transient
	private String searchUseYn = "";

	/** 검색시작날짜 */
    @Transient
	private String searchStartDate = "";

	/** 검색종료날짜 */
    @Transient
	private String searchEndDate = "";

	/** 검색그룹 */
    @Transient
	private String searchGroup = "";

	/** 현재페이지 */
    @Transient
	private int pageIndex = 1;

	/** 페이지갯수 */
    @Transient
	private int pageUnit = 10;

	/** 페이지사이즈 */
    @Transient
	private int pageSize = 5;

	/** firstIndex */
    @Transient
	private int firstIndex = 1;

	/** lastIndex */
    @Transient
	private int lastIndex = 1;

	/** recordCountPerPage */
    @Transient
	private int recordCountPerPage = 10;

	/** 검색KeywordFrom */
    @Transient
	private String searchKeywordFrom = "";

	/** 검색KeywordTo */
    @Transient
	private String searchKeywordTo = "";

	/** 정렬 컬럼명 */
    @Transient
	private String orderColumn = "";

	/** 정렬 순 */
    @Transient
	private String orderType = "";

	/** 전체 게시물 건 수.  */
    @Transient
	private int totalRecordCount;

	/** 전체 페이지 수  */
    @Transient
	private int totalPage;
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		this.lastIndex = (this.totalRecordCount % this.recordCountPerPage > 0)? 1:0;
		this.totalPage = (this.totalRecordCount / this.recordCountPerPage) + this.lastIndex;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public String getSearchGroup() {
		return searchGroup;
	}

	public void setSearchGroup(String searchGroup) {
		this.searchGroup = searchGroup;
	}

	public String getSearchStartDate() {
		return searchStartDate;
	}

	public void setSearchStartDate(String searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	public String getSearchEndDate() {
		return searchEndDate;
	}

	public void setSearchEndDate(String searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * searchKeywordFrom attribute를 리턴한다.
	 * @return String
	 */
	public String getSearchKeywordFrom() {
		return searchKeywordFrom;
	}

	/**
	 * searchKeywordFrom attribute 값을 설정한다.
	 * @param searchKeywordFrom String
	 */
	public void setSearchKeywordFrom(String searchKeywordFrom) {
		this.searchKeywordFrom = searchKeywordFrom;
	}

	/**
	 * searchKeywordTo attribute를 리턴한다.
	 * @return String
	 */
	public String getSearchKeywordTo() {
		return searchKeywordTo;
	}

	/**
	 * searchKeywordTo attribute 값을 설정한다.
	 * @param searchKeywordTo String
	 */
	public void setSearchKeywordTo(String searchKeywordTo) {
		this.searchKeywordTo = searchKeywordTo;
	}

}
