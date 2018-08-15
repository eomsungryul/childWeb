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

import org.springframework.boot.json.JsonSimpleJsonParser;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;

import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.ClassDailyEvent;
import kr.co.dwebss.child.service.CenterService;
import kr.co.dwebss.child.service.ClassDailyEventService;
import kr.co.dwebss.child.service.ClassService;
import net.minidev.json.parser.JSONParser;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
public class ClassDailyEventController {
	
    @Resource
    private ClassDailyEventService classDailyEventService;
    
    @Resource
    private ClassService classService;

    @Resource
    private CenterService centerService;

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
		
		Center centerInfo = centerService.findById(vo.getCenterId());
		List<kr.co.dwebss.child.model.Class> resultList = classService.selectClass(vo);
		mav.addObject("searchVO", vo);
		mav.addObject("resultList", resultList);
		mav.addObject("centerInfo", centerInfo);
		
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
	 * 변경 사항 수정 
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
			HttpServletRequest request,
			ModelMap model) throws Exception {
	ModelAndView mav = new ModelAndView("forward:/director/classEvent/list");
	String param = request.getParameter("list");
	JSONArray arr = (JSONArray) JSON.parse(param);
	ClassDailyEvent vo = null;
	String classId = "";
	String centerId = ""; // event_daily 
	
	
	for(int i = 0; i<arr.size(); i++) {
	   JSONObject obj = (JSONObject) arr.get(i);
	   vo = new ClassDailyEvent();
	   classId = obj.get("classId").toString();

	   if(i==0) {
		   // 기존에 있던 것들을 삭제 처리 한다. 
		   vo.setEventDate(new SimpleDateFormat("yyyy/MM/dd").parse((String) obj.get("eventDate")));
		   vo.setClassId(obj.get("classId").toString());
		   if(classId.indexOf("CENTER_")>-1) {
			   //센터,클래스 전체 이벤트 변경이다
				   centerId = obj.get("classId").toString();
				   vo.setCenterId(Integer.parseInt(centerId.split("CENTER_")[1]));
				   classDailyEventService.deleteClassDailyEventCenter(vo);
		   }else {
			   //클래스 이벤트 변경이다.
				   classDailyEventService.deleteClassDailyEvent(vo);
		   }
	   }

	   vo.setEventDate(new SimpleDateFormat("yyyy/MM/dd").parse((String) obj.get("eventDate")));
	   vo.setEventOrder(Integer.parseInt(obj.get("eventOrder").toString()));
	   vo.setClassId(obj.get("classId").toString());
	   vo.setDestinyNm(obj.get("destinyNm").toString());
	   vo.setEventAlarmStartT(Integer.parseInt(obj.get("eventAlarmStartT").toString()));
//	   vo.setEventAlarmEndT(Integer.parseInt(obj.get("eventAlarmEndT").toString()));
	   vo.setEventCarNeedYn(obj.get("eventCarNeedYn").toString());
	   
	   classDailyEventService.save(vo);
	   
	}
	
	if(!centerId.equals("")) {
		
		//어린이집 내의 클래스들을 insert 해야함
		kr.co.dwebss.child.model.Class clVO = new kr.co.dwebss.child.model.Class();
		clVO.setCenterId(Integer.parseInt(centerId.split("CENTER_")[1]));
		List<kr.co.dwebss.child.model.Class> classList = classService.selectClass(clVO);

		for(int i = 0; i<classList.size(); i++) {
			vo.setClassId(classList.get(i).getClassId().toString());
			vo.setAddCenterId(centerId);
			classDailyEventService.insertEventAllClass(vo);
		}
	}
				
		return mav;
	}
	


}
