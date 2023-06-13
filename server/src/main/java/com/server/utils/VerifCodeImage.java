package com.server.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifCodeImage {
    private int weight=100;
    private int height=40;
    /**
     * 生成的验证码
     */
    private String text;
    /**
     * 获取随机数对象
     */
    private Random r=new Random();
    //字体数组
    private String[] fontNames={"Georgia"};
    //验证码字符串
    private String codes="23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";

    /**
     * 获取随机颜色
     * @return
     */
    private Color randomColor(){
        int R=r.nextInt(255);
        int G=r.nextInt(255);
        int B=r.nextInt(255);
        return new Color(R,G,B);
    }

    /**
     * 获取随机字体
     * @return
     */
    private Font randomFont(){
        //获取随机字体
        int index=r.nextInt(fontNames.length);
        String fontName=fontNames[index];
        //随机获取字体的样式 0：无样式 1：加粗 2：斜体 3：加粗斜体
        int style=r.nextInt(4);
        //随机获取字体的大小
        int size=r.nextInt(10)+24;
        return new Font(fontName,style,size);
    }

    /**
     * 获取随机字符
     * @return
     */
    private char randomChar(){
        int index=r.nextInt(codes.length());
        return codes.charAt(index);
    }

    /**
     * 画干扰线
     * @param image
     */
    private void drawLine(BufferedImage image){
        //定义干扰线的数量
        int num=r.nextInt(20);
        Graphics2D g= (Graphics2D) image.getGraphics();
        for(int i=0;i<num;i++){
            int x1=r.nextInt(weight);
            int y1=r.nextInt(height);
            int x2=r.nextInt(weight);
            int y2=r.nextInt(height);
            g.setColor(randomColor());
            g.drawLine(x1,y1,x2,y2);
        }
    }

    /**
     * 创建图片
     * @return
     */
    private BufferedImage createImage(){
        //创建图片缓冲区
        BufferedImage image=new BufferedImage(weight,height,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics2D g= (Graphics2D) image.getGraphics();
        //随机设置背景颜色
        g.setColor(new Color(255,255,r.nextInt(245)+10));
        g.fillRect(0,0,weight,height);
        //返回图片
        return image;
    }

    /**
     * 获取验证码图片的方法
     * @return
     */
    public BufferedImage getImage(){
        BufferedImage image=createImage();
        Graphics2D g= (Graphics2D) image.getGraphics();
        StringBuffer buffer=new StringBuffer();
        //画4个字
        for(int i=0;i<4;i++){
            //随机生成字符
            String str=randomChar()+"";
            buffer.append(str);
            float x=i*1.0F*weight/4;
            g.setFont(randomFont());
            g.setColor(randomColor());
            g.drawString(str,x,height-5);
        }
        text=buffer.toString();
        drawLine(image);
        return image;
    }

    /**
     * 获取验证码
     * @return
     */
    public String getText(){
        return text;
    }
}
