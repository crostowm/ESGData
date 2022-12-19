package com.esg.esgdata.io;

import com.esg.esgdata.model.cash.CashItem;
import com.esg.esgdata.model.catering.CateringOrder;
import com.esg.esgdata.model.comment.Comment;
import com.esg.esgdata.model.daysales.DaySales;
import com.esg.esgdata.model.execution.ExecutionChart;
import com.esg.esgdata.model.prep.PrepItem;
import com.esg.esgdata.model.prep.PrepTemplate;
import com.esg.esgdata.model.setting.Setting;
import com.esg.esgdata.model.task.TaskItem;
import com.esg.esgdata.model.task.TaskTemplate;
import com.esg.esgdata.staff.Employee;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Backup implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDateTime date;
    private List<CashItem> cashItems = new ArrayList<>();
    private List<CateringOrder> cateringOrders = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<DaySales> daySales = new ArrayList<>();
    private List<ExecutionChart> executionCharts = new ArrayList<>();
    private List<PrepItem> prepItems = new ArrayList<>();
    private List<PrepTemplate> prepTemplates = new ArrayList<>();
    private List<Setting> settings = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<TaskItem> taskItems = new ArrayList<>();
    private List<TaskTemplate> taskTemplates = new ArrayList<>();

    public Backup(LocalDateTime date) {
        this.date = date;
    }

    public void setCashItems(List<CashItem> cashItems) {
        this.cashItems = cashItems;
    }

    public void setCateringOrders(List<CateringOrder> cateringOrders) {
        this.cateringOrders = cateringOrders;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setDaySales(List<DaySales> daySales) {
        this.daySales = daySales;
    }

    public void setExecutionCharts(List<ExecutionChart> executionCharts) {
        this.executionCharts = executionCharts;
    }

    public void setPrepItems(List<PrepItem> prepItems) {
        this.prepItems = prepItems;
    }

    public void setPrepTemplates(List<PrepTemplate> prepTemplates) {
        this.prepTemplates = prepTemplates;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setTaskItems(List<TaskItem> taskItems) {
        this.taskItems = taskItems;
    }

    public void setTaskTemplates(List<TaskTemplate> taskTemplates) {
        this.taskTemplates = taskTemplates;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<CashItem> getCashItems() {
        return cashItems;
    }

    public List<CateringOrder> getCateringOrders() {
        return cateringOrders;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<DaySales> getDaySales() {
        return daySales;
    }

    public List<ExecutionChart> getExecutionCharts() {
        return executionCharts;
    }

    public List<PrepItem> getPrepItems() {
        return prepItems;
    }

    public List<PrepTemplate> getPrepTemplates() {
        return prepTemplates;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<TaskItem> getTaskItems() {
        return taskItems;
    }

    public List<TaskTemplate> getTaskTemplates() {
        return taskTemplates;
    }

    @Override
    public String toString() {
        return "Backup{" +
                "date=" + date +
                ", \ncashItems=" + cashItems +
                ", \ncateringOrders=" + cateringOrders +
                ", \ncomments=" + comments +
                ", \ndaySales=" + daySales +
                ", \nexecutionCharts=" + executionCharts +
                ", \nprepItems=" + prepItems +
                ", \nprepTemplates=" + prepTemplates +
                ", \nsettings=" + settings +
                ", \nemployees=" + employees +
                ", \ntaskItems=" + taskItems +
                ", \ntaskTemplates=" + taskTemplates +
                '}';
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
