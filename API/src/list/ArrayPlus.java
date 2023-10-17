package list;

/**
 * 封装数组,提供增删改查等方法,方便操作
 * 
 * @author 天亮教育-帅气多汁你泽哥
 * @Date 2023年10月17日
 */
public class ArrayPlus {
	/**
	 * 默认容量为0,第一次添加时初始化容量为10,默认扩容倍数为1.5倍
	 */
	private Object[] elements = new Object[0];

	/**
	 * 已添加元素个数
	 */
	private int size = 0;

	/**
	 * 添加方法
	 * 
	 * @param element
	 */
	public void add(Object element) {
		// 判断是否初始化
		if (elements.length == 0) {
			elements = new Object[10];
		}
		int length = elements.length;

		// 判断是否放满了
		if (size == length) {
			// 扩容为1.5倍
			int newLength = length + (length >> 1);
			// 创建新数组
			Object[] newArr = new Object[newLength];
			// 把源数组内容复制进新数组中去
			for (int i = 0; i < elements.length; i++) {
				newArr[i] = elements[i];
			}
			// 把新数组复制给elements
			elements = newArr;
		}
		// 添加新数组
		// 1 2 3 4 5 0 0 0 0 size = 5
		// 1 2 3 4 5 6 0 0 0
		elements[size] = element;
		size++;
	}

	/**
	 * 根据下标删除
	 * 
	 * @param index
	 */
	public void remove(int index) {
		// 判断是否越界
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		// 1 2 4 5 null null null 0 0 0 size = 4 length = 10 index = 2
		// 从 index+1 开始 到 size-1 都向前移动一位
		for (int i = index; i < size - 1; i++) {
			elements[i] = elements[i + 1];
		}
		// size-1 赋值为 null
		elements[size - 1] = null;
		// size--
		size--;
	}

	/**
	 * 根据元素内容删除,只删除第一个符合条件的
	 * 
	 * @param element
	 */
	public void remove(Object element) {
		// 判断是否包含这个元素,如果包含,则获取第一个出现该元素的下标
		int index = indexOf(element);
		if (index != -1) {
			remove(index);
			// // 创建新数组,长度为原数组长度-1
			// Object[] newArr = new Object[elements.length - 1];
			// // 遍历原数组,把非element的值添加到新数组中
			// int newArrIndex = 0;
			// for (int i = 0; i < elements.length; i++) {
			// if (index == i) {
			// continue;
			// } else {
			// newArr[newArrIndex] = elements[i];
			// newArrIndex++;
			// }
			// }
			// elements = newArr;
		}

	}

	/**
	 * 根据元素内容删除,删除所有与指定元素相同的数据
	 * 
	 * @param element
	 */
	public void removeAll(Object element) {
		// int index = indexOf(element);
		// while (index != -1) {
		// remove(index);
		// index = indexOf(element);
		// }
		// 1 1 1 2 2 2 5 null 5 null size = 9 length = 10 e=3 c=7
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (!elements[i].equals(element)) {
				elements[count] = elements[i];
				count++;
			}
		}
		// 把删除的元素 赋值为null
		for (int i = count; i < size; i++) {
			elements[i] = null;
		}
		// 重新设置size的值
		size = count;
	}

	/**
	 * 根据元素获取下标,找不到则返回-1
	 * 
	 * @param element
	 * @return
	 */
	public int indexOf(Object element) {

		for (int i = 0; i < size; i++) {
			if (elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 判断是否包含某个元素
	 * 
	 * @param element
	 * @return
	 */
	public boolean contains(Object element) {
		// for (int i = 0; i < size; i++) {
		// if (elements[i].equals(element)) {
		// return true;
		// }
		// }
		int index = indexOf(element);
		return index != -1 ? true : false;
	}

	/**
	 * 修改
	 * 
	 * @param index
	 */
	public void set(int index, Object element) {
		// 1 2 3 4 5 0 0 0 0 0
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		elements[index] = element;
	}

	/**
	 * 根据下标查询元素
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return elements[index];
	}

	/**
	 * 数组遍历
	 */
	public void forEach() {
		for (int i = 0; i < size; i++) {
			System.out.println(elements[i]);
		}
	}

	/**
	 * 获取数组元素个数
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}
}
