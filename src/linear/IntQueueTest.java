package linear;

import java.util.Arrays;

/**
 * 数组实现队列
 */
public class IntQueueTest {

    public static void main(String[] args) {
        IntQueue queue = new IntQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.show();
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());

        queue.show();


    }


    public static class IntQueue {

        /**
         * 存的数组
         */
        private final Integer[] array;
        /**
         * 数组大小
         */
        private final int maxSize;
        /**
         * 数组大小
         */
        private final int DEFAUT_MAX_SIZE = 3;

        /**
         * 取的下标
         */
        private int front;

        /**
         * 读的下标
         */
        private int rear;

        /**
         * 构造，初始化
         *
         * @param maxSize 数组大小
         */
        public IntQueue(int maxSize) {
            if (maxSize < 1) {
                throw new IllegalArgumentException("maxSize 值非法");
            }
            this.maxSize = maxSize+1;

            this.array = new Integer[maxSize+1];
        }

        private IntQueue() {
            this.maxSize = DEFAUT_MAX_SIZE;
            this.array = new Integer[maxSize];
        }

        /**
         * 判断队列是否满了
         *
         * @return true 满
         */
        public boolean isFull() {
            return (rear+1)%maxSize == front;
        }

        /**
         * 判断队列是否空的
         *
         * @return true 空
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * 添加数组
         *
         * @param value
         */
        public void add(Integer value) {
            if (isFull()) {
                throw new IllegalArgumentException("队列满了:   " + value + "   丢弃");
            }
            array[rear] = value;
            rear = (rear + 1) % maxSize;
        }

        /**
         * 从队列中取出一个数据
         *
         * @return 队列中的值
         */
        public Integer get() {
            if (isEmpty()) {
                System.out.println("没东西拿");
                return null;
            }
            Integer value = array[front];
            front = (front + 1) % maxSize;
            return value;
        }

        public Integer showHead() {
            if (isEmpty()) {
                System.out.println("没东西");
                return null;
            }
            return array[front + 1];
        }

        public int size() {
            return (rear+maxSize-front)%maxSize;
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("队列没东西");
                return;
            }
            StringBuilder sb = new StringBuilder("queue:");
            for (int i = front ; i < front+size(); i++) {
                sb.append(array[i%maxSize]).append(",");
            }
            System.out.println(sb.toString());
        }

    }
}

