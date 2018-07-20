package kr.co.dwebss.child.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.child.core.Mapper;
import kr.co.dwebss.child.model.Class;

public interface ClassMapper extends Mapper<Class> {

	List<Class> selectList(Class vo);

	int selectListCnt(Class vo);
}