package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(path="/")
	public String home()
	{
		return "trangchu"; //neu lam tiles thi day la ten dinh nghia trong definition
	}
}
