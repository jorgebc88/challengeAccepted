package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
//public class Application {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // CORS
//    @Bean
//    FilterRegistrationBean corsFilter() {
//        return new FilterRegistrationBean(new Filter() {
//            public void doFilter(ServletRequest req, ServletResponse res,
//                                 FilterChain chain) throws IOException, ServletException {
//                HttpServletRequest request = (HttpServletRequest) req;
//                HttpServletResponse response = (HttpServletResponse) res;
//                String method = request.getMethod();
//                // this origin value could just as easily have come from a database
//                response.setHeader("Access-Control-Allow-Origin", "*");
//                response.setHeader("Access-Control-Allow-Methods",
//                        "POST, GET, PUT, OPTIONS, DELETE");
//                response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
//                response.setHeader("Access-Control-Allow-Credentials", "true");
//                response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
//                if ("OPTIONS".equals(method)) {
//                    response.setStatus(HttpStatus.OK.value());
//                }
//                else {
//                    chain.doFilter(req, res);
//                }
//            }
//
//            public void init(FilterConfig filterConfig) {
//            }
//
//            public void destroy() {
//            }
//        });
//    }
}

