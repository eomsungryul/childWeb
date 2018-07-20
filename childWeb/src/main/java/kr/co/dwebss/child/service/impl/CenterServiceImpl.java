package kr.co.dwebss.child.service.impl;

import kr.co.dwebss.child.dao.CenterMapper;
import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.Class;
import kr.co.dwebss.child.service.CenterService;
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
public class CenterServiceImpl extends AbstractService<Center> implements CenterService {
    @Resource
    private CenterMapper centerMapper;

	@Override
	public void insertCenter(Center center) {
		centerMapper.insertCenter(center);
	}

	@Override
	public List<Center> selectList(Center vo) {
		return centerMapper.selectList(vo);
	}

	@Override
	public int selectListCnt(Center vo) {
		return centerMapper.selectListCnt(vo);
	}

}
