package kr.co.dwebss.child.service.impl;

import kr.co.dwebss.child.dao.ChildMapper;
import kr.co.dwebss.child.model.Child;
import kr.co.dwebss.child.service.ChildService;
import kr.co.dwebss.child.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by 엄성렬 on 2018/07/20.
 */
@Service
@Transactional
public class ChildServiceImpl extends AbstractService<Child> implements ChildService {
    @Resource
    private ChildMapper childMapper;

}
