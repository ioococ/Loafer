package com.my.reg;

public class H {
    private Register reg;
    private Diagnosis dia;
    private Pay pay;
    private Medicine med;
    private Hospitalized hos;
    private CT ct;
    private Operation ope;

    public void setReg(Register reg) {
        this.reg = reg;
    }

    public void setDia(Diagnosis dia) {
        this.dia = dia;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public void setMed(Medicine med) {
        this.med = med;
    }

    public void setHos(Hospitalized hos) {
        this.hos = hos;
    }

    public void setCt(CT ct) {
        this.ct = ct;
    }

    public void setOpe(Operation ope) {
        this.ope = ope;
    }

    public void curing() {
        System.out.println("发现疾病");
        reg.success();
        dia.success();
        pay.success();
        med.success();
        hos.success();
        ct.success();
        ope.success();
    }
}
