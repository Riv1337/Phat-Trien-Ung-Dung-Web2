package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hellocontroller {
	@GetMapping("/")
	public String trangchu() {
		return "index";
	}
	@GetMapping("/about")
	public String gioithieu() {
		return "about";
	}
	@GetMapping("/login")
	public String dangnhap() {
		return "login";
	}
}