package com.project.moviebooking.repository;

import com.project.moviebooking.model.MemberDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MemberDetailRepository extends MongoRepository <MemberDetail, String > {
    /**
     * This method will retrieve the member details pertaining to
     * the name passed in.
     */
    @Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
    MemberDetail findByName(final String name);
}