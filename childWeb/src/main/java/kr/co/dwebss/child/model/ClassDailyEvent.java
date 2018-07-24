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
     * 이벤트순서
     */
    @Column(name = "EVENT_ORDER")
    private Integer eventOrder;

    /**
     * 이벤트발생일
     */
    @Column(name = "EVENT_DATE")
    private Date eventDate;

    /**
     * 클래스ID
     */
    @Column(name = "CLASS_ID")
    private Integer classId;

    

    /**
     * 이벤트코드
     */
    @Column(name = "EVENT_CD")
    private Integer eventCd;

    @Column(name = "EVENT_CAR_NEED_YN")
    private String eventCarNeedYn;
    
    @Column(name = "DESTINY_NM")
    private String destinyNm;
    
    @Column(name = "EVENT_ALARM_TIME")
    private Integer eventAlarmTime;
    
    @Column(name = "EVENT_DAILY_GROUP_ID")
    private String eventDailyGroupId;
    
    @Transient
    private List<Map<String,Object>> list;
    
    
    public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
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

	public Integer getEventAlarmTime() {
		return eventAlarmTime;
	}

	public void setEventAlarmTime(Integer eventAlarmTime) {
		this.eventAlarmTime = eventAlarmTime;
	}

	public String getEventDailyGroupId() {
		return eventDailyGroupId;
	}

	public void setEventDailyGroupId(String eventDailyGroupId) {
		this.eventDailyGroupId = eventDailyGroupId;
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
     * getter이벤트코드
     *
     * @return EVENT_CD - 이벤트코드
     */
    public Integer getEventCd() {
        return eventCd;
    }

    /**
     * setter이벤트코드
     *
     * @param eventCd 이벤트코드
     */
    public void setEventCd(Integer eventCd) {
        this.eventCd = eventCd;
    }
}