package com.bkit.fatdown.dto.diet;

/**
 * @file: EnergyEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 能量达标评价
 * @date: Created in 8/5/19  3:58 PM
 * @modified:
 * @version: 1.0
 */
public class EnergyEvaluation extends Evaluation {
    private int bad;

    public EnergyEvaluation() {
        super();
        init();
    }

    public EnergyEvaluation(int excellent, int good, int ordinary, int bad) {
        super(excellent, good, ordinary);
        this.bad = bad;
    }

    @Override
    public void init() {
        super.init();
        this.bad = 0;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }
}
