package kr.co.dwebss.child.dao;

import java.util.List;

import kr.co.dwebss.child.core.Mapper;
import kr.co.dwebss.child.model.ClassDailyEvent;

public interface ClassDailyEventMapper extends Mapper<ClassDailyEvent> {

	List<ClassDailyEvent> selectClassEvent(ClassDailyEvent vo);
}