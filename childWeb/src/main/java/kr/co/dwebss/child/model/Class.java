package kr.co.dwebss.child.model;

import javax.persistence.*;

public class Class extends SearchVO {
    /**
     * 클래스ID
     */
    @Id
    @Column(name = "CLASS_ID")
    private Integer classId;

    /**
     * 클래스이름
     */
    @Column(name = "CLASS_NM")
    private String classNm;

    /**
     * 어린이집ID
     */
    @Column(name = "CENTER_ID")
    private Integer centerId;

    /**
     * 사용자(선생님)ID
     */
    @Column(name = "TEACHER_USER_ID")
    private Integer teacherUserId;
    
    @Transient
    private String teacherUserNm;
    
    @Transient
    private String centerNm;
    

    /**
     * 클래스이름
     */
    @Column(name = "CLASS_YEAR")
    private String classYear;
    
    

    public String getClassYear() {
		return classYear;
	}

	public void setClassYear(String classYear) {
		this.classYear = classYear;
	}

	public String getTeacherUserNm() {
		return teacherUserNm;
	}

	public void setTeacherUserNm(String teacherUserNm) {
		this.teacherUserNm = teacherUserNm;
	}

	public String getCenterNm() {
		return centerNm;
	}

	public void setCenterNm(String centerNm) {
		this.centerNm = centerNm;
	}

	/**
     * getter클래스ID
     *
     * @return CLASS_ID - 클래스ID
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * setter클래스ID
     *
     * @param classId 클래스ID
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * getter클래스이름
     *
     * @return CLASS_NM - 클래스이름
     */
    public String getClassNm() {
        return classNm;
    }

    /**
     * setter클래스이름
     *
     * @param classNm 클래스이름
     */
    public void setClassNm(String classNm) {
        this.classNm = classNm;
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

	public Integer getTeacherUserId() {
		return teacherUserId;
	}

	public void setTeacherUserId(Integer teacherUserId) {
		this.teacherUserId = teacherUserId;
	}
    
    

}