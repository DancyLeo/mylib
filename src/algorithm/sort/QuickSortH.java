package algorithm.sort ;
/*快速排序算法-Hoare版
 * 作者：夜苍山
 */
public class QuickSortH {
	public static int count=0 ;
	public static int partision(int[] A,int begin ,int end) {//划分方法
		int i=begin; //i指向数组的第一个元素
		int j=end ;//j指向数组的最后一个元素
		int x = A[begin] ;//以数组的第一个元素为基准元素

		while(i<j) {//当i和j相遇之前，i从前向后寻找比基准元素大的元素，j从后向前找比基准元素小的元素,下面的两个while是算法的重点
			while(x<=A[j] && i<j) j-- ;//当j指向的元素比基准元素大且没有和i相遇时，j递减向前继续寻找比基准元素x小的元素
				A[i] = A[j] ;//找到比基准元素x小的元素时，将此元素赋值（覆盖）给i指向的元素，（初始时i指向为基准元素，已在x备份）
			while(x>=A[i] && i<j) i++ ;//当i指向的元素比基准元素小且没有和j相遇时，i递增向后继续寻找比基准元素x大的元素
			A[j] = A[i] ;//找到比基准元素x大的元素时，将此元素赋值（覆盖）给j指向的元素，（j指向的元素，已在前一个while中移动到数组的前半部分）
		}

		A[i] =x ;//最后i和j相遇，此时i=j，将基准元素赋值给A[i],此时数组变成（A,begin,i-1),A[i],(A,i+1,end)三部分
		return i;//返回基准元素位置索引
	}
	public static void quicksort(int[] A,int begin,int end) {//快速排序方法
		int p = partision(A,begin,end) ;//将输入数组划分
		//+++++++++++++++++++++++此代码为演示输出代码+++++++++++++++++++++++
		System.out.print("第" + (++count) + "次排序后：");
		System.out.print("(");
		for(int m=0;m<p;m++) 
			System.out.print(A[m]);	
		System.out.print(")(" + A[p] + ")(");
		for(int m=p+1;m<end+1;m++) 
			System.out.print(A[m]);
		System.out.print(") " + "基准元素是：" + A[p] + "\n");
		//+++++++++++++++++++++++此代码为演示输出代码+++++++++++++++++++++++
		if(begin<p-1) //begin小于end说明数组元素大于一个，还可以继续进行排序
		quicksort(A,begin,p-1) ;//对基准元素前半部分数组进行排序
		if(p+1<end)
		quicksort(A,p+1,end) ;//对基准元素后半部分数组进行排序
	}
	
	public static void main(String[] args) {
		int[] A = {5,1,8,7,6,2,3,4} ;
		quicksort(A,0,A.length-1) ;
		for(int i=0;i<A.length;i++)
		System.out.print(A[i] + ",");
	}
}
