package kr.co.dwebss.child.web;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dwebss.child.model.ClassDailyEvent;
import kr.co.dwebss.child.service.ClassDailyEventService;
import kr.co.dwebss.child.service.ClassService;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
public class ClassDailyEventController {
	
    @Resource
    private ClassDailyEventService classDailyEventService;
    
    @Resource
    private ClassService classService;

	/**
	 * 클래스 관리 목록
	 *
	 * @param classEvent vo
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/director/classEvent/list")
	public ModelAndView classList(@ModelAttribute("class") kr.co.dwebss.child.model.Class vo,
			HttpSession session
			) throws Exception {

		ModelAndView mav = new ModelAndView("director/classEvent/list");

		//어린이집의 반을 가져오는 기능 
		vo.setCenterId((Integer)session.getAttribute("centerId"));
		List<kr.co.dwebss.child.model.Class> resultList = classService.selectClass(vo);
		mav.addObject("searchVO", vo);
		mav.addObject("resultList", resultList);
		
		return mav;
	}
	
	
	/**
	 * 클래스 이벤트  목록
	 *
	 * @param classEvent vo
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/director/classEvent/eventList")
	public ModelAndView classEvent(@ModelAttribute("classDailyEvent") ClassDailyEvent vo,
			HttpSession session
			) throws Exception {
		
		ModelAndView mav = new ModelAndView("director/classEvent/eventList");
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy-MM-dd", Locale.KOREA );
		java.util.Date currentTime = new java.util.Date();
		String mTime = mSimpleDateFormat.format ( currentTime );
		
		if(vo.getEventDate()==null) {
			vo.setEventDate(java.sql.Date.valueOf(mTime));
		}
		
		//반의 클래스 이벤트를 가져오는 기능 
		List<ClassDailyEvent> resultList = classDailyEventService.selectClassEvent(vo);
		
		mav.addObject("searchVO", vo);
		mav.addObject("resultList", resultList);
		
		return mav;
	}
	

    /**
	 * 클래스 관리 글쓰기
	 *
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping("/director/classEvent/regist")
	public ModelAndView regist(
			HttpServletRequest request,@ModelAttribute("classDailyEvent") ClassDailyEvent vo,
			HttpSession session
			) throws Exception {
		ModelAndView mav = new ModelAndView("director/classEvent/regist");
    	String flag= request.getParameter("flag");

		if(flag.equals("U")){
			ClassDailyEvent result = classDailyEventService.findById(vo.getClassDailyEventId());
			mav.addObject("result", result);
		}
		
		//담당 선생님 찾는 기능
//		User param = new User();
//		param.setCenterId((Integer)session.getAttribute("centerId"));
//		param.setUserRoleCd(100003);
//		List<User> teacherList = userService.selectTeacher(param);
		
		mav.addObject("searchVO", vo);
		mav.addObject("flag", flag);
		mav.addObject("centerId", (Integer)session.getAttribute("centerId"));
//		mav.addObject("teacherList", teacherList);
		
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
	@RequestMapping(value = "/director/classEvent/insert")
	public ModelAndView insert(
			@ModelAttribute("classDailyEvent") ClassDailyEvent vo,
//			@RequestBody List<Map<String,String>> dd, 
			ModelMap model) throws Exception {
    	
		ModelAndView mav = new ModelAndView("director/classEvent/list");
//		System.out.println("dd : "+dd);
//		int year = Calendar.getInstance().get(Calendar.YEAR);
//		vo.setclassEventYear(String.valueOf(year));
		
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
	@RequestMapping(value = "/director/classEvent/update")
	public ModelAndView update(
			@ModelAttribute("classDailyEvent") ClassDailyEvent vo
			) throws Exception {
		
		ModelAndView mav = new ModelAndView("forward:/director/classEvent/list");
//		classEventService.update(vo);
		
		return mav;
	}

	/**
	 * 클래스 삭제
	 *
	 * @param HttpServletRequest request
	 * @param classEvent vo
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/director/classEvent/delete")
	public ModelAndView delete(
			@ModelAttribute("classDailyEvent") ClassDailyEvent vo,
			ModelMap model) throws Exception {
	  ModelAndView mav = new ModelAndView("forward:/director/classEvent/list");
//      classEventService.deleteById(vo.getclassEventId());
      
	  return mav;
	}

}
