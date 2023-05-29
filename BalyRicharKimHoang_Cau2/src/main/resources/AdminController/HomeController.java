package AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

		@RequestMapping("/index",method=RequestMethod.GET)
		public String trangChu()
		{
			return "AdminCP/index.jsp";
		}
