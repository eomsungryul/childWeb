package kr.co.dwebss.child.model;

import javax.persistence.*;

@Table(name = "child_qr_code")
public class ChildQrCode extends SearchVO {
    /**
     * 아이ID
     */
    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    /**
     * QR코드이미지(BINARY)
     */
    @Column(name = "CHILD_QR_CODE_IMG")
    private String childQrCodeImg;

    @Transient
    private String childNm;

    @Transient
    private String parentPhone;

    @Transient
    private Integer classId;

    @Transient
    private Integer parentUserId;

    @Transient
    private String parentUserNm;
    
    @Transient
    private String classNm;
        
    @Transient
    private String centerNm;

    @Transient
    private Integer centerId;
    
    

    public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getChildNm() {
		return childNm;
	}

	public void setChildNm(String childNm) {
		this.childNm = childNm;
	}

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(Integer parentUserId) {
		this.parentUserId = parentUserId;
	}

	public String getParentUserNm() {
		return parentUserNm;
	}

	public void setParentUserNm(String parentUserNm) {
		this.parentUserNm = parentUserNm;
	}

	public String getClassNm() {
		return classNm;
	}

	public void setClassNm(String classNm) {
		this.classNm = classNm;
	}

	public String getCenterNm() {
		return centerNm;
	}

	public void setCenterNm(String centerNm) {
		this.centerNm = centerNm;
	}

	/**
     * getter아이ID
     *
     * @return CHILD_ID - 아이ID
     */
    public String getChildId() {
        return childId;
    }

    /**
     * setter아이ID
     *
     * @param childId 아이ID
     */
    public void setChildId(String childId) {
        this.childId = childId;
    }

	public String getChildQrCodeImg() {
		return childQrCodeImg;
	}

	public void setChildQrCodeImg(String childQrCodeImg) {
		this.childQrCodeImg = childQrCodeImg;
	}
    
    

}