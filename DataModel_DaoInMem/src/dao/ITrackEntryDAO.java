package dao;

import core.TrackEntry;

import java.util.List;

public interface ITrackEntryDAO {
    TrackEntry addTrackEntry(TrackEntry trackEntry);

    TrackEntry findTrackEntryById(Long trackEntryId);

    List<TrackEntry> findAll();

    TrackEntry update(TrackEntry trackEntry);

    void remove(Long trackEntryId);
}
