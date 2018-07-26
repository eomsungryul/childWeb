package kr.co.dwebss.child.dao;

import java.util.List;

import kr.co.dwebss.child.core.Mapper;
import kr.co.dwebss.child.model.Class;

public interface ClassMapper extends Mapper<Class> {

	List<Class> selectList(Class vo);

	int selectListCnt(Class vo);

	List<Class> selectClass(Class param);

	void insertClass(Class vo);

	void insertClassEventThisYear(String string);
}