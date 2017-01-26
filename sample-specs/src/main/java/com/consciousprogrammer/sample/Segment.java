package com.consciousprogrammer.sample;

import java.math.BigDecimal;

/**
 * Segment represents a mutable line segment on a Cartesian plane.
 *
 * @specfield startPoint : Point // The start point of the segment.
 * @specfield endPoint : Point   // The end point of the segment.
 *
 * @derivedfield length : real   // length = sqrt((startPoint.x - endPoint.x)^2
 *                                            + (startPoint.y - endPoint.y)^2)
 *                                  The distance between startPoint and endPoint
 *
 * @invariant length > 0
 */
public class Segment {

    private int startX;
    private int startY;
    private BigDecimal length;
    private BigDecimal angle;

    /*
     * Abstraction Function:
     *   startPoint = (startX, startY)
     *   endPoint.x = startX + length * cos(angle)
     *   endPoint.y = startY + length * sin(angle)
     *
     * Representation Invariant:
     *   length != null
     *   length > 0
     *   angle != null
     */

    /**
     * @effects Asserts the rep invariant holds for this.
     */
    private void checkRep() {
        // ...
    }

    /**
     * @requires startPoint != null && endPoint != null &&
     *           startPoint != endPoint
     * @effects Makes this be a new Segment s, with s.startPoint = startPoint
     *          and s.endPoint = endPoint.
     */
    public Segment(Point startPoint, Point endPoint) {
        // ...

        checkRep();
    }

    /**
     * @requires startPoint != null && startPoint != this.endPoint
     * @modifies this
     * @effects Sets this.startPoint to startPoint
     */
    public void setStartPoint(Point startPoint) {
        // ...

        checkRep();
    }

    /**
     * @requires segment != null
     * @return this.length - segment.length, i.e., the difference in length
     *         between this and segment.
     */
    public double differenceInLength(Segment segment) {
        // ...

        throw new UnsupportedOperationException("Not implemented yet");
    }

    // ...
}
