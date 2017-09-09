package com.cm.xingyu.chat;

/**
 * Created by Administrator on 2017/9/9.
 */
public class chatListInfo {
    private int id;
    private String friendName;
    private int image;
    private String chatContent;

    public int getId() {
        return id;
    }

    public chatListInfo setId(int id) {
        this.id = id;
        return this;
    }

    public String getFriendName() {
        return friendName;
    }

    public chatListInfo setFriendName(String friendName) {
        this.friendName = friendName;
        return this;
    }

    public int getImage() {
        return image;
    }

    public chatListInfo setImage(int image) {
        this.image = image;
        return this;
    }

    public String getChatContent() {
        return chatContent;
    }

    public chatListInfo setChatContent(String chatContent) {
        this.chatContent = chatContent;
        return this;
    }
}
