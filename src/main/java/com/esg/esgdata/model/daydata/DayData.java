package com.esg.esgdata.model.daydata;

import com.esg.esgdata.model.cash.CashItem;
import com.esg.esgdata.model.catering.CateringOrder;
import com.esg.esgdata.model.prep.PrepItem;
import com.esg.esgdata.model.prep.PrepType;
import com.esg.esgdata.model.task.TaskCategory;
import com.esg.esgdata.model.task.TaskItem;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayData implements Serializable {
    /*@Id
    private LocalDate date;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "TASK_LIST_DATE")
    private List<TaskItem> taskItems = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "date")
    private List<PrepItem> prepItems = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "CATERING_LIST_DATE")
    private List<CateringOrder> cateringOrders = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "CASH_LIST_DATE")
    private List<CashItem> cashLog = new ArrayList<>();
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<String> praises = new ArrayList<>();
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<String> redirects = new ArrayList<>();
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<String> notes = new ArrayList<>();

    public DayData(){}
    public DayData(LocalDate date)
    {
        this.date = date;
    }

    public void addTask(TaskItem taskItem) {
        taskItems.add(taskItem);
    }
    public List<PrepItem> getAllPrepItem() {
        return prepItems;
    }

    public void addCateringOrder(CateringOrder cateringOrder){
        cateringOrders.add(cateringOrder);
    }

    public List<CateringOrder> getCateringOrders()
    {
        Collections.sort(cateringOrders);
        return cateringOrders;
    }

    public void activateTasksOfType(TaskCategory taskCategory)
    {
        for(TaskItem taskItem : taskItems)
        {
            if(taskItem.getCategory() == taskCategory)
            {
                taskItem.setActive(true);
            }
        }
    }

    public ArrayList<PrepItem> getPrepItemOfType(PrepType prepType) {
        ArrayList<PrepItem> typedPrep = new ArrayList<>();
        for(PrepItem p: prepItems)
        {
            if(p.getPrepType() == prepType)
                typedPrep.add(p);
        }
        return typedPrep;
    }

    public List<TaskItem> getAllTasks() {
        return taskItems;
    }

    public void setPrepItems(ArrayList<PrepItem> items) {
        prepItems = items;
    }
    public void setTaskItems(ArrayList<TaskItem> items) {
        taskItems = items;
    }

    public void addPraise(String praise)
    {
        praises.add(praise);
    }

    public void addRedirect(String redirect)
    {
        redirects.add(redirect);
    }

    public void addNote(String note)
    {
        notes.add(note);
    }

    public List<CashItem> getCashLog() {
        return cashLog;
    }

    public void addCashItem(CashItem cashItem)
    {
        cashLog.add(cashItem);
    }
    public List<String> getPraises()
    {
        return praises;
    }

    public List<String> getRedirects()
    {
        return redirects;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void removePrep(String prepName) {
        PrepItem remove = null;
        for(PrepItem prep: prepItems)
        {
            if(prep.getDesc().equals(prepName))
                remove = prep;
        }
        if(remove != null)
            removePrep(remove);
    }
    public void addPrepItem(PrepItem prep) {
        prepItems.add(prep);
    }

    public void removePrep(PrepItem prepItem)
    {
        prepItems.remove(prepItem);
    }

    @Override
    public String toString() {
        return "DayData{" +
                "date=" + date +
                ", taskItems=" + taskItems +
                ", prepItems=" + prepItems +
                ", cateringOrders=" + cateringOrders +
                ", cashLog=" + cashLog +
                ", praises=" + praises +
                ", redirects=" + redirects +
                ", notes=" + notes +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }*/
}
