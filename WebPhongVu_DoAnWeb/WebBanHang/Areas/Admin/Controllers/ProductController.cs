using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using System.IO;
using WebBanHang.Models;


namespace WebBanHang.Areas.Admin.Controllers
{
    public class ProductController : Controller
    {
        private QLBH_QLDA_HTMmartEntities1 db = new QLBH_QLDA_HTMmartEntities1();

        // GET: Admin/Product
        public ActionResult Index()
        {
            var sanPhams = db.SanPhams.Include(s => s.LoaiSP);
            return View(sanPhams.ToList());
        }

        // GET: Admin/Product/Details/5
        public ActionResult Details(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            SanPham sanPham = db.SanPhams.Find(id);
            if (sanPham == null)
            {
                return HttpNotFound();
            }
            return View(sanPham);
        }

        // GET: Admin/Product/Create
        public ActionResult Create()
        {
            ViewBag.MaSLP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP");
            ViewBag.ListMaSLP = new SelectList(db.LoaiSPs.ToList(), "MaLSP", "TenLSP", 0);
            return View();
        }

        // POST: Admin/Product/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(SanPham sanPham, HttpPostedFileBase file)
        {
            if (ModelState.IsValid)
            {
                //string maImg = sanPham.TenSP;
                var Img = Request.Files["fileimg"];
                string[] FileExtension = { ".jpg", ".png", ".gif" };
                if (Img.ContentLength != 0)
                {
                    if (FileExtension.Contains(Img.FileName.Substring(Img.FileName.LastIndexOf("."))))
                    {
                        string imgName = Img.FileName;
                        
                        sanPham.AnhSP = imgName;
                        string PathImg = Path.Combine(Server.MapPath("~/Public/Images"), Img.FileName);
                        Img.SaveAs(PathImg);
                    }
                }


                db.SanPhams.Add(sanPham);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.MaSLP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP", sanPham.MaSLP);
            ViewBag.ListMaSLP = new SelectList(db.LoaiSPs.ToList(), "MaLSP", "TenLSP", 0);
            return View(sanPham);
        }

        // GET: Admin/Product/Edit/5
        public ActionResult Edit(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            SanPham sanPham = db.SanPhams.Find(id);
            if (sanPham == null)
            {
                return HttpNotFound();
            }
            ViewBag.MaSLP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP", sanPham.MaSLP);
            ViewBag.ListMaSLP = new SelectList(db.LoaiSPs.ToList(), "MaLSP", "TenLSP", 0);
            return View(sanPham);
        }

        // POST: Admin/Product/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit( SanPham sanPham)
        {
            if (ModelState.IsValid)
            {
                string maImg = sanPham.TenSP;
                var Img = Request.Files["fileimg"];
                string[] FileExtension = { ".jpg", ".png", ".gif" };
                if (Img.ContentLength != 0)
                {
                    if (FileExtension.Contains(Img.FileName.Substring(Img.FileName.LastIndexOf("."))))
                    {
                        string imgName = maImg + Img.FileName.Substring(Img.FileName.LastIndexOf("."));
                        sanPham.AnhSP = imgName;
                        string PathImg = Path.Combine(Server.MapPath("~/Public/Images"), Img.FileName);
                        Img.SaveAs(PathImg);
                    }
                }
                db.Entry(sanPham).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.MaSLP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP", sanPham.MaSLP);
            ViewBag.ListMaSLP = new SelectList(db.LoaiSPs.ToList(), "MaLSP", "TenLSP", 0);
            return View(sanPham);
        }

        // GET: Admin/Product/Delete/5
        public ActionResult Delete(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            SanPham sanPham = db.SanPhams.Find(id);
            if (sanPham == null)
            {
                return HttpNotFound();
            }
            return View(sanPham);
        }

        // POST: Admin/Product/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(string id)
        {
            SanPham sanPham = db.SanPhams.Find(id);
            db.SanPhams.Remove(sanPham);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
