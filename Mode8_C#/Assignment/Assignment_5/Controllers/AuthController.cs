using Microsoft.AspNetCore.Mvc;
using userRegister.Models;
using userRegister.Service;

namespace userRegister.Controllers
{
    public class AuthController : Controller
    {
        private readonly UserService _userService;

        public AuthController(UserService userService)
        {
            _userService = userService;
        }

        [HttpGet]
        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Login(User user)
        {
            if (_userService.Validate(user.Email, user.Password))
                return RedirectToAction("Index", "Home");
            ModelState.AddModelError("", "Invalid email or password");
            return View();
        }

        [HttpGet]
        public IActionResult Register()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Register(User user)
        {
            _userService.Register(user);
            return RedirectToAction("Login");
        }
    }
}