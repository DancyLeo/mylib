package algorithm.sort ;
/*快速排序算法-N.motubo版
 * 作者：夜苍山
 */
public class QuickSortN {
	public static int count=0 ;
	public static int partision(int[] A,int begin,int end) {//划分方法
		int temp=0;
		int i=begin-1;//开始时i在数组的第一个元素前面
		int j=begin ;//j在数组的第一个元素
		int x=A[end];//选取数组最后一个元素为基准元素

		while(j<end) {//从第一个元素A[0]开始，依次遍历每个元素至倒数第二个元素A[end-1]
			if(A[j]<x) {//如果A[j]小于基准元素x，则跟A[i+1]的元素交换,以下是交换过程
				i++;
				//System.out.print("j=" + j + "i=" + i );
				//A[j]与A[i+1]交换
				temp = A[i] ;
				A[i] = A[j] ;
				A[j] = temp ;
				j++;//j移动到下一个元素
			}else j++;//如果A[j]不小于基准元素x，则跟j自增1，移动到下一个元素，重复While循环，直到倒数第二个元素A[end-1]
		}
		//每一次遍历到A[end-1]后，将最后一个元素（基准元素）与第i+1个元素交换
		temp = A[i+1] ;
		A[i+1] = A[end] ;
		A[end] = temp ;
		//最后数组将分成三个部分，A[begin,i],A[i+1],A[i+2,end]，注意这个时候基准元素为A[i+1]，所以i的位置在基准元素前面
		return i+1 ;//返回基准元素位置值
	}
	
	public static void quicksort(int[] A,int begin,int end) {//快速排序方法
		int p = partision(A,begin,end) ;//划分数组，返回基准元素位置值
		//+++++++++++++++++++++++此代码为演示输出代码+++++++++++++++++++++++
		System.out.print("第" + (++count) + "次排序后：");
		System.out.print("(");
		for(int m=0;m<p;m++) {
			System.out.print(A[m]);	
		}
		System.out.print(")(" + A[p] + ")(");
		for(int m=p+1;m<end+1;m++) {
			System.out.print(A[m]);
		}
		System.out.print(") " + "基准元素是：" + A[p] + "\n");
		//+++++++++++++++++++++++此代码为演示输出代码+++++++++++++++++++++++
		if(begin<p-1)//对于划分之后，在基准元素前半部分的数组，满足begin<p-1说明数组元素大于两个，可以继续划分
		quicksort(A,begin,p-1) ;
		if(p+1<end)//对于划分之后，在基准元素后半部分的数组，满足p+1<end说明数组元素大于两个，可以继续划分
		quicksort(A,p+1,end) ;
	}
	public static void main(String[] args) {
		int[] A = {2,8,7,1,3,5,6,4} ;
		quicksort(A,0,A.length-1) ;
		System.out.print("最终排序:");
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i] + ",");	
		}
	}
}
