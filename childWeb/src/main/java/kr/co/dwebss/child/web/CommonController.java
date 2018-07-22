package kr.co.dwebss.child.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

	/**
	 * Header
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/inc/incHeader")
	public String incHeader(
			@RequestParam HashMap<String, String> paramMap,
			HttpServletRequest request,
			HttpSession session,
			ModelMap model)
			throws Exception {

//		if(session.getAttribute("userInfo")!=null){
//			String userId = (String)session.getAttribute("userId");
//			String userName = (String)session.getAttribute("userName");
//			model.addAttribute("userId", userId);
//			model.addAttribute("userName", userName);
//		}
//
//		paramMap.put("pathStr", EgovStringUtil.uriPathDeletePageUrl(paramMap.get("path"), request.getContextPath()));
//
//		EgovMap menuMap = new EgovMap();
//		String roleId = "rl_0000";
//
//		if(session.getAttribute("roleId")!=null) roleId = (String)session.getAttribute("roleId");
//
//		if(!paramMap.get("pathStr").equals("")){
//			menuMap = commonService.selectMenuInfo(paramMap);
//		}
//		model.addAttribute("menuInfo", menuMap);
//
//		paramMap.put("topMenuId", "MN_0000");
//		paramMap.put("roleId", roleId);
//
//		model.addAttribute("menuList", commonService.selectMenuList(paramMap));
		return "inc/incHeader";
	}


	/**
	 * Left
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/inc/incLeft")
	public String incLeft(
			HttpServletRequest request,
			@RequestParam HashMap<String, String> paramMap,
			HttpSession session,
			ModelMap model)
			throws Exception {

//		paramMap.put("pathStr", EgovStringUtil.uriPathDeletePageUrl(paramMap.get("path"), request.getContextPath()));
//
//		EgovMap menuMap = new EgovMap();
//		String roleId = "rl_0000";
//
//		if(session.getAttribute("roleId")!=null) roleId = (String)session.getAttribute("roleId");
//
//		if((paramMap.get("pathStr").indexOf("/user/")!=-1 && paramMap.get("pathStr").equals("/user/"))||paramMap.get("path").indexOf("/common/") != -1||paramMap.get("path").indexOf("/login/") != -1){
//
//		}else if(!paramMap.get("pathStr").equals("")){
//			menuMap = commonService.selectMenuInfo(paramMap);
//			model.addAttribute("menuInfo", menuMap);
//
//			paramMap.put("topMenuId", menuMap.get("path").toString().split("\\|")[2]);
//			paramMap.put("menuId", menuMap.get("menuId").toString());
//			paramMap.put("roleId", roleId);
//
//			model.addAttribute("menuList", commonService.selectMenuList(paramMap));
//		}

		return "inc/incLeft";
	}
	
	
	@RequestMapping(value="/login")
	public String index(
			HttpServletRequest request,
			@RequestParam HashMap<String, String> paramMap,
			HttpSession session,
			ModelMap model)
			throws Exception {
		return "login";
	}
	
	@RequestMapping(value="/join")
	public String join(
			HttpServletRequest request,
			@RequestParam HashMap<String, String> paramMap,
			HttpSession session,
			ModelMap model)
			throws Exception {
		return "join";
	}
	
	

	

}
