package cntt.richard.QuanLyThuVienRB.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import cntt.richard.QuanLyThuVienRB.models.NhaXuatBan;
import cntt.richard.QuanLyThuVienRB.repository.NhaXuatBanRepository;

@Controller
public class NhaXuatBanController {
	@Autowired private NhaXuatBanRepository nhaxuatbanRepository;

	@RequestMapping(value={"/nhaxuatban"})
	public String listNhaXuatBan(Model model) {
		model.addAttribute("listNhaXuatBan", nhaxuatbanRepository.findAll());
		return "dsNhaXuatBan";
	}

	@GetMapping("/Nhaxuatbansave")
	public String insertNhaXuatBan(Model model) {
		NhaXuatBan nhaxuatban = new NhaXuatBan();
		model.addAttribute("nhaxuatban",nhaxuatban);
		return "Nhaxuatbansave";
	}
	@PostMapping("/saveNhaXuatBan")
	  public String doSaveNhaXuatBan(@ModelAttribute("NhaXuatBan") NhaXuatBan nhaxuatban, Model model) {
		nhaxuatbanRepository.save(nhaxuatban);
	    return "redirect:/nhaxuatban";
	  }
	  @PostMapping("/update-nhaxuatban/{id}")
		public String doUpdateNhaXuatBan(@PathVariable("id") int id,
		                             @ModelAttribute("nhaxuatban") NhaXuatBan nhaxuatban,
		                             BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        nhaxuatban.setId(id);
		        return "Nhaxuatbanupdate";
		    }
		    nhaxuatbanRepository.save(nhaxuatban);
		    List<NhaXuatBan> listNhaXuatBan = nhaxuatbanRepository.findAll();
		    model.addAttribute("listnhaxuatban", listNhaXuatBan);
		    model.addAttribute("nhaxuatban",nhaxuatban);
		    return "redirect:/nhaxuatban";
		}
	  @GetMapping("/update-nhaxuatban/{id}")
		public String showUpdateNhaXuatBanForm(@PathVariable("id") int id, Model model) {
		    Optional<NhaXuatBan> nhaxuatban = nhaxuatbanRepository.findById(id);
		    if (nhaxuatban.isPresent()) {
		    	model.addAttribute("nhaxuatban",nhaxuatban.get());
		        return "Nhaxuatbanupdate";
		    } else {
		        return "redirect:/nhaxuatban";
		    }
		}
	  @RequestMapping("/view-nhaxuatban/{id}")
	  public String viewNhaXuatBan(@PathVariable int id, Model model) {
	    Optional<NhaXuatBan> nhaxuatban = nhaxuatbanRepository.findById(id);
	    if (nhaxuatban.isPresent()) {
	      model.addAttribute("nhaxuatban",nhaxuatban.get());
	    }
	    return "Nhaxuatbanview";
	  }
	  @RequestMapping("/delete-nhaxuatban/{id}")
		public String doDeleteNhaXuatBan(@PathVariable int id, Model model) {
		  nhaxuatbanRepository.deleteById(id);
		model.addAttribute("listNhaXuatBan", nhaxuatbanRepository.findAll());
		return "dsNhaXuatBan";
		}
}