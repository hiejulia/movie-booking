package com.project.moviebooking.model;

import java.math.BigInteger;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Base class for document classes.
 *
 */

@Data
public class AbstractDocument {

    @Id
    private String id;


//
//    @Override
//    public boolean equals(Object obj) {
//
//        if (this == obj) {
//            return true;
//        }
//
//        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
//            return false;
//        }
//
//        AbstractDocument that = (AbstractDocument) obj;
//
//        return this.id.equals(that.getId());
//    }
//
//    /*
//     * (non-Javadoc)
//     * @see java.lang.Object#hashCode()
//     */
//    @Override
//    public int hashCode() {
//        return id == null ? 0 : id.hashCode();
//    }
}