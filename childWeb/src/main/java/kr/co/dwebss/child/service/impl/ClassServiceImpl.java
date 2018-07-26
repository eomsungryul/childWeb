package kr.co.dwebss.child.service.impl;

import kr.co.dwebss.child.dao.ClassMapper;
import kr.co.dwebss.child.model.Class;
import kr.co.dwebss.child.service.ClassService;
import kr.co.dwebss.child.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/07/20.
 */
@Service
@Transactional
public class ClassServiceImpl extends AbstractService<Class> implements ClassService {
    @Resource
    private ClassMapper classMapper;

	@Override
	public List<Class> selectList(Class vo) {
		return classMapper.selectList(vo);
	}

	@Override
	public int selectListCnt(Class vo) {
		return classMapper.selectListCnt(vo);
	}

	@Override
	public List<Class> selectClass(Class param) {
		return classMapper.selectClass(param);
	}

	@Override
	public void insertClass(Class vo) {
		classMapper.insertClass(vo);
	}

	@Override
	public void insertClassEventThisYear(Class vo) {
		classMapper.insertClassEventThisYear(vo);
	}

	@Override
	public void insertCenterEventThisYear(String centerClassId) {
		classMapper.insertCenterEventThisYear(centerClassId);
	}

}
