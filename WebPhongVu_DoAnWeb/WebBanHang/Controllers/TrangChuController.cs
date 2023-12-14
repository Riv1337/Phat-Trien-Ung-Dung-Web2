using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WebBanHang.Models;
using System.Threading.Tasks;

namespace WebBanHang.Controllers
{
    public class TrangChuController : Controller
    {
        private QLBH_QLDA_HTMmartEntities1 db = new QLBH_QLDA_HTMmartEntities1();

        // GET: TrangChu
        private readonly IChatbotService twilioChatService;

        public TrangChuController(IChatbotService twilioChatService)
        {
            this.twilioChatService = twilioChatService;
        }

        [HttpPost]
        public async Task<ActionResult> GetChatbotResponse(string userMessage)
        {
            try
            {
                // Call the TwilioChatService to get a response
                string chatbotResponse = await twilioChatService.GetChatbotResponse(userMessage);

                // Return the response as JSON
                return Json(new { response = chatbotResponse });
            }
            catch (Exception ex)
            {
                // Handle exceptions and return an error response
                return Json(new { error = ex.Message });
            }
        }

        // Example of sending an SMS message
        [HttpPost]
        public async Task<ActionResult> SendMessage(string toPhoneNumber, string message)
        {
            try
            {
                // Call the TwilioChatService to send an SMS message
                await twilioChatService.SendMessageAsync(toPhoneNumber, message);

                // Return success response
                return Json(new { success = true });
            }
            catch (Exception ex)
            {
                // Handle exceptions and return an error response
                return Json(new { error = ex.Message });
            }
        }



        public ActionResult SortProducts(string sortOrder)
        {
            var sanPhams = db.SanPhams.Include(s => s.LoaiSP);

            switch (sortOrder)
            {
                case "desc":
                    sanPhams = sanPhams.OrderByDescending(item => item.DonGia);
                    break;
                case "asc":
                default:
                    sanPhams = sanPhams.OrderBy(item => item.DonGia);
                    break;
            }

            return PartialView("_ProductList", sanPhams.ToList());
        }

        public ActionResult Index()
        {
            var sanPhams = db.SanPhams.Include(s => s.LoaiSP);
            return View(sanPhams.ToList());
        }



        // GET: TrangChu/Details/5
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

        // GET: TrangChu/Create
        public ActionResult Create()
        {
            ViewBag.MaSLP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP");
            return View();
        }

        // POST: TrangChu/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "MaSP,TenSP,AnhSP,DVT,DonGia,MoTaSP,MaSLP")] SanPham sanPham)
        {
            if (ModelState.IsValid)
            {
                db.SanPhams.Add(sanPham);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.MaSLP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP", sanPham.MaSLP);
            return View(sanPham);
        }

        // GET: TrangChu/Edit/5
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
            return View(sanPham);
        }

        // POST: TrangChu/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "MaSP,TenSP,AnhSP,DVT,DonGia,MoTaSP,MaSLP")] SanPham sanPham)
        {
            if (ModelState.IsValid)
            {
                db.Entry(sanPham).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.MaSLP = new SelectList(db.LoaiSPs, "MaLSP", "TenLSP", sanPham.MaSLP);
            return View(sanPham);
        }

        // GET: TrangChu/Delete/5
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

        // POST: TrangChu/Delete/5
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
