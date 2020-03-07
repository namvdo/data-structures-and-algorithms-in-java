interface Position<E> {
    E getElement() throws IllegalStateException;
}

interface PositionList<E> {
    int size();
    boolean isEmpty();
    Position <E> first();
    Position <E> last();

    /**
     * Returns the Position immediately before Position p (or null, if p is first).
     * @param p
     * @return
     * @throws IllegalArgumentException
     *  */

    Position <E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position immediately after Position p (or null, if p is last).
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    Position <E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Inserts element e at the front of the list and returns its new Position.
     * @param e
     * @return
     */
    Position <E> addFirst(E e);

    /**
     * Inserts element e at the back of the list and returns its new Position
     * @param e
     * @return
     */
    Position <E> addLast(E e);

    /**
     * Inserts element e immediately before Position p and returns its new Position.
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    Position <E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Inserts element e immediately after Position p and returns its new Position.
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    Position <E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Replaces the element stored at Position p and returns the replaced element. 
     * @param p
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Removes the element stored at Position p and returns it (invalidating p).
     * @param p
     * @return
     * @throws IllegalArgumentException
     */
    E remove(Position<E> p) throws IllegalArgumentException;

}