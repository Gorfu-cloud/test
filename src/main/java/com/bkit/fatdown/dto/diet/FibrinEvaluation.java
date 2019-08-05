package com.bkit.fatdown.dto.diet;

/**
 * @file: FibrinEvaluation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 纤维素评价
 * @date: Created in 8/5/19  4:56 PM
 * @modified:
 * @version: 1.0
 */

public class FibrinEvaluation {
    private TotalEvaluation solubleFiber;
    private TotalEvaluation insolubleFiber;

    public FibrinEvaluation() {
        init();
    }

    private void init() {
        this.insolubleFiber = new TotalEvaluation();
        this.solubleFiber = new TotalEvaluation();
    }

    public TotalEvaluation getSolubleFibers() {
        return solubleFiber;
    }

    public void setSolubleFibers(TotalEvaluation solubleFiber) {
        this.solubleFiber = solubleFiber;
    }

    public TotalEvaluation getInsolubleFiber() {
        return insolubleFiber;
    }

    public void setInsolubleFiber(TotalEvaluation insolubleFiber) {
        this.insolubleFiber = insolubleFiber;
    }
}
