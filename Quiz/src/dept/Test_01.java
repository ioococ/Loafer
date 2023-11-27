package dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Wang
 * @date 23-3-25
 */
public class Test_01 {
    /**
     * 给出示例数据，包括不同的学院，每个学院有不同的专业，每个专业有不同的班，
     * 现在要求用所学的集合的知识，把他们组装好，班级放到专业里，专业放到学院里
     *
     * @param args
     */
    public static void main(String[] args) {
        //示例数据
        List<SysDept> list = new ArrayList<>();
        SysDept sysDept = new SysDept(0L, null, "信息学院");
        SysDept sysDept22 = new SysDept(1L, null, "影视学院");

        SysDept sysDept1 = new SysDept(101L, 0L, "软件工程");
        SysDept sysDept2 = new SysDept(102L, 0L, "计算机科学与技术");
        SysDept sysDept3 = new SysDept(103L, 0L, "网络工程");

        SysDept sysDept4 = new SysDept(501L, 101L, "软件1班");
        SysDept sysDept5 = new SysDept(502L, 101L, "软件2班");
        SysDept sysDept6 = new SysDept(503L, 101L, "软件3班");

        SysDept sysDept7 = new SysDept(601L, 102L, "计算机1班");
        SysDept sysDept8 = new SysDept(602L, 102L, "计算机2班");
        SysDept sysDept9 = new SysDept(603L, 102L, "计算机3班");

        SysDept sysDept10 = new SysDept(701L, 103L, "网络1班");
        SysDept sysDept11 = new SysDept(702L, 103L, "网络2班");
        SysDept sysDept12 = new SysDept(703L, 103L, "网络3班");
        SysDept sysDept13 = new SysDept(703L, 103L, "网络3班");
        SysDept sysDept14 = new SysDept(703L, 103L, "网络3班");
        SysDept sysDept15 = new SysDept(703L, 103L, "网络3班");
        SysDept sysDept16 = new SysDept(703L, 103L, "网络3班");

        list.add(sysDept);
        list.add(sysDept1);
        list.add(sysDept2);
        list.add(sysDept3);
        list.add(sysDept4);
        list.add(sysDept5);
        list.add(sysDept6);
        list.add(sysDept7);
        list.add(sysDept8);
        list.add(sysDept9);
        list.add(sysDept10);
        list.add(sysDept11);
        list.add(sysDept12);
        list.add(sysDept13);
        list.add(sysDept22);
//        System.out.println(list);
        List<SysDept> deptTree = getDeptTree(list);
        System.out.println(deptTree);
    }

    /**
     * 演示代码
     *
     * @param list
     * @return
     */
//    public static List<SysDept> getDeptTree(List<SysDept> list) {
//        List<SysDept> rootParentDept = new ArrayList<>();
//        for (SysDept sysDept : list) {
//            if (sysDept.getParentId() == null) {
//                rootParentDept.add(sysDept);
//            }
//        }
//
//        // 添加次级Dept列表至根Dept列表
//        List<SysDept> secondParentDept = null;
//        for (int i = 0; i < rootParentDept.size(); i++) {
//            secondParentDept = new ArrayList<>();
//            for (SysDept sysDept : list) {
//                if (rootParentDept.get(i).getDeptId() == sysDept.getParentId() && sysDept.getParentId() != null) {
//                    secondParentDept.add(sysDept);
//                }
//            }
//            rootParentDept.get(i).setChildren(secondParentDept);
//        }
//
//        // 添加三级Dept列表至次Dept列表
//        List<SysDept> thirdParentDept = null;
//        for (SysDept rootSysDept : rootParentDept) {
//            // 获得次级列表
//            List<SysDept> secondSysDept = rootSysDept.getChildren();
//            // 在信息学院中secondSysDept有三个 分别为 软件工程 计算机科学与技术与网络工程
//            // 主循环循环一次次级列表循环三次
//            for (SysDept dept : secondSysDept) {
//                thirdParentDept = new ArrayList<>();
//                for (SysDept sysDept : list) {
//                    // 三级列表的父元素ID要等于次级列表的元素ID
//                    if (dept.getDeptId() == sysDept.getParentId() && sysDept.getParentId() != null) {
//                        thirdParentDept.add(sysDept);
//                    }
//                }
//                dept.setChildren(thirdParentDept);
//            }
//        }
//        return rootParentDept;
//    }
    public static List<SysDept> getDeptTree(List<SysDept> list) {
        Map<Long, SysDept> sysDeptMap = new HashMap<>();
        ArrayList<SysDept> sysDepts = new ArrayList<>();
        for (SysDept sysDept : list) {
            sysDeptMap.put(sysDept.getDeptId(), sysDept);
        }
        for (SysDept sysDept : list) {
            if (sysDept.getParentId() == null){
                sysDepts.add(sysDept);
            } else {
                SysDept parentDept = sysDeptMap.get(sysDept.getParentId());
                List<SysDept> children = parentDept.getChildren();
                if (children == null){
                    children = new ArrayList<SysDept>();
                }
                children.add(sysDept);
                parentDept.setChildren(children);
            }
        }
        return sysDepts;
    }

}
