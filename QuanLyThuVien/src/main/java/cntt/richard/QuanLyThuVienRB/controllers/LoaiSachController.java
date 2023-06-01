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

import cntt.richard.QuanLyThuVienRB.models.LoaiSach;
import cntt.richard.QuanLyThuVienRB.models.NhaXuatBan;
import cntt.richard.QuanLyThuVienRB.models.Sach;
import cntt.richard.QuanLyThuVienRB.models.TacGia;
import cntt.richard.QuanLyThuVienRB.repository.LoaiSachRepository;
import cntt.richard.QuanLyThuVienRB.repository.NhaXuatBanRepository;
import cntt.richard.QuanLyThuVienRB.repository.SachRepository;
import cntt.richard.QuanLyThuVienRB.repository.TacGiaRepository;

@Controller
public class LoaiSachController {
	@Autowired private LoaiSachRepository loaisachRepository;

	@RequestMapping(value={"/loaisach"})
	public String listType(Model model) {
		model.addAttribute("listLoaiSach", loaisachRepository.findAll());
		return "dsLoaiSach";
	}

	@GetMapping("/Loaisachsave")
	public String insertLoaiSach(Model model) {
		LoaiSach loaisach = new LoaiSach();
		model.addAttribute("loaisach",loaisach);
		return "Loaisachsave";
	}
	@PostMapping("/saveLoaiSach")
	  public String doSaveLoaiSach(@ModelAttribute("LoaiSach") LoaiSach loaisach, Model model) {
	    loaisachRepository.save(loaisach);
	    return "redirect:/loaisach";
	  }
	  @PostMapping("/update-loaisach/{id}")
		public String doUpdateLoaiSach(@PathVariable("id") int id,
		                             @ModelAttribute("loaisach") LoaiSach loaisach,
		                             BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        loaisach.setId(id);
		        return "Loaisachchupdate";
		    }
		    loaisachRepository.save(loaisach);
		    List<LoaiSach> listLoaiSach = loaisachRepository.findAll();
		    model.addAttribute("listsach", listLoaiSach);
		    model.addAttribute("sach",loaisach);
		    return "redirect:/loaisach";
		}
	  @GetMapping("/update-loaisach/{id}")
		public String showUpdateLoaiSachForm(@PathVariable("id") int id, Model model) {
		    Optional<LoaiSach> loaisach = loaisachRepository.findById(id);
		    if (loaisach.isPresent()) {
		    	model.addAttribute("loaisach", loaisach.get());
		        return "Loaisachupdate";
		    } else {
		        return "redirect:/loaisach";
		    }
		}
	  @RequestMapping("/view-loaisach/{id}")
	  public String viewLoaiSach(@PathVariable int id, Model model) {
	    Optional<LoaiSach> loaisach = loaisachRepository.findById(id);
	    if (loaisach.isPresent()) {
	      model.addAttribute("loaisach",loaisach.get());
	    }
	    return "Loaisachview";
	  }
	  @RequestMapping("/delete-loaisach/{id}")
		public String doDeleteLoaiSach(@PathVariable int id, Model model) {
		loaisachRepository.deleteById(id);
		model.addAttribute("listLoaiSach", loaisachRepository.findAll());
		return "dsLoaiSach";
		}
}
