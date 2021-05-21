package com.devandy.springaopstudy.history;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class History {
    @Id
    @GeneratedValue
    private long idx;

    @Column
    private long userIdx;

    @Column
    private LocalDateTime localDateTime;

    public History() { }

    public History(long userIdx, LocalDateTime updateDate) {
        this.userIdx = userIdx;
        this.localDateTime = updateDate;
    }

    public long getIdx() {
        return idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(long userIdx) {
        this.userIdx = userIdx;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "History{" +
                "idx=" + idx +
                ", userIdx=" + userIdx +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
