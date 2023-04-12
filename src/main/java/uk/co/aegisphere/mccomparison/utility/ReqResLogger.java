package uk.co.aegisphere.mccomparison.utility;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class ReqResLogger implements Filter {

  private final static Logger LOG = LoggerFactory.getLogger(ReqResLogger.class);


  @Override
  public void doFilter(ServletRequest request,
      ServletResponse response,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    LOG.info("Logging Request:-  {} : {}", req.getMethod(), req.getRequestURI());
    filterChain.doFilter(request, response);
    LOG.info("Logging Response:-  {}", res.getContentType());

  }
}
