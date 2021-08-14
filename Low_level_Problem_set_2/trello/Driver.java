package trello;

import trello.dao.impl.TrelloApplicationDaoImpl;
import trello.service.TrelloApplicationService;

/**
 * @author priyamvora
 * @created 20/04/2021
 */
public class Driver {
    public static void main(String[] args) {
        TrelloApplicationService trelloApplicationService = new TrelloApplicationService(TrelloApplicationDaoImpl.getInstance());
        String boardId1 = trelloApplicationService.addBoard("Priyam");
        System.out.println("Board created: " + trelloApplicationService.getBoard(boardId1));
        System.out.println(trelloApplicationService.show());
        String listId1 = trelloApplicationService.addList(boardId1, "List1");
        System.out.println(trelloApplicationService.show());
        String card1 = trelloApplicationService.addCard(listId1, "card1");
        trelloApplicationService.assignCard(card1, "priyam@hike.in");
        System.out.println(trelloApplicationService.show());

        String boardId2 = trelloApplicationService.addBoard("Priyam2");
        System.out.println("Board created: " + trelloApplicationService.getBoard(boardId2));
        System.out.println(trelloApplicationService.show());
        String listId2 = trelloApplicationService.addList(boardId2, "List2");
        System.out.println(trelloApplicationService.show());
        String card2 = trelloApplicationService.addCard(listId2, "card2");
        trelloApplicationService.assignCard(card2, "priyam2@hike.in");
        System.out.println(trelloApplicationService.show());

        trelloApplicationService.moveList(listId1, boardId2);
        System.out.println(trelloApplicationService.show());
    }
}
