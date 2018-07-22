package kr.co.dwebss.child.service.impl;

import kr.co.dwebss.child.dao.ChildMapper;
import kr.co.dwebss.child.model.Child;
import kr.co.dwebss.child.model.User;
import kr.co.dwebss.child.service.ChildService;
import kr.co.dwebss.child.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/07/20.
 */
@Service
@Transactional
public class ChildServiceImpl extends AbstractService<Child> implements ChildService {
	
    @Resource
    private ChildMapper childMapper;

	@Override
	public Child selectChild(Child vo) {
		return childMapper.selectChild(vo);
	}

	@Override
	public List<Child> selectList(Child vo) {
		return childMapper.selectList(vo);
	}

	@Override
	public int selectListCnt(Child vo) {
		return childMapper.selectListCnt(vo);
	}

}
