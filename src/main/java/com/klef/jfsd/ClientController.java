package com.klef.jfsd;

import javax.jws.WebParam.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController 
{
	@RequestMapping(path="/",method = RequestMethod.GET)
	public ModelAndView demo(){
		ModelAndView mv= new ModelAndView();
		mv.setViewName("demo");//demo is view name or jsp file name
		return mv;
	}
	@GetMapping(path="/demo1")
	public ModelAndView demo1() 
	{
		ModelAndView mv=new ModelAndView("demo1");
		return mv;
	}
	@GetMapping("/demo2")
	public ModelAndView demo2() 
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("demo2");
		return mv;
	}
	@GetMapping("demo3")
	@ResponseBody
	public String demo3() 
	{
		return "JFSD S31";
	}
	@GetMapping("add")
	@ResponseBody
	public String add(@RequestParam("a") int x,@RequestParam("b") int y) 
	{
		int z=x+y;
		return Integer.toString(z);
	}
	@GetMapping("dispalyname")
	@ResponseBody
	public String displayname(@RequestParam("i") String i,@RequestParam("j") String j) 
	{
		return i+" "+j;
	}
	@GetMapping("displayid")
	@ResponseBody
	public String displayid(@RequestParam("id") int eid) 
	{
		return Integer.toString(eid);
	}
	@GetMapping("viewname/{fname}/{lname}")
	@ResponseBody
	public String viewname(@PathVariable("fname")String a,@PathVariable("lname")String b) {
		return a+" "+b; 
	}
	@GetMapping("viewid/{id}")
	@ResponseBody
	public String viewid(@PathVariable("id") int eid) {
		return Integer.toString(eid);
		
	}
	@GetMapping("mul/{a}/{b}")
	@ResponseBody
	public String mul(@PathVariable("a")int x,@PathVariable("b") int y) {
		int z=x*y;
		return Integer.toString(z);
	}
	@GetMapping("display")
	public ModelAndView display() {
		ModelAndView mv=new ModelAndView("display");
		mv.addObject("name","Fahim");
		return mv;
	}
	@GetMapping("sub")
	public ModelAndView sub(@RequestParam("a")int x,@RequestParam("b")int y){
	
		int output=x+y;
		ModelAndView mv= new ModelAndView();
		mv.setViewName("output");
		mv.addObject("result",output);
		return mv;
	}
	@GetMapping("show/{fname}/{lname}")
	public ModelAndView show(@PathVariable("fname")String x,@PathVariable("lname")String y) {
		String name=x+" "+y;
		ModelAndView mv=new ModelAndView("show");
		mv.addObject("fname",x.toUpperCase());
		mv.addObject("lname",y.toUpperCase());
		mv.addObject("name", name.toUpperCase());
		return mv;
	}

}
