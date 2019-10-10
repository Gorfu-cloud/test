package com.bkit.fatdown.dto.food;

import java.io.Serializable;
import java.util.List;

/**
 * @file: RecommendListDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式推荐，偏多或偏少
 * @date: Created in 10/10/19  10:29 AM
 * @modified:
 * @version: 1.0
 */

public class RecommendListDTO implements Serializable {

    private List<Integer> lack ;
    private List<Integer> more ;

    public RecommendListDTO() {
    }

    public RecommendListDTO(List<Integer> lack, List<Integer> more) {
        this.lack = lack;
        this.more = more;
    }

    public List<Integer> getLack() {
        return lack;
    }

    public void setLack(List<Integer> lack) {
        this.lack = lack;
    }

    public List<Integer> getMore() {
        return more;
    }

    public void setMore(List<Integer> more) {
        this.more = more;
    }

    @Override
    public String toString() {
        return "RecommendListDTO{" +
                "lack=" + lack +
                ", more=" + more +
                '}';
    }
}
