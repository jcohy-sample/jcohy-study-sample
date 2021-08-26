package com.jcohy.provider.repository;

import com.jcohy.provider.model.Sc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Copyright: Copyright (c) 2019 https://www.jcohy.com
 *
 * @author jcohy
 * @version v1.0.0
 * @Description: TODO 请添加该类的功能描述
 * @date 2019/7/10 16:59
 * <p>
 * Modification History: Date Author Version Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/10 jcohy v1.0.0 修改原因
 */

public interface ScRepository extends JpaRepository<Sc, Long> {

	@Query(value = "select s.sid,s.cid,s.score from sc s where sid =?1", nativeQuery = true)
	List<Sc> findScoreById(Long id);

}
