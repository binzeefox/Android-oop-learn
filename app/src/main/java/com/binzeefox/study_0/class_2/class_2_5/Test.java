package com.binzeefox.study_0.class_2.class_2_5;

public class Test {
    private static final String TAG = "Test";

    public void start() {
        Company cp = new Company();
        //通过getCeo函数获取CEO
        Staff ceo1 = CEO.getCeo();
        Staff ceo2 = CEO.getCeo();
        cp.addStaff(ceo1);
        cp.addStaff(ceo2);
        //通过new创建VP
        Staff vp1 = new VP();
        Staff vp2 = new VP();
        cp.addStaff(vp1);
        cp.addStaff(vp2);
        //通过new创建staff
        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        Staff staff3 = new Staff();
        cp.addStaff(staff1);
        cp.addStaff(staff2);
        cp.addStaff(staff3);

        cp.showAllStaffs();
    }
}
