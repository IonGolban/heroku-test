package com.example.homeworkproject.config;

import com.example.homeworkproject.service.auth.ClientDetailsImpl;
import com.example.homeworkproject.service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION = "Authorization";

    private final JwtUtil jwtUtil;

    private final ClientDetailsImpl clientDetailsService;

    @Autowired
    public JwtRequestFilter(JwtUtil jwtUtil, ClientDetailsImpl clientDetailsService) {
        this.jwtUtil = jwtUtil;
        this.clientDetailsService = clientDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(AUTHORIZATION);
        String username = null;
        String jwt = null;

        if (header != null && header.startsWith("Bearer ")) {
            jwt = header.substring(7);
            username = jwtUtil.extractUsername(jwt);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = clientDetailsService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePassAuth =
                        new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                usernamePassAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePassAuth);
            }
        }
        filterChain.doFilter(request, response);
    }

}
