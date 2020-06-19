package com.program.upviews.security.filter;

        import com.google.gson.Gson;
        import com.program.upviews.exceptions.custom.InvalidLoginException;
        import java.io.IOException;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import org.springframework.http.HttpStatus;
        import org.springframework.security.core.AuthenticationException;
        import org.springframework.security.web.AuthenticationEntryPoint;
        import org.springframework.stereotype.Component;

//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//
//    private static final String CONTENT_TYPE = "application/json";
//
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//
//        InvalidLoginException response = new InvalidLoginException();
//        String jsonLoginResponse = new Gson().toJson(response);
//
//        httpServletResponse.setContentType(CONTENT_TYPE);
//        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
//        httpServletResponse.getWriter().print(jsonLoginResponse);
//
//    }
//}
