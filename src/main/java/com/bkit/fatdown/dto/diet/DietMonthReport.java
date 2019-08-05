package com.bkit.fatdown.dto.diet;

/**
 * @file: DietMonthReport
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 每月饮食评价
 * @date: Created in 8/5/19  10:20 AM
 * @modified:
 * @version: 1.0
 */
public class DietMonthReport extends DietWeeklyReport {
    private MineralEvaluation mineralEvaluation;
    private VitaminEvaluation vitaminEvaluation;
    private FibrinEvaluation fibrinEvaluation;

    public DietMonthReport() {
        super();
        init();
    }

    @Override
    public void init() {
        super.init();
        this.mineralEvaluation = new MineralEvaluation();
        this.vitaminEvaluation = new VitaminEvaluation();
        this.fibrinEvaluation = new FibrinEvaluation();
    }

    public MineralEvaluation getMineralEvaluation() {
        return mineralEvaluation;
    }

    public void setMineralEvaluation(MineralEvaluation mineralEvaluation) {
        this.mineralEvaluation = mineralEvaluation;
    }

    public VitaminEvaluation getVitaminEvaluation() {
        return vitaminEvaluation;
    }

    public void setVitaminEvaluation(VitaminEvaluation vitaminEvaluation) {
        this.vitaminEvaluation = vitaminEvaluation;
    }

    public FibrinEvaluation getFibrinEvaluation() {
        return fibrinEvaluation;
    }

    public void setFibrinEvaluation(FibrinEvaluation fibrinEvaluation) {
        this.fibrinEvaluation = fibrinEvaluation;
    }
}
