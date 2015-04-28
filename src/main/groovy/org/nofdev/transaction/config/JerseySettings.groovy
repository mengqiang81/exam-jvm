package org.nofdev.transaction.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * Created by Qiang on 3/9/15.
 */
@Component
@ConfigurationProperties(prefix = "jersey")
class JerseySettings {
    String scanPackages
}
