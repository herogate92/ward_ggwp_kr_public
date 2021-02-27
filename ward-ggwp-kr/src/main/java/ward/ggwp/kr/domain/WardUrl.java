package ward.ggwp.kr.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class WardUrl
{
	@Id		//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//generated auto_increment IDENTITY	SEQUENCE	TABLE	AUTO
	public Long id;
	
	@Column(length = 255, nullable = false)
	public String baseUrl;
	
	@Column(length = 255, nullable = false, unique = true)
	public String wardUrl;
	
	@Builder
	public WardUrl(String baseUrl, String wardUrl, String userAgent)
	{
		this.baseUrl = baseUrl;
		this.wardUrl = wardUrl;
	}

}
