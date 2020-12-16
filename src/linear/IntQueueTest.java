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
        System.out.println(queue);
        System.out.println(queue.get());
        System.out.println(queue);


        System.out.println(4%3);
    }


    public static class IntQueue {

        /**
         * 存的数组
         */
        private Integer[] array;
        /**
         * 数组大小
         */
        private final int maxSize;
        /**
         * 数组大小
         */
        private final int DEFAUT_MAX_SIZE=3;

        /**
         * 取的下标
         */
        private int front = -1;

        /**
         * 读的下标
         */
        private int rear = -1;

        /**
         * 构造，初始化
         * @param maxSize 数组大小
         */
        public IntQueue(int maxSize) {
            if (maxSize < 1) {
                throw new IllegalArgumentException("maxSize 值非法");
            }
            this.maxSize = maxSize;
            this.array = new Integer[maxSize];
        }
        private IntQueue() {
            this.maxSize = DEFAUT_MAX_SIZE;
            this.array = new Integer[maxSize];
        }

        /**
         * 判断队列是否满了
         * @return true 满
         */
        public boolean isFull() {
            return rear==maxSize-1;
        }

        /**
         * 判断队列是否空的
         * @return true 空
         */
        public boolean isEmpty() {
            return front == rear;
        }

        /**
         * 添加数组
         * @param value
         */
        public void add(Integer value) {
            if (isFull()) {
                throw new IllegalArgumentException("队列满了:"+value+"丢弃");
            }
            array[++rear] = value;
        }

        /**
         * 从队列中取出一个数据
         * @return 队列中的值
         */
        public Integer get() {
            if (isEmpty()) {
                System.out.println("没东西拿");
                return null;
            }
            return array[++front];
        }
        public Integer showHead() {
            if (isEmpty()) {
                System.out.println("没东西");
                return null;
            }
            return array[front+1];
        }


        @Override
        public String toString() {
            return "IntQueue{" +
                     Arrays.toString(array) +
                    '}';
        }
    }
}

