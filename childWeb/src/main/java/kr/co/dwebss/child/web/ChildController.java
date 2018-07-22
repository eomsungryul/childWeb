package kr.co.dwebss.child.web;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dwebss.child.cmmn.QrcodeUtil;
import kr.co.dwebss.child.model.Child;
import kr.co.dwebss.child.model.ChildQrCode;
import kr.co.dwebss.child.model.User;
import kr.co.dwebss.child.service.ChildQrCodeService;
import kr.co.dwebss.child.service.ChildService;
import kr.co.dwebss.child.service.ClassService;
import kr.co.dwebss.child.service.CommonCodeService;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
public class ChildController {
	
	
    @Resource
    private ChildService childService;

    @Resource
    private ClassService classService;

    @Resource
    private CommonCodeService commonCodeService;

    @Resource
    private ChildQrCodeService childQrCodeService;
    
    @Resource
    private QrcodeUtil qrcodeUtil;

	/**
	 * 어린이 관리 목록
	 *
	 * @param Class vo
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/director/child/list")
	public ModelAndView list(@ModelAttribute("child") Child vo,
			HttpSession session
			) throws Exception {
		
    	vo.setFirstIndex((vo.getPageIndex() - 1 ) * vo.getPageUnit());
    	vo.setCenterId((Integer)session.getAttribute("centerId"));
    	
		List<Child> resultList = childService.selectList(vo);
		int totalCnt=childService.selectListCnt(vo);
		
		vo.setTotalRecordCount(totalCnt);
		vo.setTotalPage();
		
		ModelAndView mav = new ModelAndView("director/child/list");
		mav.addObject("resultList", resultList);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pni", vo);
		return mav;
	}
	

    /**
	 * 어린이 관리 글쓰기
	 *
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/director/child/regist")
	public ModelAndView regist(
			HttpServletRequest request,
			@ModelAttribute("child") Child vo,
			HttpSession session
			) throws Exception {
		ModelAndView mav = new ModelAndView("director/child/regist");
    	String flag= request.getParameter("flag");

		if(flag.equals("U")){
			Child result = childService.selectChild(vo);
			mav.addObject("result", result);
		}

		//어린이집의 반을 가져오는 기능 
		kr.co.dwebss.child.model.Class param = new kr.co.dwebss.child.model.Class();
		param.setCenterId((Integer)session.getAttribute("centerId"));
		List<kr.co.dwebss.child.model.Class> classList = classService.selectClass(param);
		
		mav.addObject("searchVO", vo);
		mav.addObject("flag", flag);
		mav.addObject("classList", classList);
		
		
		return mav;
	}
    

	/**
	 * 어린이 등록
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
	@RequestMapping(value = "/director/child/insert")
	public ModelAndView insert(
			@ModelAttribute("child") Child vo,
			ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/director/child/list");
		vo.setChildId(UUID.randomUUID().toString());
		childService.save(vo);
		
		ChildQrCode cqrVO = new ChildQrCode();
		cqrVO.setChildId(vo.getChildId());
		cqrVO.setChildQrCodeImg(qrcodeUtil.generateQrCode(vo.getChildId()));
		childQrCodeService.save(cqrVO);
		
		return mav;
	}
	
	/**
	 * 어린이 수정
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/director/child/update")
	public ModelAndView update(
			@ModelAttribute("child") Child vo
			) throws Exception {

		ModelAndView mav = new ModelAndView("forward:/director/child/list");
		childService.update(vo);
		
		return mav;
	}

	/**
	 * 어린이 삭제
	 *
	 * @param HttpServletRequest request
	 * @param Class vo
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/director/child/delete")
	public ModelAndView delete(
			@ModelAttribute("child") Child vo,
			ModelMap model) throws Exception {
	  ModelAndView mav = new ModelAndView("forward:/director/child/list");
//      childService.deleteById(vo.getChildId());
      
	  return mav;
	}
    
}
