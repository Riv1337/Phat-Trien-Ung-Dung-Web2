using System.Web.Mvc;
using System.Web.Optimization;
using System.Web.Routing;
using Unity;
using Unity.Mvc5;
using WebBanHang.Controllers;

namespace WebBanHang
{
    public class MvcApplication : System.Web.HttpApplication
    {
        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();
            FilterConfig.RegisterGlobalFilters(GlobalFilters.Filters);
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            BundleConfig.RegisterBundles(BundleTable.Bundles);

            RegisterServices();
        }

        private void RegisterServices()
        {
            var container = new UnityContainer();
            container.RegisterType<TwilioChatService>(); // Replace ChatbotService with TwilioChatService

            DependencyResolver.SetResolver(new UnityDependencyResolver(container));
        }
        /*protected void Session_Start()
        {
            Session["UserAdmin"] = "";
            Session["UserID"] = "";
            Session["MyCart"] = "";
        }*/
    }
}
