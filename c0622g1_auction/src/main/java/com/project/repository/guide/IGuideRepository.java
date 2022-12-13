package com.project.repository.guide;

import com.project.model.guide.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IGuideRepository extends JpaRepository<Guide, Integer> {
    @Query(value = "SELECT guide.id, guide.title, guide.content, guide.delete_status FROM guide WHERE guide.delete_status=true ", nativeQuery = true)
    List<Guide> findAllGuide();
    @Query(value="SELECT * FROM guide WHERE guide.id=:id AND guide.delete_status=true", nativeQuery = true)
    Guide getGuideById(@Param("id") int id);

    @Modifying
    @Query(value="INSERT INTO guide (title,content) VALUES (:title,:content)", nativeQuery = true)
    void createGuide(@Param("title") String title,
                     @Param("content") String content);
}
