using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.SqlClient;
using WebBanHang.Models;
using System.Net;

namespace WebBanHang.Controllers
{
    public class AccountLoginController : Controller
    {
        private QLBH_QLDA_HTMmartEntities1 db = new QLBH_QLDA_HTMmartEntities1();
        // GET: AccountLogin
        SqlCommand com = new SqlCommand();
        SqlConnection con = new SqlConnection();
        SqlDataReader dr;
        public ActionResult Login()
        {
            if (Session["loginName"] == null)
            {
                return RedirectToAction("Index", "AccountLogin");
            }
            else
            {

                string Email = Session["loginName"].ToString();

                HomeModel objHomeModel2 = new HomeModel();
                objHomeModel2.ListKhachHang = db.KhachHangs.Where(n => n.Email == Email).ToList();

                return View(objHomeModel2);

            }

        }



        public ActionResult Index()
        {
            return View();
        }
        public ActionResult Register()
        {
            return View();
        }

        // POST: Admin/KhachHangs/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Register([Bind(Include = "MaKH,HoTen,DiaChi,NgaySinh,MatKhau,Email")] KhachHang khachHang)
        {

            if (ModelState.IsValid)
            {
                db.KhachHangs.Add(khachHang);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(khachHang);
        }
        public void connectionString() {
            con.ConnectionString = "data source=DESKTOP-14DA0RI\\SQLEXPRESS;initial catalog=QLBH_QLDA_HTMmart;integrated security=True;MultipleActiveResultSets=True;App=EntityFramework&quot;";
        }
        [HttpPost]
        public ActionResult Verify(KhachHang khachHang)
        {
            connectionString();
            con.Open();
            com.Connection = con;
            com.CommandText = "select * from KhachHang where Email='" + khachHang.Email + "'and password ='" + khachHang.MatKhau + "'";
            dr = com.ExecuteReader();
            if (dr.Read())
            {
                con.Close();
                return View("Index","TrangChu");
            }
            else
            {
                con.Close();
                return View("Error");
            }
            
        }
    }
}