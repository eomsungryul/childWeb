package kr.co.dwebss.child.web;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.CommonCode;
import kr.co.dwebss.child.model.User;
import kr.co.dwebss.child.service.CommonCodeService;
import kr.co.dwebss.child.service.UserService;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
public class teacherController {
	
    @Resource
    private UserService userService;

    @Resource
    private CommonCodeService commonCodeService;

	/**
	 * 선생님 관리 목록
	 *
	 * @param Class vo
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/director/teacher/list")
	public ModelAndView list(@ModelAttribute("user") User vo
			) throws Exception {
		
    	vo.setFirstIndex((vo.getPageIndex() - 1 ) * vo.getPageUnit());
		List<Center> resultList = userService.selectList(vo);
		int totalCnt=userService.selectListCnt(vo);
		
		vo.setTotalRecordCount(totalCnt);
		vo.setTotalPage();
		
		ModelAndView mav = new ModelAndView("director/teacher/list");
		mav.addObject("resultList", resultList);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pni", vo);
		return mav;
	}
	

    /**
	 * 선생님 관리 글쓰기
	 *
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/director/teacher/regist")
	public ModelAndView regist(
			HttpServletRequest request,
			@ModelAttribute("user") User vo
			) throws Exception {
		ModelAndView mav = new ModelAndView("director/teacher/regist");
    	String flag= request.getParameter("flag");

		if(flag.equals("U")){
			User result = userService.selectUser(vo);
			mav.addObject("result", result);
		}
		//선생님 권한 찾는 기능 
		CommonCode codeVO = new CommonCode();
		codeVO.setSearchCondition("mappingCategory");
		codeVO.setSearchKeyword("10000");

		List<CommonCode> typeList = commonCodeService.selectCategory(codeVO);
		
		mav.addObject("searchVO", vo);
		mav.addObject("flag", flag);
		mav.addObject("typeList", typeList);
		
		return mav;
	}
    

	/**
	 * 선생님 등록
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/director/teacher/insert")
	public ModelAndView insert(
			@ModelAttribute("user") User vo,
			ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/director/teacher/list");
		userService.save(vo);

		return mav;
	}
	
	/**
	 * 선생님 수정
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/director/teacher/update")
	public ModelAndView update(
			@ModelAttribute("user") User vo
			) throws Exception {

		ModelAndView mav = new ModelAndView("forward:/director/teacher/list");
		userService.update(vo);
		
		return mav;
	}

	/**
	 * 선생님 삭제
	 *
	 * @param HttpServletRequest request
	 * @param Class vo
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/director/teacher/delete")
	public ModelAndView delete(
			@ModelAttribute("user") User vo,
			ModelMap model) throws Exception {
	  ModelAndView mav = new ModelAndView("forward:/director/teacher/list");
      userService.deleteById(vo.getUserId());
      
	  return mav;
	}
    
    

	
}
