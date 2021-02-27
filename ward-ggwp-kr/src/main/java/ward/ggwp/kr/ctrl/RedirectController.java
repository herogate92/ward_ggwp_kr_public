package ward.ggwp.kr.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.View;

import ward.ggwp.kr.domain.WardUrl;
import ward.ggwp.kr.repo.WardRepository;
import ward.ggwp.kr.service.WardService;
@Controller
public class RedirectController 
{
	@Autowired
	WardRepository wardRepository;

	@Autowired
	WardService wardService;

	@GetMapping("/{keyValue}")
	public String redirectCore(@PathVariable String keyValue, HttpServletRequest request)
	{
		String redirectUrl = "";
		List<WardUrl> urlResult = wardRepository.findByWardUrl(keyValue);
		WardUrl wardUrl;
		if(!urlResult.isEmpty())
		{
			wardUrl = urlResult.get(0);
			redirectUrl = urlResult.get(0).getBaseUrl();
		}
		else
		{
			request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.NOT_FOUND);
			return "redirect:/";
		}
		//정보수집 비동기 처리
		wardService.collectInfo(request,wardUrl);

		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.MOVED_PERMANENTLY);
		if("".equals(redirectUrl) || redirectUrl == null)
			redirectUrl="/";
		return "redirect:"+redirectUrl;
	}
}
