package kr.co.dwebss.child.service;
import kr.co.dwebss.child.model.Class;

import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.child.core.Service;


/**
 * Created by 엄성렬 on 2018/07/20.
 */
public interface ClassService extends Service<Class> {

	List<Class> selectList(Class vo);
	
	int selectListCnt(Class vo);
	
	List<Class> selectClass(Class param);

	void insertClass(Class vo);

	void insertClassEventThisYear(String centerClassId);

}
