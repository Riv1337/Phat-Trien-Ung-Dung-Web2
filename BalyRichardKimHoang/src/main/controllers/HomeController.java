package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

		@RequestMapping("/index",method=RequestMethod.GET)
		public String trangChu()
		{
			return "views/index.jsp";
		}
		
		@RequestMapping("/about",method=RequestMethoid.GET)
		public String gioiThieu()
		{
			return "views/about.jsp";
		}