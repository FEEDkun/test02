import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MAIN {
    public static void main(String[] args) {
        final InsertData insertData = new InsertData();


    for (int i=0;i<3;i++) {
        new Thread() {
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();
    }


    }
}


class InsertData {

 //   演示数据竞争
 //----------------------------------------------------------------------------------------------------------------
     ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public  void insert(Thread thread){
        for(int i=0;i<5;i++){
            arrayList.add(i);
            System.out.println(thread.getName()+"插入数据"+arrayList.get(i));

        }
    }
//----------------------------------------------------------------------------------------------------------------



    //方法一：加synchronized关键字
    //----------------------------------------------------------------------------------------------------------------

//     ArrayList<Integer> arrayList = new ArrayList<Integer>();
//
//    public synchronized void insert(Thread thread){
//        for(int i=0;i<5;i++){
//            System.out.println(thread.getName()+"插入数据"+i);
//            arrayList.add(i);
//        }
//    }



    //----------------------------------------------------------------------------------------------------------------


    //方法二：加锁

    // ----------------------------------------------------------------------------------------------------------------

//    Lock lock = new ReentrantLock();
//    ArrayList<Integer> arrayList = new ArrayList<Integer>();
//
//    public void insert(Thread thread) {
//        if (lock.tryLock()) {
//            try {
//                System.out.println(thread.getName() + "得到了锁");
//                for (int i = 0; i < 5; i++) {
//                    arrayList.add(i);
//                    System.out.println(thread.getName()+"在ArrayList内加入："+arrayList.get(i));
//                }
//            } catch (Exception e) {
//                // TODO: handle exception
//            } finally {
//                System.out.println(thread.getName() + "释放了锁");
//                lock.unlock();
//            }
//        } else {
//            System.out.println(thread.getName() + "获取锁失败");
//        }
//    }

    // ----------------------------------------------------------------------------------------------------------------



    //方法三：加volatile关键字
//----------------------------------------------------------------------------------------------------------------
//     ArrayList<Integer> arrayList = new ArrayList<Integer>();
//    public volatile int i;
//    public synchronized void insert(Thread thread){
//        for(i=0;i<5;i++){
//
//            arrayList.add(i);
//            System.out.println(thread.getName()+"向arraylist插入数据"+arrayList.get(i));
//        }
//    }
//----------------------------------------------------------------------------------------------------------------
}


