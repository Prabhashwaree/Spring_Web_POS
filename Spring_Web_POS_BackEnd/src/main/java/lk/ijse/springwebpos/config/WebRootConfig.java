package lk.ijse.springwebpos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
public class WebRootConfig {
}
