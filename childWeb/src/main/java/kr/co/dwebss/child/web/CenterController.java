package kr.co.dwebss.child.web;
import kr.co.dwebss.child.core.Result;
import kr.co.dwebss.child.core.ResultGenerator;
import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.Class;
import kr.co.dwebss.child.service.CenterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
public class CenterController {
    @Resource
    private CenterService centerService;

	/**
	 * 센터 관리 목록
	 *
	 * @param Class vo
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping("/admin/center/list")
	public ModelAndView list(@ModelAttribute("center") Center vo
			) throws Exception {
		
    	vo.setFirstIndex((vo.getPageIndex() - 1 ) * vo.getPageUnit());
		List<Center> resultList = centerService.selectList(vo);
		int totalCnt=centerService.selectListCnt(vo);
		
		vo.setTotalRecordCount(totalCnt);
		vo.setTotalPage();
		
		ModelAndView mav = new ModelAndView("admin/center/list");
		mav.addObject("resultList", resultList);
		mav.addObject("totalCnt", totalCnt);
		mav.addObject("pni", vo);
		return mav;
	}
	
	

    /**
	 * 어린이집 관리 글쓰기
	 *
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/admin/center/regist")
	public ModelAndView regist(
			HttpServletRequest request,
			@ModelAttribute("center") Center vo
			) throws Exception {
		ModelAndView mav = new ModelAndView("admin/center/regist");
    	String flag= request.getParameter("flag");

		if(flag.equals("U")){
			Center result = centerService.findById(vo.getCenterId());
			mav.addObject("result", result);
		}
		
		mav.addObject("searchVO", vo);
		mav.addObject("flag", flag);
		
		return mav;
	}
    

	/**
	 * 어린이집 등록
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/center/insert")
	public ModelAndView insert(
			@ModelAttribute("center") Center vo,
			ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("forward:/admin/center/list");
		centerService.save(vo);

		return mav;
	}
	
	/**
	 * 어린이집 수정
	 *
	 * @param HttpServletRequest request
	 * @param Map<String, Object> codeMap
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/center/update")
	public ModelAndView update(
			@ModelAttribute("center") Center vo
			) throws Exception {

		ModelAndView mav = new ModelAndView("forward:/admin/center/list");
		centerService.update(vo);
		
		return mav;
	}

	/**
	 * 어린이집 삭제
	 *
	 * @param HttpServletRequest request
	 * @param Class vo
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/center/delete")
	public ModelAndView delete(
			@ModelAttribute("center") Center vo,
			ModelMap model) throws Exception {
	  ModelAndView mav = new ModelAndView("forward:/admin/center/list");
      centerService.deleteById(vo.getCenterId());
      
	  return mav;
	}
    
	
}
