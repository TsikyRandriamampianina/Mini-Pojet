package mg.project.miniprojet.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import mg.project.miniprojet.service.JwtService;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;
import java.util.List;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final List<String> PUBLIC_PATHS = List.of(
        "/api/auth/**", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/h2/**"
    );
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected boolean shouldNotFilter(jakarta.servlet.http.HttpServletRequest request) {
        String path = request.getServletPath();
        return PUBLIC_PATHS.stream().anyMatch(p -> pathMatcher.match(p, path));
    }


   @Autowired
   private JwtService jwtService;


    @Override
    protected void doFilterInternal(
           HttpServletRequest request,
           HttpServletResponse response,
           FilterChain filterChain)
           throws ServletException, IOException {
       String header = request.getHeader("Authorization");
       
    if (header != null && header.startsWith("Bearer ")) {
           String token = header.substring(7);
           if (!jwtService.isValid(token)) {
               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               response.getWriter().write("Invalid token");
               return;
           }


           String email = jwtService.extractEmail(token);


           UsernamePasswordAuthenticationToken auth =
                   new UsernamePasswordAuthenticationToken(
                           email,
                           null,
                           List.of(new SimpleGrantedAuthority("ROLE_USER"))
                   );


           SecurityContextHolder.getContext().setAuthentication(auth);
       }

       filterChain.doFilter(request, response);
    }
}
