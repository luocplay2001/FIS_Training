package dao.mem;

import core.TrackEntry;
import dao.ITrackEntryDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrackEntryDAOMemImpl implements ITrackEntryDAO {
    private List<TrackEntry> trackEntryList = new ArrayList<>();

    public TrackEntryDAOMemImpl() {

    }

    private static TrackEntryDAOMemImpl instance = new TrackEntryDAOMemImpl();

    public static TrackEntryDAOMemImpl getInstance(){
        return instance;
    }

    @Override
    public TrackEntry addTrackEntry(TrackEntry trackEntry){
        trackEntryList.add(trackEntry);
        return trackEntry;
    }

    @Override
    public TrackEntry findTrackEntryById(Long trackEntryId) {
        Optional<TrackEntry> opt = trackEntryList.stream()
                .filter(t -> t.getTrackEntryId() == trackEntryId ? true : false).findFirst();
        if(opt.isPresent())
            return opt.get();
        return null;
    }

    @Override
    public List<TrackEntry> findAll() {
        return this.trackEntryList;
    }

    @Override
    public TrackEntry update(TrackEntry trackEntry) {
        for(TrackEntry t: this.trackEntryList){
            if(trackEntry.getTrackEntryId() == t.getTrackEntryId()) {
                t.setTrackEntry(trackEntry);
                return t;
            }
        }
        return null;
    }

    @Override
    public void remove(Long trackEntryId){
         trackEntryList.removeIf(t -> trackEntryId == (t.getTrackEntryId()));
    }

}
