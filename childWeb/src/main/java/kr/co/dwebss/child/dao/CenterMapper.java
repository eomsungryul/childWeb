package kr.co.dwebss.child.dao;

import java.util.List;

import kr.co.dwebss.child.core.Mapper;
import kr.co.dwebss.child.model.Center;

public interface CenterMapper extends Mapper<Center> {

	void insertCenter(Center center);

	List<Center> selectList(Center vo);

	int selectListCnt(Center vo);
}