package kr.co.dwebss.child.web;
import kr.co.dwebss.child.core.Result;
import kr.co.dwebss.child.core.ResultGenerator;
import kr.co.dwebss.child.model.Center;
import kr.co.dwebss.child.model.Class;
import kr.co.dwebss.child.service.CenterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
public class CenterController {
    @Resource
    private CenterService centerService;

//    @PostMapping("/add")
//    public Result add(Center center) {
//        centerService.save(center);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        centerService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Center center) {
//        centerService.update(center);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Center center = centerService.findById(id);
//        return ResultGenerator.genSuccessResult(center);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Center> list = centerService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }


	/**
	 * 클래스 관리 목록
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
    
	
}
