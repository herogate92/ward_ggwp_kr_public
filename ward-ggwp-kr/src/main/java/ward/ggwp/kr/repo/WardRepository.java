package ward.ggwp.kr.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ward.ggwp.kr.domain.WardUrl;

public interface WardRepository extends CrudRepository<WardUrl, Long>
{
	public List<WardUrl> findByWardUrl(String wardUrl);
	
	public List<WardUrl> findByBaseUrl(String baseUrl);
	
    public List<WardUrl> findByWardUrlLike(String wardUrl);	
}