package test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncFilter
 */
@WebFilter("*.jsp") // 모든 jsp파일 요청에 대해 
public class EncFilter extends HttpFilter implements Filter {
       
	private String encoding;
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// request.setCharacterEncoding("UTF-8"); // 하드코딩
		request.setCharacterEncoding(this.encoding); // web.xml(환경설정파일)에 저장되어 있던 초기화 매개변수로 교체
		System.out.println("doFilter() 동작완료");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터 클래스 최초 초기화 완료");
		// 서버가 처음 동작할 때 세팅
		// 필터를 만듦
		
		fConfig.getServletContext().getInitParameter("encoding");
		
	}

}
