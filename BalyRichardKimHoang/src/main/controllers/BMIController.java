package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BMIController {		
		@RequestMapping("/bmi",method=RequestMethod.GET)
		public String bmi()
		{
			return "views/bmi";
		}
		@RequestMapping("/bmi",method=RequestMethod.POST)
		public String bmi(ModelMap model,HttpServletRequest request)
		{
			String height=request.getParameter("height");
			String weight=request.getParameter("weight");
			String bmiRes=weight/(height*height);
			model.addAttribute("message",bmiRes);
			return "views/bmi"
		}