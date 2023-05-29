package controllers;
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

	@GetMapping("/BMIForm")
	public String BMI(@RequestParam("h") int cc, @RequestParam("w") int cn,Model m) {
		m.addAttribute("hhh", cc);
		m.addAttribute("www", cn);
		m.addAttribute("kq", cc/(cn*cn));
		return "BMIForm";
	}
	@PostMapping("/BMICalc")
	public String BMIPost(@RequestParam("h") int cc, @RequestParam("w") int cn,Model m) {
		m.addAttribute("hhh", cc);
		m.addAttribute("www", cn);
		m.addAttribute("bmikq", cc/(cn*cn));
		return "BMICalc";
	}
}
