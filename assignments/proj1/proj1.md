# Project 1

## The Deque API

- Deque (double ended queue) are sequence containers with dynaic sizes that can be expanded or contracted on both ends (either its front or its back)

- Deque 的接口

    - `public void addFirst(T item)`
    - `public void addLast(T item)`
    - `public boolean isEmpty()`
    - `public int size()`
    - `public void printDeque()` 每个 item 之间使用空格隔开
    - `public T removeFirst()` 同时返回第一个 item
    - `public T removeLast()` 同时返回最后一个 item
    - `public T get(int index)` where 0 is the front, 1 is the next item, ... (使用 iteration 来实现)

    ---

    - `public T getRecursive(int index)` get 的 recursion 版本
    - `public T LinkedListDeque()` the constructor (Creates an empty linked list deque)

