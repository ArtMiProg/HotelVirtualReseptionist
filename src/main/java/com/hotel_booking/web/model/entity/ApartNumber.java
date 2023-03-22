package com.hotel_booking.web.model.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "apart_number")
public class ApartNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "apart_number")
    private Integer number;
    @Column(name = "apart_class_id")
    private Integer apartClassId;
    @Column(name = "apart_size_id")
    private Integer apartSizeId;
    @Column(name = "basic_pay")
    private Float basicPay;
    @Column(name = "cost")
    private Float cost;
    @Column(name = "image")
    private byte[] image;


    @Column(name = "dates_when_occupied")
    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonType")
    private Set<LocalDate> datesWhenOccupied;

    public ApartNumber(){

    }

    public ApartNumber(Integer id, Integer number, Integer apartClassId, Integer apartSizeId){
        this.id = id;
        this.number = number;
        this.apartClassId = apartClassId;
        this.apartSizeId = apartSizeId;
    }

    public ApartNumber(Float basicPay){
        this.basicPay = basicPay;
}

    public void setImage(MultipartFile file) throws IOException {
        this.image = file.getBytes();
    }

    public String getImageAsBase64() {
        String base64 = null;
        try {
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(image));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            base64 = Base64.getEncoder().encodeToString(imageInByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }



}
