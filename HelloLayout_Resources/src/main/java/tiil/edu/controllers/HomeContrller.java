package tiil.edu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeContrller {

		@RequestMapping("/home")
		public String trangChu()
		{
			return "home";
		}
		
		@RequestMapping("/about")
		public String gioiThieu()
		{
			return "about";
		}
		
		@RequestMapping("/en")
		public String tiengAnh()
		{
			return "en";
		}
		
		@RequestMapping("/vi")
		public String tiengViet()
		{
			return "vi";
		}
		
}
