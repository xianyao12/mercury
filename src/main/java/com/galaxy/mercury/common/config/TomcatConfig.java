package com.galaxy.mercury.common.config;

/**
 * HTTP 请求重定向 HTTPS
 *
 * @author XianYao
 * @version V1.0
 * @date 2021/6/17 22:42
 */
//@Configuration
public class TomcatConfig {
    /*@Bean
    TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };
        factory.addAdditionalTomcatConnectors(createTomcatConnector());
        return factory;
    }

    private Connector createTomcatConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        //监听端口
        connector.setPort(8080);
        connector.setSecure(false);
        //转发端口
        connector.setRedirectPort(8888);
        return connector;
    }*/
}
