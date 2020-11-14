package pl.coderslab;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   /* @Override
    public void onStartup(ServletContext servletContext){
        AnnotationConfigWebApplicationContext ctx =
                new AnnotationConfigWebApplicationContext();

        ctx.register(AppConfig.class);
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");
    }*/
    @Override
    protected Class<?>[] getRootConfigClasses() { return null; }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};  }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};   }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] { new CharacterEncodingFilter("UTF-8", true) };
    }
}
