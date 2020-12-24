package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beans.LoaiSua;
import businessLogics.LoaiSuaBL;

@Controller
@RequestMapping("/loaisua")
public class LoaiSuaController {
	@RequestMapping("/them")		//ngam dinh method=RequestMethod.GET
	public String them() {
		return "them-loai-sua";
	}
	
//	@RequestMapping(path = "/them", method = RequestMethod.POST)
//	public String them(HttpServletRequest request) 
//	{
//		String maLoai,tenLoai;
//		maLoai = request.getParameter("txtMaLoai");
//		tenLoai = request.getParameter("txtTenLoai");
//		
//		System.out.println("here");
//		LoaiSua ls = new LoaiSua();
//		ls.setMaLoai(maLoai);
//		ls.setTenLoai(tenLoai);
//		
//		LoaiSuaBL.them(ls);
//		request.setAttribute("maLoai", maLoai);
//		return "them-loai-sua";
//	}
	
	@RequestMapping(path = "/danh-sach")
	public String danhsach(Model model)
	{
		model.addAttribute("dsls", LoaiSuaBL.docTatCa());
		return "loai-sua";
	}
	
	@RequestMapping(path = "/danh-sach/{maLoai}")
	public String danhSach(@PathVariable(name = "maLoai") String ml, Model model) 
	{
		LoaiSua ls = LoaiSuaBL.tim(ml);
		List<LoaiSua> dsls = new ArrayList<>();
		dsls.add(ls);
		model.addAttribute("dsls", dsls);
		return "loai-sua";
	}
	
	@RequestMapping(path = "/them", method = RequestMethod.POST)
	public String them(@RequestParam("txtMaLoai") String maLoai,@RequestParam("txtTenLoai") String tenLoai, Model model) 
	{
//		String maLoai,tenLoai;
//		maLoai = request.getParameter("txtMaLoai");
//		tenLoai = request.getParameter("txtTenLoai");
		
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(maLoai);
		ls.setTenLoai(tenLoai);
		
		LoaiSuaBL.them(ls);
		model.addAttribute("maLoai", maLoai);
		model.addAttribute("tenLoai", tenLoai);
		return "them-loai-sua";
	}
}