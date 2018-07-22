package kr.co.dwebss.child.service;
import kr.co.dwebss.child.model.Child;
import kr.co.dwebss.child.model.User;

import java.util.List;

import kr.co.dwebss.child.core.Service;


/**
 * Created by 엄성렬 on 2018/07/20.
 */
public interface ChildService extends Service<Child> {

	Child selectChild(Child vo);

	List<Child> selectList(Child vo);

	int selectListCnt(Child vo);

}
