package com.github.pedroluiznogueira.vehiclecatalogapi.security.filter;

import com.github.pedroluiznogueira.vehiclecatalogapi.model.User;
import com.github.pedroluiznogueira.vehiclecatalogapi.repository.UserRepository;
import com.github.pedroluiznogueira.vehiclecatalogapi.security.service.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class TokenFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    public TokenFilter(TokenService tokenService, UserRepository repository) {
        this.tokenService = tokenService;
        this.userRepository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String tokenFromHeader = getTokenFromHeader(request);
        boolean tokenValid = tokenService.isTokenValid(tokenFromHeader);
        if(tokenValid) {
            this.authenticate(tokenFromHeader);
        }

        // after...
        filterChain.doFilter(request, response);
        // before...
    }

    // access user id encrypted in jwt

    private void authenticate(String tokenFromHeader) {
        // access the id of the token's user
        Integer id = tokenService.getTokenId(tokenFromHeader);

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();

            // after successfully validating, set it in security context
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    null);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
    }

    // access request's header
    private String getTokenFromHeader(HttpServletRequest request) {

        // it comes as "Authorization: Bearer token..."
        String token = request.getHeader("Authorization");

        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }

}