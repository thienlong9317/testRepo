package controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import beans.LoaiSua;
import businessLogics.LoaiSuaBL;

@Controller
public class HomeController {
	@RequestMapping({"/","/home"})
	public String home()
	{
		return "home";
	}
	
	@RequestMapping(path = "/setCookies")
	@ResponseBody
	public String setCookies(HttpServletResponse response) {
		Cookie ck1 = new Cookie("ten", "Tran_Van_Minh");
		response.addCookie(ck1);
		return "Da goi Cookie";
	}
	@RequestMapping(path = "/getCookies")
	@ResponseBody //neu muon return ve noidung thi phai khai bao cai nay
	public String getCookies(HttpServletRequest request) {
		Cookie[] mck = request.getCookies();
		String ten = null;
		for(Cookie ck:mck)
			if(ck.getName().equals("ten")) {
				ten = ck.getValue();
				break;
			}
		return "Ten da nhan " + ten;
	}

	@RequestMapping(path = "/getCookies2")
	@ResponseBody
	public String getCookies2(@CookieValue(name = "ten") String ten) {
		return "Ten da nhan " + ten;
	}
	
	@RequestMapping(path = "/goi-lai-1") //goi lai vao mapping qua viewresolver
	public String goiLai1() {
		return "redirect:/home";
	}
	@RequestMapping(path = "/goi-lai-2") //goi vao trang home khong qua viewresolver
	public String goiLai2() {
		return "redirect:/home.jsp";
	}

}
