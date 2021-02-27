package ward.ggwp.kr.domain;

import java.sql.Date;

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
public class WardStatic {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // generated auto_increment IDENTITY SEQUENCE TABLE AUTO
	public Long id;

	@Column(length = 255, nullable = false)
	public String baseUrl;

	@Column(length = 255, nullable = false)
	public String wardUrl;

	@Column(length = 255)
	private String userAgent;

	@Column(length = 50)
	private String ipaddr;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date datetime;

	@Builder
	public WardStatic(String baseUrl, String wardUrl, String userAgent, String ipaddr) {
		this.baseUrl = baseUrl;
		this.wardUrl = wardUrl;
		this.userAgent = userAgent;
		this.ipaddr = ipaddr;
	}

}
