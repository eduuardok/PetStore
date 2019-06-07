package filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 
 * @author ELuna
 *
 */
@WebFilter(filterName = "FiltroLogin", urlPatterns = {"/WEB-INF/jsp/*"}, servletNames = {"adotarDog", "cadastroCachorro", "listaDogs", "home"})
public class FiltroLogin implements Filter {
	
		 @Override
		    public void doFilter(
	                    
		            ServletRequest request,
		            ServletResponse response,
		            FilterChain chain) throws IOException, ServletException {
		        
	            
		        HttpServletRequest httpRequest = (HttpServletRequest) request;
		        HttpServletResponse httpResponse = (HttpServletResponse) response;
		    
		        
		        HttpSession sessao = httpRequest.getSession();
		        
		        
		        if (sessao.getAttribute("isLogado") == null || (boolean) sessao.getAttribute("isLogado") == false) {
		        	
		            httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
		            return;
		        }

		        if ((boolean) sessao.getAttribute("isLogado")) {
		           
		            chain.doFilter(request, response);
		            
		        } else {
		        	httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
		        }
		        
		    }
		 
		 
		     
		 
		    @Override
		    public void init(FilterConfig filterConfig) throws ServletException {
		    }

		    @Override
		    public void destroy() {
		    }

	}
		


	

