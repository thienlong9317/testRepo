package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Category;
import model.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController 
{
	CategoryRepository repository = new CategoryRepository();
	
	@RequestMapping("danhsach")
	public String danhsach(Model model) 
	{
		model.addAttribute("list", repository.getCategory());
		//System.out.println(repository.getAuthors().size());
		return "category.index";	
	}
	
	@RequestMapping("add")
	public String add(Model model) 
	{
		List<Category> list = repository.getParents();
		Map<Integer, String> map = new HashMap<>();
		for (Category item : list) 
		{
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", new Category());
		return "category.add";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Model model, Category obj) 
	{
		repository.add(obj);
		return "redirect:/category/danhsach";
	}
	
	@RequestMapping("xoa")
	public String xoa() 
	{
		return "category.xoa";
	}
	@RequestMapping("xoa/{id}")
	public String delete (@PathVariable("id") int id) 
	{
		repository.delete(id);
		return "redirect:/category/danhsach";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") int id) 
	{
		List<Category> list = repository.getParents();
		Map<Integer, String> map = new HashMap<>();
		for (Category item : list) 
		{
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", repository.getCategory(id));
		return "category.edit";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.POST)
	public String edit(Model model, Category obj, @PathVariable("id") int id) 
	{
		repository.edit(obj);
		return "redirect:/category/danhsach";
	}
}
