package ward.ggwp.kr.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ward.ggwp.kr.domain.WardStatic;
import ward.ggwp.kr.domain.WardUrl;

public interface WardStaticRepository extends CrudRepository<WardStatic, Long>
{
	public List<WardUrl> findByWardUrl(String wardUrl);
	
	public List<WardUrl> findByBaseUrl(String baseUrl);

    public List<WardUrl> findByWardUrlLike(String wardUrl);	
}