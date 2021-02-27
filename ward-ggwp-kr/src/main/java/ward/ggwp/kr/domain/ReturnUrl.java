package ward.ggwp.kr.domain;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
public class ReturnUrl {

	@Column(length = 255, nullable = false)
	public String baseUrl;

	@Column(length = 255, nullable = false, unique = true)
	public String wardUrl;

	public ReturnUrl(WardUrl wardUrl) {
		this.baseUrl = wardUrl.getBaseUrl();
		this.wardUrl = wardUrl.getWardUrl();
	}
}
