package kr.co.dwebss.child.service;
import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.Class;

import java.util.HashMap;
import java.util.List;

import kr.co.dwebss.child.core.Service;


/**
 * Created by 엄성렬 on 2018/07/20.
 */
public interface CenterService extends Service<Center> {

	void insertCenter(Center center);

	List<Center> selectList(Center vo);

	int selectListCnt(Center vo);

}
