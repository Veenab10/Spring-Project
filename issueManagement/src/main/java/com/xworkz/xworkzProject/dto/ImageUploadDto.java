package com.xworkz.xworkzProject.dto;

import com.xworkz.xworkzProject.constant.Status;

import javax.persistence.*;

@Entity
@Table(name = "image_details")
public class ImageUploadDto {

    public ImageUploadDto()
    {
        System.out.println("Created ProfileImageDto");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @OneToOne(fetch = FetchType.LAZY) // Example mapping assuming many images to one signup
    @JoinColumn(name = "id", referencedColumnName = "id") // Adjust as per your schema
    private SignupDto signupDto;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_size")
    private Long imageSize;

    @Column(name = "image_type")
    private String imageType;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public SignupDto getSignupDto() {
        return signupDto;
    }

    public void setSignupDto(SignupDto signupDto) {
        this.signupDto = signupDto;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Long getImageSize() {
        return imageSize;
    }

    public void setImageSize(Long imageSize) {
        this.imageSize = imageSize;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ImageUploadDto{" +
                "imageId=" + imageId +
                ", signupDto=" + signupDto +
                ", imageName='" + imageName + '\'' +
                ", imageSize=" + imageSize +
                ", imageType='" + imageType + '\'' +
                ", status=" + status +
                '}';
    }
}
