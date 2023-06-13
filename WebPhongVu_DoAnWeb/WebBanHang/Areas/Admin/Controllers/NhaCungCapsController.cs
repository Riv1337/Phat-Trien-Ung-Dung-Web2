using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WebBanHang.Models;

namespace WebBanHang.Areas.Admin.Controllers
{
    public class NhaCungCapsController : Controller
    {
        private QLBH_QLDA_HTMmartEntities1 db = new QLBH_QLDA_HTMmartEntities1();

        // GET: Admin/NhaCungCaps
        public ActionResult Index()
        {
            var nhaCungCaps = db.NhaCungCaps.Include(n => n.LoaiSP);
            return View(nhaCungCaps.ToList());
        }

        // GET: Admin/NhaCungCaps/Details/5
        public ActionResult Details(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            NhaCungCap nhaCungCap = db.NhaCungCaps.Find(id);
            if (nhaCungCap == null)
            {
                return HttpNotFound();
            }
            return View(nhaCungCap);
        }

        // GET: Admin/NhaCungCaps/Create
        public ActionResult Create()
        {
            ViewBag.MLSP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP");
            return View();
        }

        // POST: Admin/NhaCungCaps/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "MaNCC,TenNCC,DiaChi,SDT_NCC,Email,MLSP")] NhaCungCap nhaCungCap)
        {
            if (ModelState.IsValid)
            {
                db.NhaCungCaps.Add(nhaCungCap);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.MLSP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP", nhaCungCap.MLSP);
            return View(nhaCungCap);
        }

        // GET: Admin/NhaCungCaps/Edit/5
        public ActionResult Edit(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            NhaCungCap nhaCungCap = db.NhaCungCaps.Find(id);
            if (nhaCungCap == null)
            {
                return HttpNotFound();
            }
            ViewBag.MLSP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP", nhaCungCap.MLSP);
            return View(nhaCungCap);
        }

        // POST: Admin/NhaCungCaps/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "MaNCC,TenNCC,DiaChi,SDT_NCC,Email,MLSP")] NhaCungCap nhaCungCap)
        {
            if (ModelState.IsValid)
            {
                db.Entry(nhaCungCap).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.MLSP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP", nhaCungCap.MLSP);
            return View(nhaCungCap);
        }

        // GET: Admin/NhaCungCaps/Delete/5
        public ActionResult Delete(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            NhaCungCap nhaCungCap = db.NhaCungCaps.Find(id);
            if (nhaCungCap == null)
            {
                return HttpNotFound();
            }
            return View(nhaCungCap);
        }

        // POST: Admin/NhaCungCaps/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(string id)
        {
            NhaCungCap nhaCungCap = db.NhaCungCaps.Find(id);
            db.NhaCungCaps.Remove(nhaCungCap);
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
