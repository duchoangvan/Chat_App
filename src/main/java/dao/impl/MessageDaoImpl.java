package dao.impl;

import dao.MessageDao;
import entities.Message;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

public class MessageDaoImpl extends BaseDaoImpl<Message, Long> implements MessageDao {
    private final SessionFactory sessionFactory;
    public MessageDaoImpl() {
        super(Message.class);
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }
}
