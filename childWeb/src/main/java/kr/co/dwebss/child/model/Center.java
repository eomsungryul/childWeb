package kr.co.dwebss.child.model;

import javax.persistence.*;

public class Center extends SearchVO{
    /**
     * 어린이집ID
     */
    @Id
    @Column(name = "CENTER_ID")
    private Integer centerId;

    /**
     * 어린이집이름
     */
    @Column(name = "CENTER_NM")
    private String centerNm;

    /**
     * 어린이집 주소
     */
    @Column(name = "CENTER_ADDR")
    private String centerAddr;

    /**
     * 어린이집전화번호
     */
    @Column(name = "CENTER_PHONE")
    private String centerPhone;

    /**
     * 승인 여부
     */
    @Column(name = "CONFIRM_YN")
    private String confirmYn;

	public String getConfirmYn() {
		return confirmYn;
	}

	public void setConfirmYn(String confirmYn) {
		this.confirmYn = confirmYn;
	}

	public String getCenterAddr() {
		return centerAddr;
	}

	public void setCenterAddr(String centerAddr) {
		this.centerAddr = centerAddr;
	}

	/**
     * getter어린이집ID
     *
     * @return CENTER_ID - 어린이집ID
     */
    public Integer getCenterId() {
        return centerId;
    }

    /**
     * setter어린이집ID
     *
     * @param centerId 어린이집ID
     */
    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    /**
     * getter어린이집이름
     *
     * @return CENTER_NM - 어린이집이름
     */
    public String getCenterNm() {
        return centerNm;
    }

    /**
     * setter어린이집이름
     *
     * @param centerNm 어린이집이름
     */
    public void setCenterNm(String centerNm) {
        this.centerNm = centerNm;
    }


    /**
     * getter어린이집전화번호
     *
     * @return CENTER_PHONE - 어린이집전화번호
     */
    public String getCenterPhone() {
        return centerPhone;
    }

    /**
     * setter어린이집전화번호
     *
     * @param centerPhone 어린이집전화번호
     */
    public void setCenterPhone(String centerPhone) {
        this.centerPhone = centerPhone;
    }
}