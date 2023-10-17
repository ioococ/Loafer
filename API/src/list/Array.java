package list;

/**
 * 封装数组,提供增删改查等方法,方便操作
 * 
 * @author 天亮教育-帅气多汁你泽哥
 * @Date 2023年10月17日
 */
public class Array {
	private Object[] elements = new Object[0];

	/**
	 * 添加方法
	 * 
	 * @param element
	 */
	public void add(Object element) {
		Object[] newArr = new Object[elements.length + 1];
		for (int i = 0; i < elements.length; i++) {
			newArr[i] = elements[i];
		}
		newArr[newArr.length - 1] = element;
		elements = newArr;
	}

	/**
	 * 根据下标删除
	 * 
	 * @param index
	 */
	public void remove(int index) {
		// 判断是否越界
		if (index < 0 || index >= elements.length) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		// 创建新数组,长度为原数组长度-1
		Object[] newArr = new Object[elements.length - 1];
		// 遍历原数组,把非element的值添加到新数组中
		int newArrIndex = 0;
		for (int i = 0; i < elements.length; i++) {
			if (index == i) {
				continue;
			} else {
				newArr[newArrIndex] = elements[i];
				newArrIndex++;
			}
		}
		elements = newArr;

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
		// 统计多少相同元素个数
		int count = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(element)) {
				count++;
			}
		}
		if (count == 0) {
			return;
		}
		// 确定新数组长度
		Object[] newArr = new Object[elements.length - count];
		// 循环遍历复制新数组中
		int newArrIndex = 0;
		for (int i = 0; i < newArr.length; i++) {
			if (elements[i].equals(element)) {
				continue;
			} else {
				newArr[newArrIndex] = elements[i];
				newArrIndex++;
			}
		}
		elements = newArr;
	}

	/**
	 * 根据元素获取下标,找不到则返回-1
	 * 
	 * @param element
	 * @return
	 */
	public int indexOf(Object element) {

		for (int i = 0; i < elements.length; i++) {
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
		for (int i = 0; i < elements.length; i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 修改
	 * 
	 * @param index
	 */
	public void set(int index, Object element) {
		elements[index] = element;
	}

	/**
	 * 根据下标查询元素
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		return elements[index];
	}

	/**
	 * 数组遍历
	 */
	public void forEach() {
		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
		}
	}

	/**
	 * 获取数组长度
	 * 
	 * @return
	 */
	public int length() {
		return elements.length;
	}
}
