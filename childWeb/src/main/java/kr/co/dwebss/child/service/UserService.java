package kr.co.dwebss.child.service;
import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.User;

import java.util.List;

import kr.co.dwebss.child.core.Service;


/**
 * Created by 엄성렬 on 2018/07/20.
 */
public interface UserService extends Service<User> {

	User selectUser(User vo);

	List<User> selectList(User vo);

	int selectListCnt(User vo);

	List<User> selectTeacher(User param);

}
