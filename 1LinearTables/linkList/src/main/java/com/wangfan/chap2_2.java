package com.wangfan;

/**
 * @author wang fan
 * @date 2024/6/1 11:17
 * @description
 */
public class chap2_2 {
    // 有顺序链表合并
    public static <T extends Comparable> void MergeList_L(LinkList<T> La, LinkList<T> Lb,LinkList<T> Lc) {
        /*已知单链表La和Lb的元素按值非递减排列。归并La和Lb得到新的单链表Lc，
        Lc的元素也按值非递减排列*/
        Node<T> pa,pb,pc;
        pa = La.getHead().getNext();
        pb = Lb.getHead().getNext();
        pc = Lc.getHead();
        while (pa != null && pb != null) {
            if (pa.getData().compareTo(pb.getData()) <= 0) {
                pc.setNext(pa);
                pc = pa;
                pa = pa.getNext();
            }
            else {
                pc.setNext(pb);
                pc = pb;
                pb = pb.getNext();
            }
        }

        while (pa != null) {
            pc.setNext(pa);
            pc = pa;
            pa = pa.getNext();
        }
        while(pb!=null){
            pc.setNext(pb);
            pc=pb;
            pb=pb.getNext();
        }
        La.clear();
        Lb.clear();
    }

    // 多项式相加
    public static <T extends Item> LinkList<T> polyAdd (LinkList<T> La, LinkList<T> Lb) {
        LinkList<T> Lc = new LinkList<>();
        int a = 1, b = 1;
        while (a <= La.size() && b <= Lb.size()) {
            T x1 = La.value(a), x2 = Lb.value(b);
            if (x1.compareTo(x2) < 0) {
                Lc.add(x1, Lc.size()+1);
                a++;
            }
            else if (x1.compareTo(x2)>0) {
                Lc.add(x2, Lc.size()+1);
                b++;
            }
            else {
                double y = x1.getCoef() + x2.getCoef();
                if (Math.abs(y) > 1.0E-6) {
                    x1.add(x2);
                    Lc.add(x1, Lc.size()+1);
                }
                a++;
                b++;
            }
        }

        while (a <= La.size()) {
            Lc.add(La.value(a), Lc.size()+1);
            a++;
        }
        while (b <= Lb.size()) {
            Lc.add(Lb.value(b), Lc.size()+1);
            b++;
        }
        return Lc;
    }


    public static void main(String[] args) {
        int i,j,k=0;
        int[] a={12,23,35,49,56};
        int[] b={10,15,20};
        LinkList<Integer> La=new LinkList<Integer>( );
        LinkList<Integer> Lb=new LinkList<Integer>( );
        LinkList<Integer> Lc=new LinkList<Integer>( );
        for(i=0;i<a.length;i++) {
            La.add(a[i], i+1);   //将数组中各元素插入到单链表中
        }
        System.out.println("单链表a中的数据元素为：");
        La.nextOrder();
        for(j=0;j<b.length;j++) {
            Lb.add(b[j], j+1);   //将数组中各元素插入到单链表中
        }
        System.out.println("单链表b中的数据元素为：");
        Lb.nextOrder();
        MergeList_L(La,Lb,Lc);
        System.out.println("单链表C中的数据元素为：");
        Lc.nextOrder();
    }
}
