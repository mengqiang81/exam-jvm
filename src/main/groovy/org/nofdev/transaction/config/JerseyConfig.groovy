package org.nofdev.transaction.config

import org.nofdev.common.MyObjectMapperProvider
import org.glassfish.jersey.filter.LoggingFilter
import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.scope.RequestContextFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by Qiang on 1/13/15.
 */
@Component
class JerseyConfig extends ResourceConfig {

    @Autowired
    public JerseyConfig(JerseySettings jerseySettings) {
        register(RequestContextFilter.class);
        packages(true,jerseySettings.scanPackages);
        register(LoggingFilter.class);
        register(MyObjectMapperProvider.class)
        register(JacksonFeature.class)
    }
}
