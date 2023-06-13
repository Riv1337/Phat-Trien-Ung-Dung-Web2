using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebBanHang.Models
{
    public class CartItem
    {
        public String AnhSP { get; set; }
        public String MaSP { get; set; }
        public String TenSP { get; set; }

        public float DonGia { get; set; }
        public int SoLuong { get; set; }
        public float ThanhTien
        {
            get
            {
                return SoLuong * DonGia;
            }
        }


    }
}