package com.jcohy.provider.repository;

import com.jcohy.provider.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description:
 *
 * @author fangliangsheng
 * @date 2019-04-04
 */
public interface StorageDAO extends JpaRepository<Storage, String> {

	Storage findByCommodityCode(String commodityCode);

}
