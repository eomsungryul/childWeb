package kr.co.dwebss.child.web;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dwebss.child.model.ChildQrCode;
import kr.co.dwebss.child.service.ChildQrCodeService;

/**
* Created by 엄성렬 on 2018/07/20.
*/
@RestController
public class ChildQrCodeController {
    @Resource
    private ChildQrCodeService childQrCodeService;
    

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
	@RequestMapping(value = "/director/childQr/detail")
	public ModelAndView detail(
			@ModelAttribute("childqr") ChildQrCode vo,
			HttpServletRequest request,
			HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("director/childQr/detail");

		vo.setCenterId((Integer)session.getAttribute("centerId"));
		String pageExport = request.getParameter("pageExport");
		if(pageExport==""||pageExport==null) {
	    	mav.addObject("pageExport", 1);
		}else {
	    	mav.addObject("pageExport", Integer.parseInt(pageExport));
		}
		
    	List<ChildQrCode> resultList = childQrCodeService.selectQrcode(vo);
    	mav.addObject("resultList", resultList);
    	
		return mav;
	}
    
    
    
    
    
    
    
    
    
    
}
