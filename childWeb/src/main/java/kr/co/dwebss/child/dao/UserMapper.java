package kr.co.dwebss.child.dao;

import java.util.List;

import kr.co.dwebss.child.core.Mapper;
import kr.co.dwebss.child.model.User;

public interface UserMapper extends Mapper<User> {

	User selectUser(User vo);

	List<User> selectList(User vo);

	int selectListCnt(User vo);

	List<User> selectTeacher(User vo);
}