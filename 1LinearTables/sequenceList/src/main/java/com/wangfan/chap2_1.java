package com.wangfan;

/**
 * @author wang fan
 * @date 2024/5/31 20:12
 * @description 将两个顺序表合并成一个
 */
public class chap2_1 {

    public static <T extends Comparable> void MergeList_Sq(SequenceList<T> LA, SequenceList<T> LB,
                                                           SequenceList<T> LC) {
        /*已知顺序线性表LA和LB的元素按值非递减排列，归并LA和LB得到新的顺序  线性表LC，LC的元素也按值非递减排列*/
        int i=1, j=1, k=1;
        while (i<=LA.size() && j<=LB.size()) {
            if (LA.value(i).compareTo(LB.value(j)) <= 0) {
                LC.add(LA.value(i), k);
                i++;
            }
            else {
                LC.add(LB.value(j), k);
                j++;
            }
            k++;
        }
        // 比较两个列表完成后,如果LA中的元素还有存在，LA则值顺序填充
        while (i <= LA.size()) {
            LC.add(LA.value(i), k);
            i++;
            k++;
        }
        // 比较两个列表完成后,如果LB中的元素还有存在，LB则值顺序填充
        while (j <= LB.size()) {
            LC.add(LB.value(j), k);
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int i,j,k=0;
        int[] a={12,23,35,49,56};
        int[] b={10,15,20};
        SequenceList<Integer> La=new SequenceList<Integer>( );
        SequenceList<Integer> Lb=new SequenceList<Integer>( );
        SequenceList<Integer> Lc=new SequenceList<Integer>( );
        for(i=0;i<a.length;i++) {
            La.add(a[i], i+1);   //将数组中各元素插入到顺序表中
        }
        System.out.println("顺序表a中的数据元素为：");
        La.nextOrder();
        for(j=0;j<b.length;j++) {
            Lb.add(b[j], j+1);   //将数组中各元素插入到顺序表中
        }
        System.out.println("顺序表b中的数据元素为：");
        Lb.nextOrder();
        MergeList_Sq(La,Lb,Lc);
        System.out.println("顺序表C中的数据元素为：");
        Lc.nextOrder();
    }
}
