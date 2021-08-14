package trello.dao.impl;

import trello.constants.BoardType;
import trello.dao.TrelloApplicationDao;
import trello.model.Board;
import trello.model.BoardList;
import trello.model.Card;
import trello.model.User;

import java.util.*;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public class TrelloApplicationDaoImpl implements TrelloApplicationDao {
    private final Map<String, Board> boardIdToBoardMap;
    private final Map<String, BoardList> listIdToListMap;
    private final Map<String, Card> cardIdToCardMap;
    private final List<User> users;

    private static TrelloApplicationDao trelloApplicationDao;

    private TrelloApplicationDaoImpl() {
        this.boardIdToBoardMap = new HashMap<>();
        this.listIdToListMap = new HashMap<>();
        this.cardIdToCardMap = new HashMap<>();
        this.users = new ArrayList<>();
    }

    public static TrelloApplicationDao getInstance() {
        if (trelloApplicationDao == null) {
            trelloApplicationDao = new TrelloApplicationDaoImpl();
        }
        return trelloApplicationDao;
    }

    @Override
    public List<Board> getAllBoards() {
        return new ArrayList<>(boardIdToBoardMap.values());
    }

    @Override
    public void addBoard(Board board) {
        boardIdToBoardMap.put(board.getEntityId(), board);
    }

    @Override
    public BoardList addList(BoardList list, String boardId) {
        Board board = getBoard(boardId);
        if (board == null) {
            return null;
        }
        board.addToList(list);
        listIdToListMap.put(list.getEntityId(), list);
        return list;
    }

    @Override
    public Card addCard(Card card, String listId) {
        BoardList list = getList(listId);
        if (list == null) {
            return null;
        }
        list.addCard(card);
        cardIdToCardMap.put(card.getEntityId(), card);
        return card;
    }

    @Override
    public BoardList getList(String listId) {
        return listIdToListMap.getOrDefault(listId, null);
    }

    @Override
    public Board getBoard(String boardId) {
        return boardIdToBoardMap.getOrDefault(boardId, null);
    }

    @Override
    public List<BoardList> getListForBoard(String boardId) {
        Board board = getBoard(boardId);
        if (board == null) {
            return null;
        }
        return board.getList();
    }

    @Override
    public List<Card> getCardsForList(String listId) {
        BoardList boardList = getBoardList(listId);
        if (boardList == null) {
            return null;
        }
        return boardList.getCardList();
    }

    @Override
    public BoardList getBoardList(String listId) {
        return listIdToListMap.getOrDefault(listId, null);
    }

    @Override
    public Card getCard(String cardId) {
        return cardIdToCardMap.getOrDefault(cardId, null);
    }

    @Override
    public Board setBoardName(String name, String boardId) {
        Board board = getBoard(boardId);
        if (board == null) {
            return null;
        }
        board.setName(name);
        return board;
    }

    @Override
    public BoardList setListName(String name, String listId) {
        BoardList boardList = getList(listId);
        if (boardList == null) {
            return null;
        }
        boardList.setName(name);
        return boardList;
    }

    @Override
    public Card setCardName(String name, String cardId) {
        Card card = getCard(cardId);
        if (card == null) {
            return null;
        }
        card.setName(name);
        return card;
    }

    @Override
    public Card setCardAssignedTo(String assignedToEmail, String cardId) {
        Card card = getCard(cardId);
        if (card == null) {
            return null;
        }
        card.setAssignedTo(assignedToEmail);
        return card;
    }

    @Override
    public Board setBoardPrivacy(String boardId, BoardType privacy) {
        Board board = getBoard(boardId);
        if (board == null) {
            return null;
        }
        board.setPrivacy(privacy);
        return board;
    }

    @Override
    public Board addMemberInBoard(User user, String boardId) {
        Board board = getBoard(boardId);
        if (board == null) {
            return null;
        }
        board.addMember(user);
        return board;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User getUser(String userId) {
        Optional<User> userObj = users.stream().filter(user -> user.getUserId().equals(userId)).findFirst();
        return userObj.orElse(null);
    }

    @Override
    public Board removeMemberInBoard(String userId, String boardId) {
        Board board = getBoard(boardId);
        if (board == null) {
            return null;
        }
        board.removeMember(userId);
        return board;
    }

    @Override
    public Board deleteBoard(String boardId) {
        Board board = boardIdToBoardMap.remove(boardId);
        if (board == null) {
            return null;
        }
        for (BoardList boardList : board.getList()) {
            board.removeList(boardList.getEntityId());
            deleteList(boardList.getEntityId());
        }
        return board;
    }

    @Override
    public BoardList deleteList(String listId) {
        BoardList boardList = listIdToListMap.remove(listId);
        if (boardList == null) {
            return null;
        }
        for (Card card : boardList.getCardList()) {
            boardList.removeCard(card.getEntityId());
            deleteCard(card.getEntityId());
        }
        return boardList;
    }

    @Override
    public Card deleteCard(String cardId) {
        return cardIdToCardMap.remove(cardId);
    }

    @Override
    public BoardList moveList(String listId, String newBoardId) {
        Board newBoard = getBoard(newBoardId);
        for (Board board : boardIdToBoardMap.values()) {
            Optional<BoardList> boardList = board.getList().stream().filter(list -> list.getEntityId().equals(listId)).findFirst();
            if (boardList.isPresent()) {
                board.removeList(listId);
                newBoard.addToList(boardList.get());
                return boardList.get();
            }
        }
        return null;
    }

    @Override
    public Card moveCard(String cardId, String newListId) {
        BoardList newBoardList = getBoardList(newListId);
        for (BoardList boardList : listIdToListMap.values()) {
            Optional<Card> card = boardList.getCardList().stream().filter(cardObj -> cardObj.getEntityId().equals(cardId)).findFirst();
            if (card.isPresent()) {
                boardList.removeCard(cardId);
                newBoardList.addCard(card.get());
                return card.get();
            }
        }
        return null;
    }

}
