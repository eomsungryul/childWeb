package kr.co.dwebss.child.web;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.Class;
import kr.co.dwebss.child.model.CommonCode;
import kr.co.dwebss.child.model.User;
import kr.co.dwebss.child.service.ClassService;
import kr.co.dwebss.child.service.CommonCodeService;
import kr.co.dwebss.child.service.UserService;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@Controller
public class ClassController {
	
    @Resource
    private ClassService classService;

    @Resource
    private UserService userService;

	/**
	 * 클래스 관리 목록
	 *
	 * @param Class vo
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/director/class/list")
	public ModelAndView list(@ModelAttribute("class") Class vo,
			HttpSession session
			) throws Exception {
		
    	vo.setFirstIndex((vo.getPageIndex() - 1 ) * vo.getPageUnit());
    	vo.setCenterId((Integer)session.getAttribute("centerId"));
    	
		List<Class> resultList = classService.selectList(vo);
		int totalCnt=classService.selectListCnt(vo);
		
		vo.setTotalRecordCount(totalCnt);
		vo.setTotalPage();
		
		ModelAndView mav = new ModelAndView("director/class/list");
		mav.addObject("resultList", resultList);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pni", vo);
		return mav;
	}
	

    /**
	 * 클래스 관리 글쓰기
	 *
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/director/class/regist")
	public ModelAndView regist(
			HttpServletRequest request,
			@ModelAttribute("class") Class vo,
			HttpSession session
			) throws Exception {
		ModelAndView mav = new ModelAndView("director/class/regist");
    	String flag= request.getParameter("flag");

		if(flag.equals("U")){
			Class result = classService.findById(vo.getClassId());
			mav.addObject("result", result);
		}
		
		//담당 선생님 찾는 기능
		User param = new User();
		param.setCenterId((Integer)session.getAttribute("centerId"));
		param.setUserRoleCd(100003);
		List<User> teacherList = userService.selectTeacher(param);
		
		mav.addObject("searchVO", vo);
		mav.addObject("flag", flag);
		mav.addObject("centerId", (Integer)session.getAttribute("centerId"));
		mav.addObject("teacherList", teacherList);
		
		return mav;
	}
    

	/**
	 * 클래스 등록
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
	@RequestMapping(value = "/director/class/insert")
	public ModelAndView insert(
			@ModelAttribute("class") Class vo,
			ModelMap model,
			HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/director/class/list");
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		vo.setClassYear(String.valueOf(year));
		classService.insertClass(vo);
		
    	vo.setInputCenterId("CENTER_"+session.getAttribute("centerId"));
		classService.insertClassEventThisYear(vo);
		
		return mav;
	}
	
	/**
	 * 클래스 수정
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/director/class/update")
	public ModelAndView update(
			@ModelAttribute("class") Class vo
			) throws Exception {
		
		ModelAndView mav = new ModelAndView("forward:/director/class/list");
		classService.update(vo);
		
		return mav;
	}

	/**
	 * 클래스 삭제
	 *
	 * @param HttpServletRequest request
	 * @param Class vo
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/director/class/delete")
	public ModelAndView delete(
			@ModelAttribute("class") Class vo,
			ModelMap model) throws Exception {
	  ModelAndView mav = new ModelAndView("forward:/director/class/list");
      classService.deleteById(vo.getClassId());
      
	  return mav;
	}
}
