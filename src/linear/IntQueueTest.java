package linear;

/**
 * 数组实现队列
 */
public class IntQueueTest {


    public static class IntQueue {

        /**
         * 存的数组
         */
        private Integer[] array;
        /**
         * 数组大小
         */
        private int maxSize;

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

        /**
         * 添加数组
         * @param value
         */
        public void add(Integer value) {

        }





    }
}

