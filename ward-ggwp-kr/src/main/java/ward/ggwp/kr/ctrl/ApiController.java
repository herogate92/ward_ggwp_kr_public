package ward.ggwp.kr.ctrl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ward.ggwp.kr.domain.ReturnUrl;
import ward.ggwp.kr.domain.WardUrl;
import ward.ggwp.kr.repo.WardRepository;

@RestController
@CrossOrigin(origins = { "https://ward.ggwp.kr", "https://ward-ggwp-kr.herokuapp.com" })
public class ApiController {

	@Autowired
	WardRepository wardRepository;

	@PostMapping("/ward")
	public ResponseEntity<?> ward(@Param(value = "url") String url) {
		boolean flag = false;
		String randomWardUrl = "";
		do {
			randomWardUrl = RandomStringUtils.randomAlphanumeric(6);
			flag = !wardRepository.findByWardUrl(randomWardUrl).isEmpty();
		} while (flag);

		WardUrl wardUrl = WardUrl.builder().baseUrl(url).wardUrl(randomWardUrl).build();
		wardRepository.save(wardUrl);

		return new ResponseEntity<ReturnUrl>(new ReturnUrl(wardUrl), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/{keyValue}/report") public View report(@PathVariable String
	 * keyValue) { wardRepository.findByWardUrl(keyValue);
	 * 
	 * 
	 * // return new }
	 */
}
