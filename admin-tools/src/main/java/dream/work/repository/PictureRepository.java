package dream.work.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import dream.work.domain.Picture;

/**
 * @author jie
 * @date 2018-12-27
 */
public interface PictureRepository extends JpaRepository<Picture,Long>, JpaSpecificationExecutor {
}
