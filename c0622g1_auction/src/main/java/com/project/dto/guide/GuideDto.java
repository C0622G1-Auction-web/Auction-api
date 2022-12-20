package com.project.dto.guide;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Create by: QuangND,
 * Date created: 13/12/2022
 * Function: create a guide Dto model
 */


public class GuideDto {
    private Integer id;
    @NotBlank(message = "Không được để trống tên chủ đề")
    @Size(min = 10, max = 100, message = "Tên chủ đề quá dài hoặc quá ngắn")
    @Pattern(regexp = "^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9,.?! ]*$", message = "Vui lòng nhập đúng định dạng")
    private String title;
    @NotBlank(message = "Không được để trống nội dung")
    @Size(min = 30, max = 2000, message = "Nội dung quá độ dài quy định")
    private String content;
    private Boolean deleteStatus=true;
    private String images;

    public GuideDto() {
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
