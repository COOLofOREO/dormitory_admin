package com.server.entity;

import com.server.utils.VerifCodeImage;
import lombok.Data;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 验证码实体类
 */
@Data
public class VerifCode {
    /**
     * 验证码编号
     */
    private String id;
    /**
     * 验证码
     */
    private String verifCode;
    /**
     * 验证码使用状态
     * 0：未使用   1：已用（可删除）
     */
    private String state;
    /**
     * 经过base64加密后的验证码图片
     */
    private String verifBase64Image;

    private VerifCode(){}

    public static VerifCode makeVerifCode(){
        VerifCode verifCode=new VerifCode();
        verifCode.BufferedImageToBase64();
        verifCode.setId(UUID.randomUUID().toString());
        verifCode.setState("0");
        return verifCode;
    }

    private void BufferedImageToBase64(){
        VerifCodeImage image=new VerifCodeImage();
        BufferedImage bufferedImage=image.getImage();
        this.verifCode=image.getText();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage,"png",baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes=baos.toByteArray();
        BASE64Encoder encoder=new BASE64Encoder();
        String png_base64=encoder.encodeBuffer(bytes).trim();
        png_base64=png_base64.replaceAll("\n","").replaceAll("\r","");
        this.verifBase64Image="data:image/jpg;base64"+png_base64;
    }

}
