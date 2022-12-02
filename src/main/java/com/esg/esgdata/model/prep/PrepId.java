package com.esg.esgdata.model.prep;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PrepId implements Serializable {
    private String desc;
    private LocalDate date;

    public PrepId(){}
    public PrepId(String desc, LocalDate date) {
        this.desc = desc;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrepId prepId = (PrepId) o;
        return desc == prepId.desc &&
                date == prepId.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(desc, date);
    }
}
