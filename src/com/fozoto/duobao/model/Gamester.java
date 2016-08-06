package com.fozoto.duobao.model;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 一元夺宝的用户
 * Created by qingyan on 16-7-27.
 */
@Entity(name = "Gamester")
@Scope("prototype")
public class Gamester implements Serializable{
    private int id;                 // 主键
    private String ip;              // ip地址
    private String account;         // 账号
    private String password;        // 密码
    private String nickname;        // 昵称
    private String phone;           // 手机号
    private String portrait;        // 头像
    private String time;            // 注册时间
    private int stone;              // 宝石
    private int money;              // 余额

    private List<Lucky> luckies;    // 用户的幸运商品
    private List<Annal> annals;     // 用户的所有夺宝记录

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhone() {
        return phone;
    }

    public String getPortrait() {
        return portrait;
    }

    public int getStone() {
        return stone;
    }

    public int getMoney() {
        return money;
    }

    // Lucky负责维护与用户的关系
    @OneToMany(targetEntity = Lucky.class, mappedBy = "gamester", cascade = CascadeType.ALL)
    public List<Lucky> getLuckies() {
        return luckies;
    }

    // Annal负责维护关系
    @OneToMany(targetEntity = Annal.class, cascade = CascadeType.ALL, mappedBy = "gamester")
    public List<Annal> getAnnals() {
        return annals;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAnnals(List<Annal> annals) {
        this.annals = annals;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public void setLuckies(List<Lucky> luckies) {
        this.luckies = luckies;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Gamester{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", portrait='" + portrait + '\'' +
                ", time='" + time + '\'' +
                ", stone=" + stone +
                ", money=" + money +
                '}';
    }
}
