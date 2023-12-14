using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WebBanHang.Models;
using WebBanHang.ViewModels;

namespace WebBanHang.Controllers
{
    public class GioHangsController : Controller
    {
        private QLBH_QLDA_HTMmartEntities1 db = new QLBH_QLDA_HTMmartEntities1();




        public ActionResult Index()
        {
            List<CartItem> giohang = Session["giohang"] as List<CartItem>;
            return View(giohang);

        }


        public ActionResult NhapThongTin()
        {
            List<CartItem> giohang = Session["giohang"] as List<CartItem>;
            ClientInfoViewModel clientInfo = new ClientInfoViewModel(); // Initialize with default values
            CheckoutViewModel checkoutViewModel = new CheckoutViewModel
            {
                CartItems = giohang,
                ClientInfo = clientInfo
            };
            return View(checkoutViewModel);
        }



        public RedirectToRouteResult ThemVaoGio(String MaSP)
        {
            if (Session["giohang"] == null) // Nếu giỏ hàng chưa được khởi tạo
            {
                Session["giohang"] = new List<CartItem>();  // Khởi tạo Session["giohang"] là 1 List<CartItem>
            }

            List<CartItem> giohang = Session["giohang"] as List<CartItem>;  // Gán qua biến giohang dễ code

            // Kiểm tra xem sản phẩm khách đang chọn đã có trong giỏ hàng chưa

            if (giohang.FirstOrDefault(m => m.MaSP == MaSP) == null) // ko co sp nay trong gio hang
            {
                SanPham sp = db.SanPhams.Find(MaSP);  // tim sp theo MaSP

                CartItem newItem = new CartItem()
                {
                    MaSP = MaSP,
                    TenSP = sp.TenSP,
                    SoLuong = 1,
                    AnhSP = sp.AnhSP,
                    DonGia = (float)sp.DonGia

                };  // Tạo ra 1 CartItem mới

                giohang.Add(newItem);  // Thêm CartItem vào giỏ 
            }
            else
            {
                // Nếu sản phẩm khách chọn đã có trong giỏ hàng thì không thêm vào giỏ nữa mà tăng số lượng lên.
                CartItem cardItem = giohang.FirstOrDefault(m => m.MaSP == MaSP);
                cardItem.SoLuong++;
            }

            // Action này sẽ chuyển hướng về trang chi tiết sp khi khách hàng đặt vào giỏ thành công. Bạn có thể chuyển về chính trang khách hàng vừa đứng bằng lệnh return Redirect(Request.UrlReferrer.ToString()); nếu muốn.
            return RedirectToAction("Index", "TrangChu");
        }

        [HttpPost]


        public RedirectToRouteResult SuaSoLuong(String MaSP, int soluongmoi)
        {
            // tìm carditem muon sua
            List<CartItem> giohang = Session["giohang"] as List<CartItem>;
            CartItem itemSua = giohang.FirstOrDefault(m => m.MaSP == MaSP);
            if (itemSua != null)
            {
                itemSua.SoLuong = soluongmoi;
            }
            return RedirectToAction("Index");
        }

        public RedirectToRouteResult XoaKhoiGio(String MaSP)
        {
            List<CartItem> giohang = Session["giohang"] as List<CartItem>;
            CartItem itemXoa = giohang.FirstOrDefault(m => m.MaSP == MaSP);
            if (itemXoa != null)
            {
                giohang.Remove(itemXoa);
            }
            return RedirectToAction("Index");
        }

    }
}
