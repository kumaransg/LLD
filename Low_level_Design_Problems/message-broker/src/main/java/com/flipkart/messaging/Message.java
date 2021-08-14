package com.flipkart.messaging;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: anirudha
 * Date: 4/21/13
 * Time: 10:21 PM
 *
 * @author anirudha
 */
public class Message {

    private static final String FILE_SEP = "-";

    private final Topic topic;
    private final String content;
    private final Long creationTime;
    private final Long counter;
    private final File file;


    public Message(Topic topic, String content, Long time, Long id) {
        this.topic = topic;
        this.content = content;
        this.creationTime = time;
        this.counter = id;
        this.file = new File(Long.toString(this.creationTime) + FILE_SEP + Long.toString(this.counter));
    }

    public Message(File message_file) throws IOException {
        String[] parts = message_file.getName().split(FILE_SEP);
        this.creationTime = Long.parseLong(parts[0]);
        this.counter = Long.parseLong(parts[1]);
        this.file = message_file;
        String[] parentDirs = message_file.getParent().split(File.pathSeparator);
        this.topic = new Topic(parentDirs[parentDirs.length - 1]);

        BufferedReader rdr = new BufferedReader(new FileReader(message_file));
        String line = null;
        StringBuffer buf = new StringBuffer();
        while( (line = rdr.readLine()) != null ) {
            buf.append(line);
        }
        this.content = buf.toString();
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public Long getCounter() {
        return counter;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public String getContent() {
        return this.content;
    }

    public File getFile() {
        return this.file;
    }
}
