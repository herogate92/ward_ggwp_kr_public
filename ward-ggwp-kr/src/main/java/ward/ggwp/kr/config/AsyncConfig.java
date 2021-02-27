package ward.ggwp.kr.config;

import java.util.concurrent.Executor;

import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class AsyncConfig extends AsyncConfigurerSupport {
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(500);
//		executor.setThreadNamePrefix("heowc-async-");
		executor.initialize();
		return executor;
	}
}
