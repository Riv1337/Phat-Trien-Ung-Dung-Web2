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


import cntt.richard.QuanLyThuVienRB.models.Sach;
import cntt.richard.QuanLyThuVienRB.models.TacGia;
import cntt.richard.QuanLyThuVienRB.models.LoaiSach;
import cntt.richard.QuanLyThuVienRB.models.NhaXuatBan;
import cntt.richard.QuanLyThuVienRB.repository.TacGiaRepository;
import cntt.richard.QuanLyThuVienRB.repository.LoaiSachRepository;
import cntt.richard.QuanLyThuVienRB.repository.NhaXuatBanRepository;
import cntt.richard.QuanLyThuVienRB.repository.SachRepository;


@Controller
public class SachController {
	@Autowired private SachRepository sachRepository;
	@Autowired private LoaiSachRepository loaisachRepository;
	@Autowired private NhaXuatBanRepository nhaxuatbanRepository;
	@Autowired private TacGiaRepository tacgiaRepository;
	
	@RequestMapping(value={"/sach"})
	public String listBook(Model model) {
		model.addAttribute("listSach", sachRepository.findAll());
		return "dsSach";
	}

	@GetMapping("/Sachsave")
	public String insertSach(Model model) {
		Sach sach = new Sach();
		List<LoaiSach> listLoai=loaisachRepository.findAll();
		List<TacGia> listTacGia=tacgiaRepository.findAll();
		List<NhaXuatBan> listNhaXuatBan= nhaxuatbanRepository.findAll();
		model.addAttribute("sach",sach);
		model.addAttribute("loaisach",listLoai);
		model.addAttribute("tacgia",listTacGia);
		model.addAttribute("nhaxuatban",listNhaXuatBan);
		return "Sachsave";
	}
	@PostMapping("/saveSach")
	  public String doSaveSach(@ModelAttribute("Sach") Sach sach, Model model) {
	    sachRepository.save(sach);
	    return "redirect:/sach";
	  }
	  @PostMapping("/update-sach/{id}")
		public String doUpdateSach(@PathVariable("id") int id,
		                             @ModelAttribute("sach") Sach sach,
		                             BindingResult result, Model model) {
		    if (result.hasErrors()) {
		        sach.setId(id);
		        return "Sachupdate";
		    }
		    sachRepository.save(sach);
		    List<Sach> listSach = sachRepository.findAll();
		    model.addAttribute("listsach", listSach);
		    model.addAttribute("sach", sach);
		    List<LoaiSach> listLoai = loaisachRepository.findAll();
		    model.addAttribute("loaisach", listLoai);
		    List<TacGia> listTacGia=tacgiaRepository.findAll();
			List<NhaXuatBan> listNhaXuatBan= nhaxuatbanRepository.findAll();
		    model.addAttribute("tacgia",listTacGia);
			model.addAttribute("nhaxuatban",listNhaXuatBan);
		    return "redirect:/sach";
		}
	  @GetMapping("/update-sach/{id}")
		public String showUpdateSachForm(@PathVariable("id") int id, Model model) {
		    Optional<Sach> sach = sachRepository.findById(id);
		    if (sach.isPresent()) {
		        model.addAttribute("sach", sach.get());
		        
		        List<LoaiSach> listLoai = loaisachRepository.findAll();
		        model.addAttribute("loaisach", listLoai);
		        List<TacGia> listTacGia=tacgiaRepository.findAll();
				List<NhaXuatBan> listNhaXuatBan= nhaxuatbanRepository.findAll();
			    model.addAttribute("tacgia",listTacGia);
				model.addAttribute("nhaxuatban",listNhaXuatBan);
		        return "Sachupdate";
		    } else {
		        return "redirect:/sach";
		    }
		}
	  @RequestMapping("/view-sach/{id}")
	  public String viewSach(@PathVariable int id, Model model) {
	    Optional<Sach> sach = sachRepository.findById(id);
	    if (sach.isPresent()) {
	    	model.addAttribute("sach", sach.get());
	        List<LoaiSach> listLoai = loaisachRepository.findAll();
	        model.addAttribute("loaisach", listLoai);
	        List<TacGia> listTacGia=tacgiaRepository.findAll();
		    model.addAttribute("tacgia",listTacGia);
			List<NhaXuatBan> listNhaXuatBan= nhaxuatbanRepository.findAll();
			model.addAttribute("nhaxuatban",listNhaXuatBan);
	    }
	    return "Sachview";
	  }
	  @RequestMapping("/delete-sach/{id}")
		public String doDeleteSach(@PathVariable int id, Model model) {
		sachRepository.deleteById(id);
		model.addAttribute("listSach", sachRepository.findAll());
		return "dsSach";
		}

}
