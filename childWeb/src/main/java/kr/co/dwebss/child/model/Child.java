package kr.co.dwebss.child.model;

import javax.persistence.*;

public class Child {
    /**
     * 아이ID
     */
    @Id
    @Column(name = "CHILD_ID")
    private String childId;

    /**
     * 아이이름
     */
    @Column(name = "CHILD_NM")
    private String childNm;

    /**
     * 아이연락처
     */
    @Column(name = "PARENT_PHONE")
    private String parentPhone;

    /**
     * 클래스ID
     */
    @Column(name = "CLASS_ID")
    private Integer classId;

    /**
     * 사용자(보호자)ID
     */
    @Column(name = "PARENT_USER_ID")
    private Integer parentUserId;

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

    /**
     * getter아이이름
     *
     * @return CHILD_NM - 아이이름
     */
    public String getChildNm() {
        return childNm;
    }

    /**
     * setter아이이름
     *
     * @param childNm 아이이름
     */
    public void setChildNm(String childNm) {
        this.childNm = childNm;
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

	public String getParentPhone() {
		return parentPhone;
	}

	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public Integer getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(Integer parentUserId) {
		this.parentUserId = parentUserId;
	}
    
    

}