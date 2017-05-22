package com.yw.mvpzhihu.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yw on 17/5/20.
 * {
 "date": "20170521",
 "stories": [
 {
 "images": [
 "https://pic4.zhimg.com/v2-e592781a0b8b0d90a18256e08c39720f.jpg"
 ],
 "type": 0,
 "id": 9432352,
 "ga_prefix": "052114",
 "title": "刘看山 · 偶尔也会需要爱"
 },
 {
 "images": [
 "https://pic3.zhimg.com/v2-2495432d7334b51da5e5866fd1f0bffa.jpg"
 ],
 "type": 0,
 "id": 9432072,
 "ga_prefix": "052113",
 "title": "恋爱中，不作不闹、安静克制的性格容易吃亏吗？"
 },
 {
 "images": [
 "https://pic3.zhimg.com/v2-b1564a0c4a1dc41552d0d5b3e44d803e.jpg"
 ],
 "type": 0,
 "id": 9431594,
 "ga_prefix": "052112",
 "title": "大误 · 用一亿换一分钟生命，干不干？"
 },
 {
 "images": [
 "https://pic2.zhimg.com/v2-8aa190052c76e5b8610c0acb1b922799.jpg"
 ],
 "type": 0,
 "id": 9432150,
 "ga_prefix": "052111",
 "title": "健身卡一年用两次，信用卡一天刷两次，换过来该多好"
 },
 {
 "title": "来做一份好吃又好看，可以用来表白的蛋包饭",
 "ga_prefix": "052109",
 "images": [
 "https://pic1.zhimg.com/v2-f5dfb945cb3cf33db2f5b62d64a8b14c.jpg"
 ],
 "multipic": true,
 "type": 0,
 "id": 9422396
 },
 {
 "images": [
 "https://pic4.zhimg.com/v2-6e9de135457fb0bac9e137687f4d2dff.jpg"
 ],
 "type": 0,
 "id": 9431256,
 "ga_prefix": "052108",
 "title": "有哪些容易被忽略的员工福利？"
 },
 {
 "images": [
 "https://pic2.zhimg.com/v2-881d0b75bcc05346fc78f91ff0682969.jpg"
 ],
 "type": 0,
 "id": 9416208,
 "ga_prefix": "052107",
 "title": "你在 297 楼是吗？稍等，我进电梯了，马上就到"
 },
 {
 "title": "这个流行了 20 多年却没有名字的课间游戏，你还记得吗？",
 "ga_prefix": "052107",
 "images": [
 "https://pic1.zhimg.com/v2-49a3846c02358d1339e0f645b3252098.jpg"
 ],
 "multipic": true,
 "type": 0,
 "id": 9427045
 },
 {
 "images": [
 "https://pic1.zhimg.com/v2-aad12cd392a21f75a6e493697072eedc.jpg"
 ],
 "type": 0,
 "id": 9431804,
 "ga_prefix": "052107",
 "title": "看完明星八卦，才发现自己对家暴有很多误会"
 },
 {
 "images": [
 "https://pic4.zhimg.com/v2-b41819304dcd0ab73431e351b973e1df.jpg"
 ],
 "type": 0,
 "id": 9430068,
 "ga_prefix": "052106",
 "title": "瞎扯 · 如何正确地吐槽"
 }
 ],
 "top_stories": [
 {
 "image": "https://pic3.zhimg.com/v2-6e7e958dd16f904f1b9c98075e151f56.jpg",
 "type": 0,
 "id": 9432352,
 "ga_prefix": "052114",
 "title": "刘看山 · 偶尔也会需要爱"
 },
 {
 "image": "https://pic2.zhimg.com/v2-725b0e27c5ba05363a3f884cd1bb3249.jpg",
 "type": 0,
 "id": 9427045,
 "ga_prefix": "052107",
 "title": "这个流行了 20 多年却没有名字的课间游戏，你还记得吗？"
 },
 {
 "image": "https://pic4.zhimg.com/v2-ec9fcf8759160e25f313830c86dc2eeb.jpg",
 "type": 0,
 "id": 9431804,
 "ga_prefix": "052107",
 "title": "看完明星八卦，才发现自己对家暴有很多误会"
 },
 {
 "image": "https://pic3.zhimg.com/v2-3fcabac495a2dec7b3a85bc62a821e0e.jpg",
 "type": 0,
 "id": 9431002,
 "ga_prefix": "052015",
 "title": "古典的谋杀故事结束了，新的故事正在开始"
 },
 {
 "image": "https://pic4.zhimg.com/v2-859081863bfdc7d3a7cc1607fd56222b.jpg",
 "type": 0,
 "id": 9430729,
 "ga_prefix": "052014",
 "title": "只能想念九十月大闸蟹的夏天里，炒一碟赛螃蟹解馋"
 }
 ]
 }
 */
public class HomeBean extends BaseBean{

    @SerializedName("stories")
    private List<Story> stories;

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public class Story extends BaseBean{
     @SerializedName("title")
     private String title;
     @SerializedName("images")
     private String[] images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String[] getImages() {
            return images;
        }

        public void setImages(String[] images) {
            this.images = images;
        }
    }
}
