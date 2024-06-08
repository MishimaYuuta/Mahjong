import javax.swing.*;
import java.awt.*;

public class HandCard {
    public JButton CardImage(Card card) {
        if(card == null){
            return null;
        }
        if (card.toString().equals("1万")) {
            // Create image button
            ImageIcon icon = new ImageIcon("image/wan/1wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            return new JButton(resizedIcon);
        }else if(card.toString().equals("2万")){
            ImageIcon icon = new ImageIcon("image/wan/2wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("3万")){
            ImageIcon icon = new ImageIcon("image/wan/3wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("4万")){
            ImageIcon icon = new ImageIcon("image/wan/4wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("5万")){
            ImageIcon icon = new ImageIcon("image/wan/5wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("6万")){
            ImageIcon icon = new ImageIcon("image/wan/6wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("7万")){
            ImageIcon icon = new ImageIcon("image/wan/7wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("8万")){
            ImageIcon icon = new ImageIcon("image/wan/8wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("9万")){
            ImageIcon icon = new ImageIcon("image/wan/9wan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("1筒")){
            ImageIcon icon = new ImageIcon("image/tong/1tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("2筒")){
            ImageIcon icon = new ImageIcon("image/tong/2tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("3筒")){
            ImageIcon icon = new ImageIcon("image/tong/3tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("4筒")){
            ImageIcon icon = new ImageIcon("image/tong/4tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("5筒")){
            ImageIcon icon = new ImageIcon("image/tong/5tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("6筒")){
            ImageIcon icon = new ImageIcon("image/tong/6tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("7筒")){
            ImageIcon icon = new ImageIcon("image/tong/7tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("8筒")){
            ImageIcon icon = new ImageIcon("image/tong/8tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("9筒")){
            ImageIcon icon = new ImageIcon("image/tong/9tong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("1条")){
            ImageIcon icon = new ImageIcon("image/tiao/1tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("2条")){
            ImageIcon icon = new ImageIcon("image/tiao/2tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("3条")){
            ImageIcon icon = new ImageIcon("image/tiao/3tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("4条")){
            ImageIcon icon = new ImageIcon("image/tiao/4tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("5条")){
            ImageIcon icon = new ImageIcon("image/tiao/5tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("6条")){
            ImageIcon icon = new ImageIcon("image/tiao/6tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("7条")){
            ImageIcon icon = new ImageIcon("image/tiao/7tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("8条")){
            ImageIcon icon = new ImageIcon("image/tiao/8tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("9条")){
            ImageIcon icon = new ImageIcon("image/tiao/9tiao.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("红中")){
            ImageIcon icon = new ImageIcon("image/feng/zhong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("发财")) {
            ImageIcon icon = new ImageIcon("image/feng/fa.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("白板")) {
            ImageIcon icon = new ImageIcon("image/feng/bai.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("北风")) {
            ImageIcon icon = new ImageIcon("image/feng/bei.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("东风")) {
            ImageIcon icon = new ImageIcon("image/feng/dong.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else if(card.toString().equals("西风")) {
            ImageIcon icon = new ImageIcon("image/feng/xi.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }else{
            ImageIcon icon = new ImageIcon("image/feng/nan.png");
            Image originalImage = icon.getImage();
            Image resizedImage = originalImage.getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH); // 设置新的大小
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            return new JButton(resizedIcon);
        }

    }
}
