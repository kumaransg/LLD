package service;

import exceptions.ShowAlreadyExistsException;
import exceptions.ShowNotFoundException;
import model.Show;
import service.iservice.IShowService;

import java.util.concurrent.ConcurrentHashMap;

public class ShowService implements IShowService {
    ConcurrentHashMap<Long, Show> showMap;

    public ShowService() {
        this.showMap = new ConcurrentHashMap<Long, Show>();
    }

    public Show getShowById(Long id) throws ShowNotFoundException {
        if(showMap.contains(id))
            return showMap.get(id);
        throw new ShowNotFoundException(id);
    }

    public Boolean addShow(Show show) throws ShowAlreadyExistsException {
        if(show!=null && showMap.contains(show.getId()))
            throw new ShowAlreadyExistsException(show.getId());
        showMap.put(show.getId(),show);
        return true;
    }
}
