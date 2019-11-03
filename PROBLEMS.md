Questions (from the text):

1. The three-parameter constructor for `DoublyLinkedNodes` makes use of two `if` statements.
Suppose that you replace the calls to the constructor with the one-parameter constructor
and manually use `setNext` and `setPrevious` to set the appropriate reference.
The `if` statements disappear. Why?

    The if statements in the DoublyLinkedNodes constructor is checking whether or not
    the next and/or previous element in the list is null. When calling the one-parameter
    constructor, a next and previous node is not passed through the parameters,
    so there is no longer a need to check for the presence of a null value in before
    and after the new node being created.

2. The `contains` method can be written making use of the `indexOf` method, but not the other way around. Why?

    The contains method returns a boolean value and only needs to check if a particular
    element exists in the list that matches the value given. Thus, it is able to make
    use of the indexOf method because it can function based on whether the return value
    of indexOf is positive or negative. On the other hand, the indexOf method requires
    the specific index of an element with a value that matches the one being compared.
    Using the contains method would provide no functional use in accomplishing that.

3. Notice that we could have replaced the method `insertAfter` with a similar method, `insertBefore`.
This method inserts a new value before the indicated node. Some changes would have to be made to your code.
There does not appear, however, to be a choice between versions of `remove`. Why is this the case?
(Hint: Do you ever pass a dummy node to `remove`?)

    The insertAfter and the insertBefore methods would both work because they are
    based on the positioning of a node relative to another one (either before or
    after it). This line of reasoning would not work for the remove method because
    the operations inside the method are performed without needing to know the specific
    element that came either before or after it. In all cases, the remove method
    would need to change the paths of both the element before and after it, so there
    wouldn't be another way of writing the method as there is for insertAfter.

4. Even though we don’t need to have the special cases in, for example, the indexed version of `add`,
it is desirable to handle one or more cases in a special way. What are the cases, and why is it desirable?

    The special cases would be if the index given in the parameter referred to
    either the first (i=0) or last (i=size()) elements of the list. Although they
    wouldn't throw an error if these specific cases were not addressed in an if
    statement, it would be beneficial to single them out because the separate
    addFirst() or addLast() methods could be called to take care of them.

5. Which file is bigger: your final result source or the original?

    The original file is bigger because even though my final code has added two extra
    dummy nodes to the list, it has also simplified many of the other methods in the
    class. It removed the majority of the if statements in the methods, simplifying
    the code and therefore reducing the size of the file.
