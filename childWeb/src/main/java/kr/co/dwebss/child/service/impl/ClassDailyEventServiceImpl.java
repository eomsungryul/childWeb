package kr.co.dwebss.child.service.impl;

import kr.co.dwebss.child.dao.ClassDailyEventMapper;
import kr.co.dwebss.child.model.ClassDailyEvent;
import kr.co.dwebss.child.service.ClassDailyEventService;
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
public class ClassDailyEventServiceImpl extends AbstractService<ClassDailyEvent> implements ClassDailyEventService {
    @Resource
    private ClassDailyEventMapper classDailyEventMapper;

	@Override
	public List<ClassDailyEvent> selectClassEvent(ClassDailyEvent vo) {
		return classDailyEventMapper.selectClassEvent(vo);
	}

}
