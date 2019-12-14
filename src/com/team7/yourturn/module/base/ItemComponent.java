package com.team7.yourturn.module.base;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ItemComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 80;
    private static final int DEFAULT_HEIGHT = 80;

    private int width;
    private int height;
    private int x;
    private int y;

    public  void setHeight(int height){
        this.height = height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    private Image image;

    public ItemComponent(String filename, int width, int height) {
        //image = new ImageIcon(getClass().getResource(filename)).getImage();
        image = new ImageIcon("src/image/"+filename).getImage();
        this.width = width;
        this.height = height;
    }

    public ItemComponent(String filename) {
        image = new ImageIcon("src/image/"+filename).getImage();
        width = 450;
        height = 350;
    }

    @Override
    public void paintComponent(Graphics g) throws NullPointerException {
        if (image == null) throw new NullPointerException("no image is set");

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        g.drawImage(image, 0, 0, width, height, null);
    }



    public Dimension getPreferredSized() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

    /*图片旋转*/

    //Image转换成BufferedImage
    public static BufferedImage ImageToBufferedImage(Image image )
    {
        BufferedImage  bufferedimage = new BufferedImage
                (image.getWidth(null), image.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics g =  bufferedimage.createGraphics();
        g.drawImage(image, 0, 0, null);	//这里，大家可能会有疑问，似乎没有对bufferedimage干啥
        g.dispose(); 					//但是是正确的，g调用drawImage就自动保存了
        return bufferedimage;
    }
    //BufferedImage 转换成Image类型
    public static Image BufferedImageToImage( BufferedImage b )
    {
        return (Image)b;
    }


    //左转90度
    public static Image rotateImageLeft90(ItemComponent itemComponent)
    {
        Image image=itemComponent.getImage();
        BufferedImage bufferedimage = ImageToBufferedImage(image);
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d =
                (img = new BufferedImage(h, w, type) ).createGraphics()
        ).setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(270), w / 2, h / 2 + (w-h)/2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();

        return BufferedImageToImage(img);
    }

    //右转90度
    public static Image rotateImageRight90(ItemComponent itemComponent)
    {
        Image image=itemComponent.getImage();
        BufferedImage bufferedimage = ImageToBufferedImage(image);
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(h, w, type)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(90), w / 2 - (w-h)/2, h / 2 );
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();

        return BufferedImageToImage(img);
    }

    //颠倒
    public static Image rotateImage180(ItemComponent itemComponent)
    {
        Image image=itemComponent.getImage();
        BufferedImage bufferedimage = ImageToBufferedImage(image);
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(180), w / 2, h / 2 );
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();

        return BufferedImageToImage(img);
    }

}
