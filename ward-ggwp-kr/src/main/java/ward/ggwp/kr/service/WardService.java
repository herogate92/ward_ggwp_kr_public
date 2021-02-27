package ward.ggwp.kr.service;

import javax.servlet.http.HttpServletRequest;

import ward.ggwp.kr.domain.WardUrl;

public interface WardService {

	void collectInfo(HttpServletRequest request, WardUrl wardUrl);

}
