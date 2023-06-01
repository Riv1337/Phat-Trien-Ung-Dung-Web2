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


import cntt.richard.QuanLyThuVienRB.models.TacGia;
import cntt.richard.QuanLyThuVienRB.repository.TacGiaRepository;

@Controller
public class TacGiaController {
	@Autowired private TacGiaRepository tacgiaRepository;

	@RequestMapping(value={"/tacgia"})
	public String listAuthor(Model model) {
		model.addAttribute("listTacGia", tacgiaRepository.findAll());
		return "dsTacGia";
	}

	@GetMapping("/Tacgiasave")
	public String insertTacGia(Model model) {
		TacGia tacgia = new TacGia();
		model.addAttribute("tacgia",tacgia);
		return "Tacgiasave";
	}
	@PostMapping("/saveTacGia")
	  public String doSaveTacGia(@ModelAttribute("TacGia") TacGia tacgia, Model model) {
	    tacgiaRepository.save(tacgia);
	    return "redirect:/tacgia";
	  }
	  @PostMapping("/update-tacgia/{id}")
		public String doUpdateTacGia(@PathVariable("id") int id,
		                             @ModelAttribute("tacgia") TacGia tacgia,
		                             BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        tacgia.setIda(id);
		        return "Tacgiaupdate";
		    }
		    tacgiaRepository.save(tacgia);
		    List<TacGia> listTacGia = tacgiaRepository.findAll();
		    model.addAttribute("listtacgia", listTacGia);
		    model.addAttribute("tacgia",tacgia);
		    return "redirect:/tacgia";
		}
	  @GetMapping("/update-tacgia/{id}")
		public String showUpdateTacGiaForm(@PathVariable("id") int id, Model model) {
		    Optional<TacGia> tacgia = tacgiaRepository.findById(id);
		    if (tacgia.isPresent()) {
		    	model.addAttribute("tacgia", tacgia.get());
		        return "Tacgiaupdate";
		    } else {
		        return "redirect:/tacgia";
		    }
		}
	  @RequestMapping("/view-tacgia/{id}")
	  public String viewTacGia(@PathVariable int id, Model model) {
	    Optional<TacGia> tacgia = tacgiaRepository.findById(id);
	    if (tacgia.isPresent()) {
	      model.addAttribute("tacgia",tacgia.get());
	    }
	    return "Tacgiaview";
	  }
	  @RequestMapping("/delete-tacgia/{id}")
		public String doDeleteTacGia(@PathVariable int id, Model model) {
		tacgiaRepository.deleteById(id);
		model.addAttribute("listTacGia", tacgiaRepository.findAll());
		return "dsTacGia";
		}
}