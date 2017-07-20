package com.dusty.lookify.repository;

import com.dusty.lookify.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dusty on 7/20/17.
 */
@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findByArtistContaining(String search);
    List<Song> findBySongNameContaining(String search);
    List<Song> findTop10ByOrderByRatingDesc();
}
