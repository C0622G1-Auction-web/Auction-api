package com.project.dto.guide;
import javax.validation.constraints.NotBlank;
public class ImgUrlGuideDto {
    private Integer id;
    @NotBlank
    private String url;
    private Integer guideId;

    public ImgUrlGuideDto() {
    }

    public Integer getGuideId() {
        return guideId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
   

    }
}
