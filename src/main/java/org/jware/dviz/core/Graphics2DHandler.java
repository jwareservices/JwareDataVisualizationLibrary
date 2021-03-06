
package org.jware.dviz.core;

/*
 * Copyright (C) 2014 J. Paul Jackson <jwareservices@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * File: Graphics2DHandler.java Created On: 04/00/2014
 *
 * @author J. Paul Jackson <jwareservices@gmail.com>
 *
 * Purpose:
 */
//public class Graphics2DHandler extends AbstractGraphicsHandlerBuffered {
public class Graphics2DHandler extends AbstractGraphicsHandler {

    /**
     * Pre-set primitives for re-use
     */
    Line2D.Float line;
    Ellipse2D.Float ellipse;
    Rectangle2D.Float rect;
    Arc2D.Float arc;

    /**
     * 
     */
    public Graphics2DHandler() {
        
        super();

        line = new Line2D.Float();
        ellipse = new Ellipse2D.Float();
        rect = new Rectangle2D.Float();
        arc = new Arc2D.Float();
    }

    /**
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public void line(float x1, float y1, float x2, float y2) {
        
        line.setLine(x1, y1, x2, y2);     
        beginDraw();
        setStroke(wideStroke);
        ((Graphics2D) grafPort).draw(line);
        endDraw();
    }

    /**
     * 
     * @param x
     * @param y
     * @param radius 
     */
    public void circle(int x, int y, int radius) {
        ellipse.setFrameFromCenter(x, y, radius, radius);
        beginDraw();
        ((Graphics2D) grafPort).draw(ellipse);
        endDraw();
    }

    /**
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public void fillRect(float x1, float y1, float x2, float y2) {
        fillRect((int) x1, (int) y1, (int) x2, (int) y2);
    }

    /**
     * 
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public void fillRect(int x1, int y1, int x2, int y2) {
        beginDraw();
        grafPort.fillRect(50, 50, 100, 100);
        endDraw();
    }
}
