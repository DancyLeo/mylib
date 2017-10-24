package algorithm.sort;
/*归并排序算法
 * 作者：夜苍山
 */
public class MergeSort {
	public static int count=0 ;
	public static void merge(int[] A,int begin,int middle,int end) {//合并数组A中划分元素middle左右两部分元素，（A,begin,middle)和（A,middle+1,end)
		int n1 = middle-begin+1 ; //n1表示存放第一个元素集合的数组大小
		int n2 = end-middle ;//n2表示存放第一个元素集合的数组大小
		int[] L = new int[n1+1] ;//创建L数组，用于存放左半部分的元素
		int[] R = new int[n2+1] ;//创建R数组，用于存放右半部分的元素		
		
		for(int i=0;i<n1;i++) //依次将A数组左半部分的元素复制到L数组
			L[i] = A[begin+i] ;
		for(int j=0;j<n2;j++) //依次将A数组右半部分的元素复制到R数组
			R[j] = A[middle+j+1] ;
	
		L[n1] = Integer.MAX_VALUE ;//在L和R数组最后一个元素存入无穷大数，当索引到此数时，说明L或R数组已经没有元素
		R[n2] = Integer.MAX_VALUE ;//for循环将另一个数组的所有元素顺序排在有序数组A后面
		for(int i=0,j=0,k=begin;k<=end;k++) {//比较L和R数组的元素，将较小的元素放入有序数组A,注意这里的K等于此次合并的数组在整个A数组中的位置
			if(L[i]<= R[j]) {//L当前元素小于等于R当前元素
				A[k] = L[i] ;//将L当前元素放入A
				i++ ;//L索引指向下一个元素
			}else {//L当前元素大于R当前元素
				A[k] = R[j] ;//将R当前元素放入A
				j++ ;//R指向下一个元素
			}
		}
	}
	
	public static void mergeSort(int[] A,int begin,int end) {//递归合并子数组
		if(begin<end) {//begin小于end说明此数组大于两个元素，可以继续划分
			int middle = (begin+end)/2 ; //计算划分的位置，一般从中间划分
			mergeSort(A,begin,middle) ;//对左半部分继续划分
			mergeSort(A,middle+1,end) ;//对右半部分继续划分
			merge(A,begin,middle,end) ;//合并
			System.out.print("第" + ++count + "次合并");
			for(int i=begin;i<=end;i++) {
				System.out.print(A[i]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[] A = {2,8,7,1,6,5,3,4} ;
		mergeSort(A,0,A.length-1) ;
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i] + ",");
		}
	}
}
