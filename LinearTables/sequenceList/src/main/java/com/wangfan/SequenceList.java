package com.wangfan;

/**
 * @author wang fan
 * @date 2024/5/31 11:20
 * @description 顺序表
 */
public class SequenceList<T> {
    private Integer length;
    private Object[] listArray;
    public SequenceList() {
        this.length = 0;
        this.listArray = new Object[16];
    }

    public SequenceList(int n) {
        if (n <= 0) {
            System.out.println("error");
            System.exit(1);
        }
        // 线性表初始化
        this.length = 0;
        this.listArray = new Object[n];
    }

    /**
     * 顺序表插入
     * @param obj 对象
     * @param pos 位置
     * @return 返回是否插入成功
     * 1.校验pos的有效性，pos的访问为1<=pos<=length+1
     * 2.数据区域有listArray.length存储单元，如果满了要重新分配
     * 3.从表尾开始依次向后移动元素，知道让出位置pos
     * 4.顺序表长度+1
     */
    public boolean add(T obj, int pos) {
        if (pos < 1 || pos > length + 1) {
            System.out.println("pos值不合法");
            return false;
        }

        // 如果内部数组已经填满，需要进行扩容
        if (length == listArray.length) {
            Object[] objects = new Object[length * 2];
            for (int i = 0; i < length; i++) {
                objects[i] = listArray[i];
            }
            listArray = objects;
        }

        // 从pos位置开始判断，将pos后的位置向后移动一位
        for (int i = length; i >= pos; i--) {
            listArray[i] = listArray[i-1];
        }

        listArray[pos - 1] = obj;
        length++;
        return true;
    }

    /**
     * 删除节点
     * @param pos 删除的位置
     * @return 返回删除的数据
     */
    public T remove(int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空，无法执行删除操作");
            return null;
        }
        else {
            if (pos < 1 || pos > length) {
                System.out.println("pos值不合法");
                return null;
            }
            T x = (T) listArray[pos-1];
            for (int i = pos; i <= length; i++) {
                listArray[i-1] = listArray[i];
            }
            length--;
            return x;
        }
    }

    /**
     * 顺序表查找
     * @param obj 对象
     * @return 返回对象位置
     */
    public int find(T obj) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return -1;
        }
        else {
            for (int i = 0; i < length; i++) {
                if (listArray[i].equals(obj)) {
                    return i+1;
                }
            }
            return -1;
        }
    }

    /**
     * 获取value数据
     * @param pos 位置
     * @return 返回该位置数据
     */
    public T value(int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return null;
        }
        else {
            if (pos < 1 || pos > length) {
                System.out.println("pos值不合法");
                return null;
            }
            return (T) listArray[pos - 1];
        }
    }

    /**
     * 更新元素
     * @param obj 对象
     * @param pos 位置
     * @return 返回更新结果
     */
    public boolean modify(T obj, int pos) {
        if (isEmpty()) {
            System.out.println("顺序表为空");
            return false;
        }
        else {
            if(pos<1||pos>length){
                System.out.println("error");
                return false;
            }
            listArray[pos-1]=obj;
            return true;
        }
    }

    public int size() {
        return length;
    }


    public Boolean isEmpty() {
        return this.length.equals(0);
    }

    public void nextOrder() {
        for (int i= 0; i < length; i++) {
            System.out.print(listArray[i]);
            System.out.print(" ，");
        }
        System.out.println();
    }

    public void clear(  ) {
        length=0;
    }


    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Object[] getListArray() {
        return listArray;
    }

    public void setListArray(Object[] listArray) {
        this.listArray = listArray;
    }
}
