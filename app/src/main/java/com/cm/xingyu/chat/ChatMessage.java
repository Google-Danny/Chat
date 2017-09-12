package com.cm.xingyu.chat;

/**
 * Created by Administrator on 2017/9/9.
 */
public class ChatMessage {
    private int id;
    private String friendName;
    private int image;
    private String chatContent;
    private  String msgType;

    public ChatMessage(String friendName, int image, String chatContent, String msgType) {
        this.friendName = friendName;
        this.image = image;
        this.chatContent = chatContent;
        this.msgType = msgType;
    }

    public String getMsgType() {
        return msgType;
    }

    public ChatMessage setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }


    public int getId() {
        return id;
    }

    public ChatMessage setId(int id) {
        this.id = id;
        return this;
    }

    public String getFriendName() {
        return friendName;
    }

    public ChatMessage setFriendName(String friendName) {
        this.friendName = friendName;
        return this;
    }

    public int getImage() {
        return image;
    }

    public ChatMessage setImage(int image) {
        this.image = image;
        return this;
    }

    public String getChatContent() {
        return chatContent;
    }

    public ChatMessage setChatContent(String chatContent) {
        this.chatContent = chatContent;
        return this;
    }
}
