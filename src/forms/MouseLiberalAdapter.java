
package forms;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

/**
 *
 * @author HP
 */


  
        public abstract class MouseLiberalAdapter extends MouseAdapter {

        /**
         * isComponentPressedDown, This indicates whether or not the component is currently
         * (conceptually) "pressed down". To understand the meaning of "pressed down", consider the
         * behavior of a JButton. When you press the mouse inside a button, the button redraws itself to
         * indicate a "press down" state. If you release the mouse while inside the button, a button
         * click will be registered, and the button will switch to a "not press down" state. The button
         * can also become "not pressed down" if the mouse pointer leaves the boundaries of the button
         * without first releasing the mouse.
         */
        private boolean isComponentPressedDown = false;
        /**
         * lastUnusedLiberalSingleClickTimeStamp, This stores a timestamp for the mouse release of the
         * last unused liberal single click. If a single click is "used" as part of a double click, then
         * it's timestamp will no longer be stored here. If there is no liberal single click which fits
         * the above description, then this will contain the value zero.
         */
        private long lastUnusedLiberalSingleClickTimeStamp = 0;
        /**
         * slowestDoubleClickMilliseconds, This constant indicates the maximum time window in which a
         * liberal double click can occur. More specifically, this indicates the maximum time, in
         * milliseconds, between liberal single click mouse releases, that will be considered to
         * constitute a liberal double click.
         */
        private final int slowestDoubleClickMilliseconds = 1800;

        /**
         * mouseLiberalClick, Override this function to catch liberal single click events.
         *
         * Note: The mouse event which is passed to this function will be the mouse event that was
         * received from the "mouseRelease" event at the end of the liberal single click.
         */
        public void mouseLiberalClick(MouseEvent e) {
        }

        /**
         * mouseLiberalDoubleClick, Override this function to catch liberal double click events.
         *
         * Note: The mouse event which is passed to this function will be the mouse event that was
         * received from the "mouseRelease" event at the end of the liberal double click.
         */
        public void mouseLiberalDoubleClick(MouseEvent e) {
        }

        /**
         * mouseClick, Override this function to catch standard mouse click events.
         */
        public void mouseClick(MouseEvent e) {
        }

        /**
         * mousePress, Override this function to catch standard mouse press events.
         */
        public void mousePress(MouseEvent e) {
        }

        /**
         * mouseRelease, Override this function to catch standard mouse release events.
         */
        public void mouseRelease(MouseEvent e) {
        }

        /**
         * mouseEnter, Override this function to catch standard mouse enter events.
         */
        public void mouseEnter(MouseEvent e) {
        }

        /**
         * mouseExit, Override this function to catch standard mouse exit events.
         */
        public void mouseExit(MouseEvent e) {
        }

        /**
         * mouseWheelMove, Override this function to catch standard mouse wheel move events.
         */
        public void mouseWheelMove(MouseWheelEvent e) {
        }

        /**
         * mouseDrag, Override this function to catch standard mouse drag events.
         */
        public void mouseDrag(MouseEvent e) {
        }

        /**
         * mouseMove, Override this function to catch standard mouse move events.
         */
        public void mouseMove(MouseEvent e) {
        }

        /**
         * mousePressed, Final function. Handles mouse pressed events.
         */
        @Override
        final public void mousePressed(MouseEvent e) {
            // Record that the component is "pressed down".
            isComponentPressedDown = true;
            // Call the mouse press event.
            mousePress(e);
        }

        /**
         * mouseReleased, Final function. Handles mouse released events. This function also detects
         * liberal single clicks, and liberal double clicks.
         */
    
        final public void mouseReleased(MouseEvent e) {
            // Check to see if this mouse release completes a liberal single click.
            if (isComponentPressedDown) {
                // A liberal single click has occurred.
                mouseLiberalClick(e);
                // Check to see if we had two liberal single clicks within the double click time window.
                long now = System.currentTimeMillis();
                long timeBetweenUnusedClicks = now - lastUnusedLiberalSingleClickTimeStamp;
                if (timeBetweenUnusedClicks <= slowestDoubleClickMilliseconds) {
                    // A liberal double click has occurred.
                    mouseLiberalDoubleClick(e);
                    // Mark the single click timestamp as "used" by this double click.
                    lastUnusedLiberalSingleClickTimeStamp = 0;
                } else {
                    // Save the single click timestamp as part of a possible future double click.
                    lastUnusedLiberalSingleClickTimeStamp = System.currentTimeMillis();
                }
            }
            // Record the mouse release.
            isComponentPressedDown = false;
            // Call the mouse release event.
            mouseRelease(e);
        }

        /**
         * mouseEntered, Final function. Handles mouse entered events.
         */
  
        final public void mouseEntered(MouseEvent e) {
            // Call the mouse enter event.
            mouseEnter(e);
        }

        /**
         * mouseExited, Final function. Handles mouse exited events.
         */
        
        final public void mouseExited(MouseEvent e) {
            // Since the mouse left the component, the component is no longer considered "press down".
            isComponentPressedDown = false;
            // Call the mouse exit event.
            mouseExit(e);
        }

        /**
         * mouseClicked, Final function. Handles mouse clicked events.
         */
        final public void mouseClicked(MouseEvent e) {
            // Call the mouse click event.
            mouseClick(e);
        }

        /**
         * mouseWheelMoved, Final function. Handles mouse wheel moved events.
         */
        final public void mouseWheelMoved(MouseWheelEvent e) {
            // Call the mouse wheel move event.
            mouseWheelMove(e);
        }

        /**
         * mouseDragged, Final function. Handles mouse dragged events.
         */
        final public void mouseDragged(MouseEvent e) {
            // Call the mouse drag event.
            mouseDrag(e);
        }

        /**
         * mouseMoved, Final function. Handles mouse moved events.
         */
        final public void mouseMoved(MouseEvent e) {
            // Call the mouse move event.
            mouseMove(e);
        }
    
    }
    

