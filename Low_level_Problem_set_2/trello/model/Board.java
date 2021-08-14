package trello.model;

import trello.constants.BoardType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public class Board extends Entity {
    public BoardType privacy;
    private final String URL;
    private List<User> members;
    private List<BoardList> list;

    public Board(String name) {
        super(name);
        this.privacy = BoardType.PUBLIC;
        this.URL = "http://trello.com/" + getEntityId();
        this.members = new ArrayList<>();
        this.list = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void removeMember(String userId) {
        this.members = members.stream().filter(user -> !user.getUserId().equals(userId)).collect(Collectors.toList());
    }

    public void removeList(String listId) {
        this.list = list.stream().filter(listObj -> !listObj.getEntityId().equals(listId)).collect(Collectors.toList());
    }

    public void setPrivacy(BoardType privacy) {
        this.privacy = privacy;
    }

    public BoardType getPrivacy() {
        return privacy;
    }

    public String getURL() {
        return URL;
    }

    public List<User> getMembers() {
        return members;
    }

    public void addToList(BoardList boardList) {
        this.list.add(boardList);
    }

    public List<BoardList> getList() {
        return list;
    }

    @Override
    public String toString() {
        return super.toString() + " Board{" +
                "privacy=" + privacy +
                ", URL='" + URL + '\'' +
                ", members=" + members +
                ", list=" + list +
                '}';
    }
}
