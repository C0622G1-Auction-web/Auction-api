package com.project.repository.guide;
import com.project.model.guide.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface IGuideRepository extends JpaRepository<Guide, Integer> {
    /**

     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all guide in Database
     * @return list of guide
     */

    @Query(value = "SELECT * FROM guide WHERE guide.title LIKE %:title% ", nativeQuery = true, countQuery = "select count(*) from guide")
    List<Guide> findAllGuide(@Param("title") String title);



    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: find a guide in DB by id of guide
     *
     * @return a guide match with id
     * @Param id
     */

    @Query(value = "SELECT * FROM `guide` WHERE `guide`.id=:id AND guide.delete_status=true", nativeQuery = true)
    Guide getGuideById(@Param("id") int id);

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: Create a new guide insert to DB
     *
     * @Param title, content
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO guide (title,content) VALUES (:title,:content)", nativeQuery = true)
    void createGuide(@Param("title") String title,
                     @Param("content") String content);

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: Update a guide with id in DB
     *
     * @Param id, title, content
     */

    @Modifying
    @Transactional
    @Query(value = "UPDATE guide SET title = :title, content = :content WHERE guide.id=:id", nativeQuery = true)
    void updateGuide(@Param("id") Integer id,
                     @Param("title") String title,
                     @Param("content") String content);

}
