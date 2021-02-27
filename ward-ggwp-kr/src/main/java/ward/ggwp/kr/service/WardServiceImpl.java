package ward.ggwp.kr.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import ward.ggwp.kr.domain.WardStatic;
import ward.ggwp.kr.domain.WardUrl;
import ward.ggwp.kr.repo.WardStaticRepository;

@Service
@EnableAsync
public class WardServiceImpl implements WardService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WardStaticRepository wardStaticRepository;

	@Override
	@Async
	public void collectInfo(HttpServletRequest request, WardUrl wardUrl) {
		String ip = request.getHeader("X-Forwarded-For");
		logger.info("> X-FORWARDED-FOR : " + ip);

		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
			logger.info("> Proxy-Client-IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			logger.info(">  WL-Proxy-Client-IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
			logger.info("> HTTP_CLIENT_IP : " + ip);
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			logger.info("> HTTP_X_FORWARDED_FOR : " + ip);
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
			logger.info("> getRemoteAddr : " + ip);
		}
		logger.info("> Result : IP Address : " + ip);

		String userAgent = request.getHeader("User-Agent");
		String ipaddr = request.getRemoteAddr();
		WardStatic wardStatic = WardStatic.builder().baseUrl(wardUrl.getBaseUrl()).wardUrl(wardUrl.wardUrl)
				.userAgent(userAgent).ipaddr(ip).build();
		wardStaticRepository.save(wardStatic);
	}
}
