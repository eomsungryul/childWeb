package kr.co.dwebss.child.web;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dwebss.child.model.Class;
import kr.co.dwebss.child.service.ClassService;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@Controller
public class ClassController {
	
    @Resource
    private ClassService classService;

//    @PostMapping("/add")
//    public Result add(Class vo) {
//        classService.save(vo);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        classService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Class vo) {
//        classService.update(vo);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Class vo = classService.findById(id);
//        return ResultGenerator.genSuccessResult(vo);
//    }
    
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//    	PageHelper.startPage(page, size);
//    	List<Class> list = classService.findAll();
//    	PageInfo pageInfo = new PageInfo(list);
//    	return ResultGenerator.genSuccessResult(pageInfo);
//    }

	/**
	 * 클래스 관리 목록
	 *
	 * @param ModelMap model
	 * @return String
	 * @throws Exception
	 */
    @RequestMapping("/director/class/list")
	public ModelAndView list(@ModelAttribute("class") Class vo
			) throws Exception {
		
    	vo.setFirstIndex((vo.getPageIndex() - 1 ) * vo.getPageUnit());
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
	public String regist(
			HttpServletRequest request,
			@ModelAttribute("class") Class vo,
			ModelMap model
			) throws Exception {
    	
    	String flag= request.getParameter("flag");

		if(flag.equals("U")){
	        Class result = classService.findById(vo.getClassId());
			model.addAttribute("result", result);
		}
		
		model.addAttribute("searchVO", vo);
		model.addAttribute("flag", flag);
		
		return "director/class/regist";
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
	@RequestMapping(value = "/director/class/insert")
	public String insert(
			HttpServletRequest request,
			@ModelAttribute("class") Class vo,
			ModelMap model) throws Exception {

		classService.save(vo);

		return "forward:/director/class/list";
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
	public String update(
			HttpServletRequest request,
			@ModelAttribute("class") Class vo
			) throws Exception {
		
		classService.update(vo);
		
		return "forward:/director/class/list";
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
	public String delete(
			HttpServletRequest request,
			@ModelAttribute("class") Class vo,
			ModelMap model) throws Exception {

      classService.deleteById(vo.getClassId());
	  return "forward:/director/class/list";
	}
}
