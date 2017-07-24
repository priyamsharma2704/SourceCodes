using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MvcApp.Models; 

namespace MvcApp.Controllers
{
    public class StudentController : Controller
    {
        // GET: Student
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Student()
        {
            return View();
        }
        [HttpPost]
        public ActionResult Student(StudentModel obj)
        {
            ViewBag.Msg = "The student having name " + obj.Name + " of class " + obj.Class + " added.";
            return View();
        }
    }
}