package com.sda.rettiwt.hibernate.dao;

import com.sda.rettiwt.hibernate.entity.Message;

public class MessageDao extends AbstractDao<Message> {

    private static MessageDao messageDao;

    public static MessageDao getInstance() {
        if (messageDao == null) {
            messageDao = new MessageDao();
        }
        return messageDao;
    }

    @Override
    protected Class<Message> getClazz() {
        return Message.class;
    }
}
