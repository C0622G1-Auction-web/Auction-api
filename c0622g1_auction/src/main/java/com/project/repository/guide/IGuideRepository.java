package com.project.repository.guide;

import com.project.model.guide.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IGuideRepository extends JpaRepository<Guide, Integer> {
    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all guide in Database
     * @return list of guide
     */

    @Query(value = "SELECT guide.id, guide.title, guide.content, guide.delete_status FROM guide WHERE guide.delete_status=true ", nativeQuery = true)
    List<Guide> findAllGuide();
}
