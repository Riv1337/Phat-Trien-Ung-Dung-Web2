package jp.vs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginGet() {
		return "login";
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(ModelMap model, HttpServletRequest request) {
		//Xử lý đăng nhập
		//Lấy thông ti user submit
		String id = request.getParameter("id");
		String pass = request.getParameter("pwd");
		//tiếp theo ta truy vấn bảng usrer, để tìm xem có không
		//nếu có thì đăng nhập thành công và ngược lại
		//-----bài này ta bỏ qua bước truy cập csdl
		//ta hard code vào đây
		if (id.equals("admin") && pass.equals("62cnttclc")) {
			//đăng nhập thành công
			return "redirect: admincp/index.html";
		}else {
			//gửi báo lỗi ra trang đăng nhập
			//??
			//đăng nhập thất bại
			model.addAttribute("thongbaoLoi", "Thông tin đăng nhập không đúng");
			return "login";
		}
	}
}

