import java.util.List;
import java.util.ArrayList;

interface Message {
    public void printMessage();
    public String getMessage();
}

class MessageImpl implements Message {
    public String message;
    
    MessageImpl(String msg) {
        this.message = msg;
    }
    
    public void printMessage() {
        System.out.println("Message: " + this.message);
    }

    public String getMessage() {
        return this.message;
    }
}

interface Publisher {
    public void registerTopic(Topic topic);
    public void unregisterTopic(Topic topic);
    public void publish(Topic topic, Message msg);
}

class PublisherImpl implements Publisher {
    String name;
    List<Topic> topics;
    
    PublisherImpl(String name) {
        this.name = name;
        topics = new ArrayList<Topic>();
    }
    
    public void registerTopic(Topic topic) {
        topics.add(topic);
        System.out.println("Registered To Topic.");
    }
    
    public void unregisterTopic(Topic topic) {
        topics.remove(topic);
        System.out.println("Unregistered To Topic.");
    }
    
    public void publish(Topic topic, Message msg) {
        if(!this.topics.contains(topic)){
            System.out.println(this.name+" trying to publish to unregistered topic.");
            return;
        }
        for (Topic top : topics) {
            if (top.equals(topic)) {
                topic.notifySubscribers(msg);
            }
        }
    }
}

interface Subscriber {
    public void receiveMessage(Message msg);
}

class SubscriberImpl implements Subscriber {
    String name;
    
    SubscriberImpl(String name) {
        this.name = name;
    }
    
    public void receiveMessage(Message msg) {
        System.out.println("Message received to Subscriber - " + name + " : " + msg.getMessage());
    }
}

interface Topic {
    public void addSubscriber(Subscriber sub);
    public void removeSubscriber(Subscriber sub);
    public void notifySubscribers(Message msg);
    public String getName();
}

class TopicImpl implements Topic {
    public String name;
    List<Subscriber> subscribers;
    
    TopicImpl(String name) {
        this.name = name;
        subscribers = new ArrayList<Subscriber>();
    }
    
    public void addSubscriber(Subscriber sub) {
        subscribers.add(sub);
        System.out.println("Subscriber Added.");
    }
    
    public void removeSubscriber(Subscriber sub) {
        subscribers.remove(sub);
        System.out.println("Subscriber Removed.");
    }
    
    public void notifySubscribers(Message msg) {
        for (Subscriber sub : subscribers) {
            sub.receiveMessage(msg);
        }
    }

    public String getName() {
        return this.name;
    }
}

public class PubSub {
    public static void main(String[] args) {
        Topic topic1 = new TopicImpl("Topic1");
        Topic topic2 = new TopicImpl("Topic2");
        
        Publisher publisher1 = new PublisherImpl("Publisher1");
        Publisher publisher2 = new PublisherImpl("Publisher2");
        Publisher publisher3 = new PublisherImpl("Publisher3");
        
        Subscriber subscriber1 = new SubscriberImpl("Subscriber1");
        Subscriber subscriber2 = new SubscriberImpl("Subscriber2");
        Subscriber subscriber3 = new SubscriberImpl("Subscriber3");
        Subscriber subscriber4 = new SubscriberImpl("Subscriber4");
        Subscriber subscriber5 = new SubscriberImpl("Subscriber5");
        
        publisher1.registerTopic(topic1);
        publisher2.registerTopic(topic1);
        publisher3.registerTopic(topic2);
        
        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber3);
        topic2.addSubscriber(subscriber4);
        topic2.addSubscriber(subscriber5);
        
        publisher1.publish(topic1, new MessageImpl("Message1 from Publisher1"));
        publisher2.publish(topic1, new MessageImpl("Message2 from Publisher2"));
        publisher3.publish(topic2, new MessageImpl("Message3 from Publisher3"));
        publisher1.publish(topic2, new MessageImpl("Message4 from Publisher1"));
        
        topic2.removeSubscriber(subscriber4);
        publisher3.publish(topic2, new MessageImpl("Message5 from Publisher3"));
    }
}
