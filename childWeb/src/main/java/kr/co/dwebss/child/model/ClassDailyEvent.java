package kr.co.dwebss.child.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Table(name = "class_daily_event")
public class ClassDailyEvent {
    /**
     * 클래스일일이벤트ID
     */
    @Id
    @Column(name = "CLASS_DAILY_EVENT_ID")
    private Integer classDailyEventId;

    /**
     * 이벤트발생일
     */
    @Column(name = "EVENT_DATE")
    private Date eventDate;

    /**
     * 이벤트순서
     */
    @Column(name = "EVENT_ORDER")
    private Integer eventOrder;

    /**
     * 클래스ID
     */
    @Column(name = "CLASS_ID")
    private String classId;
    
    @Column(name = "DESTINY_NM")
    private String destinyNm;;

    @Column(name = "EVENT_ALARM_END_T")
    private Integer eventAlarmEndT;
    
    @Column(name = "EVENT_ALARM_START_T")
    private Integer eventAlarmStartT;
    
    @Column(name = "EVENT_CAR_NEED_YN")
    private String eventCarNeedYn;
    
    @Column(name = "EVENT_CHECK_TYPE")
    private Integer eventCheckType;
    
    @Transient
    private String list;
    
    @Transient
    private String flag;

    @Transient
    private Integer centerId;

    @Transient
    private String addCenterId;

    @Transient
    private String eventCheckTypeArray;
    
    
    public String getEventCheckTypeArray() {
		return eventCheckTypeArray;
	}

	public void setEventCheckTypeArray(String eventCheckTypeArray) {
		this.eventCheckTypeArray = eventCheckTypeArray;
	}

	public Integer getEventCheckType() {
		return eventCheckType;
	}

	public void setEventCheckType(Integer eventCheckType) {
		this.eventCheckType = eventCheckType;
	}

	public String getAddCenterId() {
		return addCenterId;
	}

	public void setAddCenterId(String addCenterId) {
		this.addCenterId = addCenterId;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getEventCarNeedYn() {
		return eventCarNeedYn;
	}

	public void setEventCarNeedYn(String eventCarNeedYn) {
		this.eventCarNeedYn = eventCarNeedYn;
	}

	public String getDestinyNm() {
		return destinyNm;
	}

	public void setDestinyNm(String destinyNm) {
		this.destinyNm = destinyNm;
	}


	/**
     * getter클래스일일이벤트ID
     *
     * @return CLASS_DAILY_EVENT_ID - 클래스일일이벤트ID
     */
    public Integer getClassDailyEventId() {
        return classDailyEventId;
    }

    /**
     * setter클래스일일이벤트ID
     *
     * @param classDailyEventId 클래스일일이벤트ID
     */
    public void setClassDailyEventId(Integer classDailyEventId) {
        this.classDailyEventId = classDailyEventId;
    }

    /**
     * getter이벤트순서
     *
     * @return EVENT_ORDER - 이벤트순서
     */
    public Integer getEventOrder() {
        return eventOrder;
    }

    /**
     * setter이벤트순서
     *
     * @param eventOrder 이벤트순서
     */
    public void setEventOrder(Integer eventOrder) {
        this.eventOrder = eventOrder;
    }

    /**
     * getter이벤트발생일
     *
     * @return EVENT_DATE - 이벤트발생일
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * setter이벤트발생일
     *
     * @param eventDate 이벤트발생일
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Integer getEventAlarmEndT() {
		return eventAlarmEndT;
	}

	public void setEventAlarmEndT(Integer eventAlarmEndT) {
		this.eventAlarmEndT = eventAlarmEndT;
	}

	public Integer getEventAlarmStartT() {
		return eventAlarmStartT;
	}

	public void setEventAlarmStartT(Integer eventAlarmStartT) {
		this.eventAlarmStartT = eventAlarmStartT;
	}
    

}