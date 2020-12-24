package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import model.ProductRepository;

@Controller
@RequestMapping("home")
public class ProductController 
{
	ProductRepository repository = new ProductRepository();
	private static int size = 6;
	@RequestMapping(value= {"danhsach", "danhsach/{p}"})
	public String index(Model model, @PathVariable(value ="p", required = false) Integer p) 
	{
		model.addAttribute("title", "Mini Shop");
		model.addAttribute("n", (int)Math.ceil(repository.count() / (double)size));
		model.addAttribute("list", repository.getProducts(1, size));
		return "home.index";
	}
}
