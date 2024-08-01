package com.basics.Collections_;

import java.util.ArrayList;

/**
 * 提供一个只有标题的构造器，提供get set方法。重写toString，只打印标题
 * 截取新闻标题，超过15个字，保留前15个字，其他的用“...”代替
 *
 */
public class homework1 {
    public static void main(String[] args) {

        News news1 = new News("新闻一：新冠确诊----");
        News news2 = new News("新闻二：男子突然--赶紧一起放------生----------------赶紧一起放生");

        ArrayList<News> news = new ArrayList<>();
        news.add(news1);
        news.add(news2);
        for (int i = news.size() - 1; i >= 0 ; i--) {
           int len =  news.get(i).getTitle().length();
            if ( len > 15 ){
                String subTitle = news.get(i).getTitle().substring(0,15) + "...";
                System.out.println(subTitle);
            }else{
                System.out.println(news.get(i).getTitle());
            }
        }

    }
}
class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}
