package com.flipkart.messaging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.IOUtils;


/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 9:59 PM
 * <p/>
 * Structure is BASEDIR/$TOPIC_NAME/$MESSAGE_IDENTIFIER
 * <p/>
 * MESSAGE_IDENTIFIER = $TIME_ID
 *
 * @author anirudha
 */
public class FilePersistentStore {

    private final File baseDir;

    public FilePersistentStore(String workingDir) throws FilePersistentStoreException {
        File bDir = new File(workingDir);
        if (bDir.exists() && bDir.isFile()) {
            throw new FilePersistentStoreException("Base Directory " + bDir.getAbsolutePath() + " MUST be a DIRECTORY");
        }

        if (!bDir.exists()) {
            bDir.mkdir();
        }
        this.baseDir = bDir;
    }

    public void write(Topic topic, Message message) throws FilePersistentStoreException {
        BufferedWriter bw = null;
        try {
            File topicDir = new File(this.baseDir, topic.getName());
            if (!topicDir.exists()) {
                topicDir.mkdir();
            }
            bw = new BufferedWriter(new FileWriter(message.getFile()));
            bw.write(message.getContent());
        } catch (Exception e) {
            throw new FilePersistentStoreException("exception while writing message to topic " + topic.getName(), e);
        } finally {
            IOUtils.closeQuietly(bw);
        }
    }

    public List<Message> getNextMessage(Topic topic, Message lastConsumedMessage) throws IOException {
        File topicDir = new File(this.baseDir, topic.getName());
        File[] msgFiles = topicDir.listFiles();
        List<Message> messages = toMessages(msgFiles);
        Collections.sort(messages, new MessageComparator());
        if (lastConsumedMessage == null) {
            return messages;
        }
        int idx = Collections.binarySearch(messages, lastConsumedMessage, new MessageComparator());
        return messages.subList(idx+1, messages.size());
    }

    protected List<Message> toMessages(File[] files) throws IOException {
        List<Message> messages = new ArrayList<Message>();
        for (File f : files) {
            Message msg = new Message(f);
            messages.add(msg);
        }
        return messages;
    }

    static class MessageComparator implements Comparator<Message> {

        @Override
        public int compare(Message message1, Message message2) {
            return message1.getCreationTime().compareTo(message2.getCreationTime());
        }
    }

    static class FilePersistentStoreException extends Exception {

        public FilePersistentStoreException(String msg) {
            super(msg);
        }

        public FilePersistentStoreException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }
}
