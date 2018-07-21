package kr.co.dwebss.child.dao;

import java.util.List;

import kr.co.dwebss.child.core.Mapper;
import kr.co.dwebss.child.model.CommonCode;

public interface CommonCodeMapper extends Mapper<CommonCode> {

	List<CommonCode> selectCategory(CommonCode vo);
}