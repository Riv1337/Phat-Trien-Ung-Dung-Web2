package richard.TinhToanSoHoc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TinhToanController {
	@GetMapping("/add")
	public String traVeFormTinh() {
		return "TinhTong";
	}
	@GetMapping("/addCal")
	public String tinhTong(@RequestParam("a") int soA, @RequestParam("b") int soB,Model m) {
		m.addAttribute("aaa", soA);
		m.addAttribute("bbb", soB);
		m.addAttribute("kq", soA+soB);
		return "TinhTong";
	}
	@PostMapping("/addCalPost")
	public String tinhTongPost(@RequestParam("a") int soA, @RequestParam("b") int soB,Model m) {
		m.addAttribute("aaa", soA);
		m.addAttribute("bbb", soB);
		m.addAttribute("kq", soA+soB);
		return "TinhTong";
	}

}

