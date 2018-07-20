package kr.co.dwebss.child.model;

import javax.persistence.*;

public class Center {
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
     * 어린이집주소
     */
    @Column(name = "CETNER_ADDR")
    private String cetnerAddr;

    /**
     * 어린이집전화번호
     */
    @Column(name = "CENTER_PHONE")
    private String centerPhone;

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
     * getter어린이집주소
     *
     * @return CETNER_ADDR - 어린이집주소
     */
    public String getCetnerAddr() {
        return cetnerAddr;
    }

    /**
     * setter어린이집주소
     *
     * @param cetnerAddr 어린이집주소
     */
    public void setCetnerAddr(String cetnerAddr) {
        this.cetnerAddr = cetnerAddr;
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