using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using WebBanHang.Models;


namespace WebBanHang.Models
{
    public class HomeModel
    {
        public List<NhanVien> ListNhanVien { get; set; }
        public List<SanPham> ListSanPham { get; set; }
        public List<NhaCungCap> ListNhaCungCap { get; set; }


        public List<GioHang> ListHoaDon { get; set; }
        public List<CTGH> ListCTHoaDon { get; set; }



        public List<KhachHang> ListKhachHang { get; set; }


        public String HinhSP { get; set; }

        public String MaSP { get; set; }

        public String MaKH { get; set; }


        public String TenSP { get; set; }

        public int SoLuong { get; set; }




    }
}