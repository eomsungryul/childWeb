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
    @Column(name = "CHILD_PHONE")
    private String childPhone;

    /**
     * 클래스ID
     */
    @Column(name = "CLASS_ID")
    private Integer classId;

    /**
     * 사용자(보호자)ID
     */
    @Column(name = "USER_ID")
    private Integer userId;

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
     * getter아이연락처
     *
     * @return CHILD_PHONE - 아이연락처
     */
    public String getChildPhone() {
        return childPhone;
    }

    /**
     * setter아이연락처
     *
     * @param childPhone 아이연락처
     */
    public void setChildPhone(String childPhone) {
        this.childPhone = childPhone;
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
     * getter사용자(보호자)ID
     *
     * @return USER_ID - 사용자(보호자)ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * setter사용자(보호자)ID
     *
     * @param userId 사용자(보호자)ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}