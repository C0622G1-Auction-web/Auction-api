/**Create By QuangND
Service: Guide Service
create Dat:16/12/2022
**/

package com.project.service.guide.impl;
import com.project.model.guide.Guide;
import com.project.repository.guide.IGuideRepository;
import com.project.service.guide.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService implements IGuideService {
    @Autowired
    private IGuideRepository guideRepository;


    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: display list guide
     * @return: List<Guide>
     */



    @Override
    public List<Guide> findAllGuide() {
        return guideRepository.findAllGuide();
    }



    @Override
    public Guide getGuideById(int id) {
        return guideRepository.getGuideById(id);
    }

    @Override
    public void createGuide(Guide guide) {
        guideRepository.save(guide);
    }


    @Override
    public void updateGuide(Guide guide) {
        guideRepository.updateGuide(guide.getId(),guide.getTitle(),guide.getContent());
    }

<<<<<<< HEAD

=======
>>>>>>> add4b878c187060ab440b6aba8d1c0d71a564518
}
