package five;

public class Array_06 {
	public static void main(String[] args) {
		int[] src = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] dest = { 11, 12, 13, 14, 15, 16, 17, 18 };
		dest = arraycopy(src, 1, dest, 2, 3);
		for (int i = 0; i < dest.length; i++) {
			// 11, 12, 2, 3, 4, 13, 14, 15, 16, 17, 18
			System.out.print(dest[i] + " ");
		}
	}

	/**
	 * 数组插入式复制
	 * 
	 * @param src       源数组
	 * @param srcIndex  源数组 起始索引(包含)
	 * @param dest      目标数组
	 * @param destIndex 目标数组 起始索引(插入到该索引之后)
	 * @param length    插入个数
	 * @return 返回新的数组,因为数组长度一旦确定,长度不可更改,既然是插入数据,肯定会扩大长度,所以只能新建数组,用于容纳更多的元素
	 *         并把新数组地址返回给调用处
	 */
	public static int[] arraycopy(int[] src, int srcIndex, int[] dest, int destIndex, int length) {
		// 1 确定新数组长度,并创建新数组
		// 新长度为 dest.length + length
		int[] newDest = new int[dest.length + length];

		// 2 把目标数组起始位置之前的数据,全部拿到新数组中(包含)
		int i = 0;
		for (; i < destIndex; i++) {
			newDest[i] = dest[i];
		}
		int j = i;
		// 3 把源数组起始位置(包含)开始,复制到新数组中,复制length个
		// 此时 向newDest添加元素时需从i开始
		for (; i < srcIndex + length + 1; i++) {
			// 新数组起始位置为 : 目标数组起始索引 + 1
			newDest[i] = src[i - 1];
		}

		for (int k = 0; k < newDest.length; k++) {
			System.out.print(newDest[k] + " ");
		}
		System.out.println();
		// 4 把目标数组起始位置之后的数据,添加到新数组中
		// 原dest向newDest复制元素是要从索引j开始

		for (; j < dest.length; i++) {
			newDest[i] = dest[j];
			j++;
		}
		return newDest;
	}

}
