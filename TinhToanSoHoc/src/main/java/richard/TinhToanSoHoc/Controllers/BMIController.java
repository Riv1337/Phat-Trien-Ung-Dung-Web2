package richard.TinhToanSoHoc.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class BMIController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("BMI")
	public String BMI() {
		return "BMI"; 
	}
	
	@GetMapping("/BMIForm")
	public String BMIGet(@RequestParam("h") float cc, @RequestParam("w") int cn,Model m) {
		m.addAttribute("hhh", cc);
		m.addAttribute("www", cn);
		m.addAttribute("kq", cc/(cn*cn));
		return "BMIForm";
	}
	@PostMapping("/BMICalc")
	public String BMIPost(@RequestParam("h") float cc, @RequestParam("w") int cn,Model m) {
		double bmi = cn/Math.pow((double)cc/100,2);
		m.addAttribute("hhh", cc);
		m.addAttribute("www", cn);
		m.addAttribute("bmikq", bmi);
		return "BMICalc";
	}
}
